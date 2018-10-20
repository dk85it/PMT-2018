package com.pmt.pmtm.pmtm01.dto;

import javax.validation.Valid;
import com.pmt.pmtm.pmtm01.model.PMTM0101ResultModel;

public class PMTM0101DTO {
	
	@Valid
    private PMTM0101ResultModel resultModel;
    
    /**
     * Constructor
     */
    public PMTM0101DTO() {

        init();
    }

    /**
     * Initialize
     */
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
