package com.pmt.entity.common;

import java.io.Serializable;
import javax.persistence.*;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;

@Embeddable
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public @Data class CommonKeyMstPK implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name="sys_owner_cd")
	private String sysOwnerCd;

	@Column(name="cd_id")
	private String cdId;

	@Column(name="cd_key1")
	private String cdKey1;

	@Column(name="cd_key2")
	private String cdKey2;

	public CommonKeyMstPK() {
	}
	

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof CommonKeyMstPK)) {
			return false;
		}
		CommonKeyMstPK castOther = (CommonKeyMstPK)other;
		return 
			this.sysOwnerCd.equals(castOther.sysOwnerCd)
			&& this.cdId.equals(castOther.cdId)
			&& this.cdKey1.equals(castOther.cdKey1)
			&& this.cdKey2.equals(castOther.cdKey2);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.sysOwnerCd.hashCode();
		hash = hash * prime + this.cdId.hashCode();
		hash = hash * prime + this.cdKey1.hashCode();
		hash = hash * prime + this.cdKey2.hashCode();
		
		return hash;
	}
}