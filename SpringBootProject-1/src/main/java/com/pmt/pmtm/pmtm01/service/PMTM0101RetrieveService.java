package com.pmt.pmtm.pmtm01.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.pmt.entity.Employee;
import com.pmt.pcommon.model.RowStatus;
import com.pmt.pmtm.pmtm01.dto.PMTM0101DTO;
import com.pmt.pmtm.pmtm01.model.PMTM0101ResultDetailModel;
import com.pmt.pmtm.pmtm01.model.PMTM0101ResultModel;
import com.pmt.repository.EmployeeDaoImpl;


@Service
public class PMTM0101RetrieveService {

	@Inject
	private EmployeeDaoImpl employeeDaoImpl;
	
	public List<PMTM0101ResultDetailModel> getRecords(PMTM0101DTO itrm0101Dto, String userContext) {
		
		List<PMTM0101ResultDetailModel> detailList = new ArrayList<>();
		PMTM0101ResultModel resultModel = itrm0101Dto.getResultModel();

		List<Employee> list = employeeDaoImpl.getEmployeeList(userContext, resultModel.getEin());
	
		for (Employee ms : list) {
			
				PMTM0101ResultDetailModel detailModel = new PMTM0101ResultDetailModel();
				
				detailModel.setEin(ms.getId().getEin());
				detailModel.setEmpName(ms.getEmpName());
				detailModel.setEmpDateOfBirth(ms.getDateOfBirth());
				detailModel.setRowStatus(RowStatus.NOTMODIFY);
				detailModel.setErrorFlag("false");
				detailList.add(detailModel);
		}
		
		if(detailList.size() == 0)
			resultModel.setSuccessMessage("No data found");
		else
			resultModel.setSuccessMessage(detailList.size() + " Rows found");
		return detailList;
	}
}