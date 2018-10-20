package com.pmt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pmt.entity.common.CommonKeyMst;
import com.pmt.entity.common.CommonKeyMstPK;

@Repository
public interface CommonKeyMstDao extends JpaRepository<CommonKeyMst, CommonKeyMstPK>{
	
	@Query(value="select cm from CommonKeyMst cm where cm.id.sysOwnerCd = ?1 and cm.id.cdId = ?2 and cm.id.cdKey1 = ?3 order by cm.cdData1")
	public List<CommonKeyMst> getCodeDataByCodeKey1(String sysOwnerCd,String cdId,String cdKey1);
}
