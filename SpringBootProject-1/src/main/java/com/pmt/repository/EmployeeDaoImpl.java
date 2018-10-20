package com.pmt.repository;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Service;

import com.pmt.entity.Employee;
import com.pmt.pcommon.constants.PMTConstants;

import org.h2.util.StringUtils;

@Service
public class EmployeeDaoImpl {
	
	@Inject
	private EmployeeDao employeeDao;

	@PersistenceContext
	private EntityManager em;

	public List<Employee> getEmployeeList(String sysOwnerCd, String empId) {
		
		CriteriaBuilder qb = this.em.getCriteriaBuilder();
		CriteriaQuery<Employee> query = qb.createQuery(Employee.class);
		Root<Employee> emp = query.from(Employee.class);

		Predicate where = qb.conjunction();
		where = qb.and(where, qb.equal(emp.get("id").get("sysOwnerCd"), sysOwnerCd));
		
		if (empId != null && !empId.equals(PMTConstants.CHAR_BLANK)) {
			where = qb.and(where, qb.equal(emp.get("id").get("ein"), empId));
		}
			
		query.where(where);
		query.orderBy(qb.asc(emp.get("empName")));
		List<Employee> result = em.createQuery(query).getResultList();
		return result;
	}
	
	public List<Employee> getEmployeeEntityByEinList(List<String> ein, String sysOwnerCd) {

		CriteriaBuilder qb = em.getCriteriaBuilder();
		CriteriaQuery<Employee> query = qb.createQuery(Employee.class);
		Root<Employee> asset = query.from(Employee.class);
		Predicate where = qb.conjunction();
		where = qb.and(where, asset.get("id").get("ein").in(ein));
		if (!StringUtils.isNullOrEmpty(sysOwnerCd))
			where = qb.and(where, qb.equal(asset.get("id").get("sysOwnerCd"), sysOwnerCd));
		query.where(where);
		List<Employee> result = em.createQuery(query).getResultList();
		return result;
	}
	
	public void saveAll(List<Employee> mtMstList) {
		employeeDao.saveAll(mtMstList);
	}

	public void deleteAll(List<Employee> mtMstList) {
		employeeDao.deleteAll(mtMstList);
	}

}