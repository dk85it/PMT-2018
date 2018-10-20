package com.pmt.pcommon.helper;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.pmt.entity.common.CommonKeyMst;
import com.pmt.repository.CommonKeyMstDao;

@Service
public class HelperService {

	@Inject
	private CommonKeyMstDao codeMstDao;

	public List<CommonKeyMst> getCodeDataByCodeKey1(String sysOwnerCd, String codeId, String codeKey1) {
		List<CommonKeyMst> listCodeMst = codeMstDao.getCodeDataByCodeKey1(sysOwnerCd, codeId, codeKey1);
		return listCodeMst;
	}
}