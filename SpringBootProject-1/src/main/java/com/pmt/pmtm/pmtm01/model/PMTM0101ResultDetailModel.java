package com.pmt.pmtm.pmtm01.model;


import com.pmt.pcommon.model.BaseScreenDetailModel;

import lombok.Data;

@Data
public  class PMTM0101ResultDetailModel extends BaseScreenDetailModel{

	private static final long serialVersionUID = 1L;
	
	private String ein;
	private String empName;
	private String empDateOfBirth;
	
	private String status;
	private String statusCd;
	private int    errorCount;
	private String errorMsg;
	private String errorFieldGrid;
	private String errorFlag = "false";
	
}
