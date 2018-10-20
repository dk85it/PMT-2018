package com.pmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pmt.entity.Employee;
import com.pmt.entity.EmployeePK;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,EmployeePK> {
}
