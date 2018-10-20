package com.pmt.pcommon.context;

import lombok.Data;

public @Data class PMTUserContext {

	private String sysOwnerCd;
	
	private String userId;
	
	private String userNm;
	
	private String displayNm;
	
	public String getSysOwnerCd() {
		return sysOwnerCd;
	}

	public void setSysOwnerCd(String sysOwnerCd) {
		this.sysOwnerCd = sysOwnerCd;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserNm() {
		return userNm;
	}

	public void setUserNm(String userNm) {
		this.userNm = userNm;
	}

	public String getDisplayNm() {
		return displayNm;
	}

	public void setDisplayNm(String displayNm) {
		this.displayNm = displayNm;
	}
	
}