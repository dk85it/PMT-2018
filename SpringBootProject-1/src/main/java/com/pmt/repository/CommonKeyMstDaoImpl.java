package com.pmt.repository;

import org.springframework.beans.factory.annotation.Autowired;

public class CommonKeyMstDaoImpl{

	private CommonKeyMstDao commonMstDao;
	
	@Autowired
	public void setCommonKeyMstDao(CommonKeyMstDao commonMstDao) {
		this.commonMstDao = commonMstDao;
	}
	
	
	
	
}
