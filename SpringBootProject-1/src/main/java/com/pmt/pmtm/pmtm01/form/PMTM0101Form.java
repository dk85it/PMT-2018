package com.pmt.pmtm.pmtm01.form;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import com.pmt.pmtm.pmtm01.model.PMTM0101ResultModel;

public class PMTM0101Form {
	
	@Valid
	@Autowired
    private PMTM0101ResultModel resultModel;
    
    public PMTM0101Form() {
        init();
    }

    void init() {
        this.resultModel = new PMTM0101ResultModel();
    }

	public PMTM0101ResultModel getResultModel() {
		return resultModel;
	}

	public void setResultModel(PMTM0101ResultModel resultModel) {
		this.resultModel = resultModel;
	}
}
