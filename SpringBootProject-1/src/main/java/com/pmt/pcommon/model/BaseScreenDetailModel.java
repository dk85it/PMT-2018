package com.pmt.pcommon.model;

public class BaseScreenDetailModel extends CommonGridModel  {

	private static final long serialVersionUID = -4544416988292795213L;

	private Integer updateCounter;
	
	private String updateProgram;
	
	private Integer uid;

	private Integer boundindex;
	
	private String uniqueid;
	
	private Integer visibleindex;
	
	public Integer getUpdateCounter() {
		return updateCounter;
	}

	public void setUpdateCounter(Integer updateCounter) {
		this.updateCounter = updateCounter;
	}

	public String getUpdateProgram() {
		return updateProgram;
	}

	public void setUpdateProgram(String updateProgram) {
		this.updateProgram = updateProgram;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public Integer getBoundindex() {
		return boundindex;
	}

	public void setBoundindex(Integer boundindex) {
		this.boundindex = boundindex;
	}

	public String getUniqueid() {
		return uniqueid;
	}

	public void setUniqueid(String uniqueid) {
		this.uniqueid = uniqueid;
	}

	public Integer getVisibleindex() {
		return visibleindex;
	}

	public void setVisibleindex(Integer visibleindex) {
		this.visibleindex = visibleindex;
	}
}
