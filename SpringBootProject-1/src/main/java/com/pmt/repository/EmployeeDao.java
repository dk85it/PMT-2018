package com.pmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pmt.entity.Employee;
import com.pmt.entity.EmployeePK;


public interface EmployeeDao extends JpaRepository<Employee, EmployeePK>{

	
}
