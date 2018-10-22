package com.pmt.pmtm.pmtm01.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.pmt.entity.Employee;
import com.pmt.entity.common.CommonKeyMst;
import com.pmt.pcommon.model.RowStatus;
import com.pmt.pmtm.pmtm01.dto.PMTM0101DTO;
import com.pmt.pmtm.pmtm01.model.PMTM0101ResultDetailModel;
import com.pmt.pmtm.pmtm01.model.PMTM0101ResultModel;
import com.pmt.repository.CommonKeyMstDao;
import com.pmt.repository.EmployeeDaoImpl;


@Service
public class PMTM0101RetrieveService {

	@Inject
	private EmployeeDaoImpl employeeDaoImpl;
	
	@Inject
	private CommonKeyMstDao codeMstDao;
	
	public List<PMTM0101ResultDetailModel> getRecords(PMTM0101DTO itrm0101Dto, String userContext) {
		
		List<PMTM0101ResultDetailModel> detailList = new ArrayList<>();
		PMTM0101ResultModel resultModel = itrm0101Dto.getResultModel();

		/*********************Status Map*********************/
		List<CommonKeyMst> codeMstStatus = codeMstDao.getCodeDataByCodeKey1("PMT", "100", "100");
		Map<String , String> mapStatus = codeMstStatus.stream().collect(Collectors.toMap(CommonKeyMst::getCodeKey2IdStream, CommonKeyMst::getCdData1));
		/*********************Status Map*********************/
		
		List<Employee> list = employeeDaoImpl.getEmployeeList(userContext, resultModel.getEin(), changeDateFormatToBasic(resultModel.getDobDate()), changeDateFormatToBasic(resultModel.getDobDateTo()));
	
		for (Employee ms : list) {
			
				PMTM0101ResultDetailModel detailModel = new PMTM0101ResultDetailModel();
				
				detailModel.setEin(ms.getId().getEin());
				detailModel.setEmpName(ms.getEmpName());
				detailModel.setEmpDateOfBirth(ms.getDateOfBirth());
				detailModel.setStatusCd(ms.getStatus());
				detailModel.setStatus(mapStatus.get(ms.getStatus()));
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
	
	// Date Format Change From "DD/MM/YYYY" To "YYYYMMDD".
	private String changeDateFormatToBasic(String str) {
		if (str != null && !str.trim().equals("")) {
			return LocalDate.parse(str, DateTimeFormatter.ofPattern("dd/MM/yyyy")).format(DateTimeFormatter.BASIC_ISO_DATE);
		}
		return "";
	}
}