package com.pmt.pcommon.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;


public class CommonGridModel implements Serializable{

	private static final long serialVersionUID = 1191858569885346433L;
	
	@Setter
	@Getter
	private String rowStatus;
	
	public final boolean isNew(String rowState  ) {
		return rowState.equals(RowStatus.NEW) ? true:false;
	}
	
	public String getRowStatus() {
		return rowStatus;
	}

	public void setRowStatus(String rowStatus) {
		this.rowStatus = rowStatus;
	}

	public final boolean isNewModify(String rowState) {
		return rowState.equals(RowStatus.NEW_MODIFY) ? true:false;
	}
	
	public final boolean isModify(String rowState) {
		return rowState.equals(RowStatus.MODIFY) ? true:false;
	}
	
	public final boolean isDelete(String rowState) {
		return rowState.equals(RowStatus.DELETE) ? true:false;
	}
	
	public final boolean isNotModify(String rowState) {
		return rowState.equals(RowStatus.NOTMODIFY) ? true:false;
	}
	
	/**
	 *  Convert string type to defined {@link RowStatus} instance.
	 *  
	 * @param rowStatus Input string type row status.
	 * @return The {@code RowStatus} instance.
	 *//*
	private RowStatus return rowState.equals(RowStatus.NEW_MODIFY) ? true:false;(String rowStatus) {
		
		return rowStatus !=null ? RowStatus.of(rowStatus) : null;
 	}
	 */
}
