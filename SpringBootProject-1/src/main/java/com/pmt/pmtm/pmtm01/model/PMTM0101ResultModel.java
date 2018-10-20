package com.pmt.pmtm.pmtm01.model;

import java.util.List;

import com.pmt.pcommon.model.BaseScreenModel;

import lombok.Data;

@Data
public class PMTM0101ResultModel extends BaseScreenModel{
	
	private String ein;
	private String status;
	private String dobDate;
	private String dobDateTo;
	private String errorFlag;
	private String jsonResult = "[]";
	private List<PMTM0101ResultDetailModel> result;
	
    public PMTM0101ResultModel() {

    }

}
