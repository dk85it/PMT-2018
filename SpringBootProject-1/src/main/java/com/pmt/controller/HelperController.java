package com.pmt.controller;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pmt.entity.common.CommonKeyMst;
import com.pmt.pcommon.helper.HelperService;

@Controller
@RequestMapping(value = "/helper")
public class HelperController {

	@Autowired
	private HelperService helperService;

	@RequestMapping(value = "/getActInActFlag", method = { RequestMethod.GET })
	@ResponseBody
	public List<CommonKeyMst> getStatus(HttpServletRequest request) {
		
		List<CommonKeyMst> activeInactiveList = helperService.getCodeDataByCodeKey1("PMT", "100", "100");
		activeInactiveList = activeInactiveList.stream().sorted(Comparator.comparing(CommonKeyMst::getCdData1)).collect(Collectors.toList());
		return activeInactiveList;
	}

}