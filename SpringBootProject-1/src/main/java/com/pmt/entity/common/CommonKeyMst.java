package com.pmt.entity.common;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.pmt.pcommon.model.Auditable;

import lombok.Data;

@Entity
@Table(name="common_key_mst")
@NamedQuery(name="CommonKeyMst.findAll", query="SELECT c FROM CommonKeyMst c")
public @Data class CommonKeyMst extends Auditable<String> implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CommonKeyMstPK id;

	@Column(name="cd_data1")
	private String cdData1;

	@Column(name="cd_data2")
	private String cdData2;

	@Column(name="cd_data3")
	private String cdData3;

	@Column(name="update_counter")
	private Integer updateCounter;

	@Column(name="update_program")
	private String updateProgram;

	public CommonKeyMst() {
	}
	
	public String getCodeKey1IdStream(){
		return this.id.getCdKey1();
	}

	public String getCodeKey2IdStream(){
		return this.id.getCdKey2();
	}
	
	public CommonKeyMstPK getId() {
		return this.id;
	}

	public void setId(CommonKeyMstPK id) {
		this.id = id;
	}

	public CommonKeyMst(CommonKeyMstPK id, 
						String cdData1,
						String cdData2, 
						String cdData3, 
						Integer updateCounter,
						String updateProgram) {
		
		super();
		this.id = id;
		this.cdData1 = cdData1;
		this.cdData2 = cdData2;
		this.cdData3 = cdData3;
		this.updateCounter = updateCounter;
		this.updateProgram = updateProgram;
	}
	
	
	
}