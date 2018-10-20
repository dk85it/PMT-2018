package com.pmt.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;

@Embeddable
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public @Data class EmployeePK implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name="ein")
	private String ein;

	@Column(name="sys_owner_cd")
	private String sysOwnerCd;

	public EmployeePK() {
	}

	public EmployeePK(String ein, String sysOwnerCd) {
		this.ein = ein;
		this.sysOwnerCd = sysOwnerCd;
	}
	
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof EmployeePK)) {
			return false;
		}
		EmployeePK castOther = (EmployeePK)other;
		return 
			this.ein.equals(castOther.ein)
			&& this.sysOwnerCd.equals(castOther.sysOwnerCd);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.ein.hashCode();
		hash = hash * prime + this.sysOwnerCd.hashCode();
		
		return hash;
	}
}