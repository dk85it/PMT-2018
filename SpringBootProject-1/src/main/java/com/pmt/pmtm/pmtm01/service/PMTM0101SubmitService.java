package com.pmt.pmtm.pmtm01.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringJoiner;
import java.util.stream.Collectors;

import javax.inject.Inject;

import org.h2.util.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pmt.entity.Employee;
import com.pmt.entity.EmployeePK;
import com.pmt.pcommon.constants.PMTCodeMstListConstants;
import com.pmt.pcommon.model.RowStatus;
import com.pmt.pmtm.pmtm01.dto.PMTM0101DTO;
import com.pmt.pmtm.pmtm01.model.PMTM0101ResultDetailModel;
import com.pmt.pmtm.pmtm01.model.PMTM0101ResultModel;
import com.pmt.repository.EmployeeDaoImpl;


@Service
public class PMTM0101SubmitService {

	@Inject
	private EmployeeDaoImpl employeeDaoImpl;
	
	@Transactional
	public Boolean save(PMTM0101DTO dto, String sysOwnerCd) {

		PMTM0101ResultModel resultModel = dto.getResultModel();
		List<PMTM0101ResultDetailModel> detailModelList = resultModel.getResult();
		List<Employee> insertList = new ArrayList<Employee>();
		List<Employee> deleteList = new ArrayList<Employee>();

		List<String> list = detailModelList.stream().filter(this::filterByRowStatus).map(a -> a.getEin()).collect(Collectors.toList());
		list.add("-1");
		
		List<Employee> listItrMtMst = employeeDaoImpl.getEmployeeEntityByEinList(list, "PMT");
		
		Map<EmployeePK, Employee> employeeMst = listItrMtMst.stream().collect(Collectors.toMap(Employee::getId, a -> a));

		Boolean errorFlag = validateFormGrid(dto, "PMT", employeeMst);// will return
																// false if no
		if (errorFlag) {
			dto.getResultModel().setError(true);
			dto.getResultModel().setErrorMessage("Error Found!");
			return true;
		} else {
			for (PMTM0101ResultDetailModel detailModel : detailModelList) {
				
				if (detailModel.getRowStatus().equals(RowStatus.NEW_MODIFY)
						|| detailModel.getRowStatus().equals(RowStatus.MODIFY)) {
					
					EmployeePK id = new EmployeePK(detailModel.getEin(),"PMT");

					Employee employee = employeeMst.get(id);
					boolean newRecord = false;
					if (employee == null) {
						newRecord = true;
						employee = new Employee();
						employee.setId(id);
					}
					employee.setEmpName(detailModel.getEmpName());
					employee.setDateOfBirth(detailModel.getEmpDateOfBirth());
					employee.setStatus(detailModel.getStatusCd());
					if (!newRecord)
						employee.setUpdateCounter(employee.getUpdateCounter() + 1);
					else
						employee.setUpdateCounter(0);
					employee.setUpdateProgram("PMTM0101");
					if (newRecord)
						insertList.add(employee);
				}
				
				if (detailModel.getRowStatus().equals(RowStatus.DELETE)) {
					List<Employee> employeeList = employeeDaoImpl.getEmployeeList(sysOwnerCd, detailModel.getEin());
					deleteList.add(employeeList.get(0));
				}
			}
			
			employeeDaoImpl.saveAll(insertList);
			employeeDaoImpl.deleteAll(deleteList);
			
			
			String msg = "SuccessFully";
			StringJoiner strjoin = new StringJoiner(",");

			if (!insertList.isEmpty()) {
				strjoin.add(msg + " Added: " + insertList.size() + " rows");
				msg = "";
			}
			dto.getResultModel().setSuccessMessage(strjoin.toString());
		}
		return false;
	}

	private boolean filterByRowStatus(PMTM0101ResultDetailModel detailModel) {
		if (detailModel != null && (detailModel.getRowStatus().equals(RowStatus.NEW_MODIFY)
				|| detailModel.getRowStatus().equals(RowStatus.MODIFY))) {
			return true;
		}
		return false;
	}
	
	// Check Validation on Form
	public Boolean validateFormGrid(PMTM0101DTO dto, String sysOwnerCd, Map<EmployeePK, Employee> mapItrMtMst) {
		
		List<PMTM0101ResultDetailModel> detailModelList = dto.getResultModel().getResult();
		Set<String> einSet = new HashSet<String>();
		boolean errorFlag = false;
		
		for (PMTM0101ResultDetailModel detailModel : detailModelList) {

			if (detailModel.getRowStatus().equals(RowStatus.NEW_MODIFY)
					|| detailModel.getRowStatus().equals(RowStatus.MODIFY)) {

				StringJoiner errField = new StringJoiner(";");
				StringJoiner sjErrorMsg = new StringJoiner(", ");
				int errorCount = 0;

				if (StringUtils.isNullOrEmpty(detailModel.getEin())) {
					sjErrorMsg.add("EIN Code is required");
					errField.add(PMTCodeMstListConstants.Employee.code_string_ein);
					errorCount++;
				}
				if (StringUtils.isNullOrEmpty(detailModel.getEmpName())) {
					sjErrorMsg.add("Employee Name is required");
					errField.add(PMTCodeMstListConstants.Employee.code_string_empName);
					errorCount++;
				}
				if (StringUtils.isNullOrEmpty(detailModel.getEmpDateOfBirth())) {
					sjErrorMsg.add("Date of Birth is required");
					errField.add(PMTCodeMstListConstants.Employee.code_string_dateOfBirth);
					errorCount++;
				}
			
				if (errorCount > 0) {
					detailModel.setErrorMsg(sjErrorMsg.toString());
					detailModel.setErrorCount(errorCount);
					detailModel.setErrorFieldGrid(errField.toString());
					detailModel.setErrorFlag("true");
					errorFlag = true;
				} else {
					detailModel.setErrorFieldGrid("");
					detailModel.setErrorMsg("");
					detailModel.setErrorCount(errorCount);
				}
			}
		}

		return errorFlag;
	}
}
