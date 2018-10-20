package com.pmt.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import com.pmt.pcommon.model.Auditable;

import lombok.Data;

@Entity
@Table(name="employee")
@NamedQuery(name="Employee.findAll", query="SELECT e FROM Employee e")
public @Data class Employee extends Auditable<String> implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private EmployeePK id;

	@Column(name="emp_name")
	private String empName;
	
	@Column(name="date_of_birth")
	private String dateOfBirth;

	@Column(name="update_counter")
	private Integer updateCounter;

	@Column(name="update_program")
	private String updateProgram;
	
	public Employee() {
	}

	public Employee(EmployeePK id, 
					String empName, 
					String dateOfBirth, 
					Integer updateCounter, 
					String updateProgram){
		
		super();
		this.id = id;
		this.empName = empName;
		this.dateOfBirth = dateOfBirth;
		this.updateCounter = updateCounter;
		this.updateProgram = updateProgram;
	}
}