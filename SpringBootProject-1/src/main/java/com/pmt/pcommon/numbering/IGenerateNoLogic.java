package com.pmt.pcommon.numbering;

import org.springframework.stereotype.Component;

@Component
public interface IGenerateNoLogic {
	public Integer generateWfId(String sysOwnerCd);
}

