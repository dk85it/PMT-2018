package com.pmt.pcommon.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter(AccessLevel.PROTECTED)
@Setter(AccessLevel.PROTECTED)
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class Auditable<U> {

	@Column(name="create_author")
	@CreatedBy
	private String createAuthor;

	@Column(name="create_date")
	@CreatedDate
	private LocalDateTime createDate;

	@Column(name="update_author")
	@LastModifiedBy
	private String updateAuthor;

	@Column(name="update_date")
	@LastModifiedDate
	private LocalDateTime updateDate;
}
