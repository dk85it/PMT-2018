package com.pmt.pcommon.model;

/**
 * Grid Row Status
 *
 */
public class RowStatus {
	
	public final static String NEW 				= "!NEW";
	public final static String NEW_MODIFY 		= "!NEWMODIFY";
	public final static String MODIFY 			= "!DATAMODIFY";
	public final static String DELETE 			= "!DELETE";
	public final static String NOTMODIFY 		= "!NOTMODIFY";
	
	private String status;
	RowStatus(String status) {
		
		this.status = status;
	}
		
	/*public static RowStatus of(String status) {
		
		for (RowStatus item : RowStatus.values()) {
			
			if(item.status.equals(status)) {
				return item;
			}
		}
		return null;
		
	}*/
}
