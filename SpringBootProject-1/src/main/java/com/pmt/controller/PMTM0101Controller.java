package com.pmt.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import com.fasterxml.jackson.core.type.TypeReference;

import org.springframework.beans.BeanUtils;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pmt.pmtm.pmtm01.dto.PMTM0101DTO;
import com.pmt.pmtm.pmtm01.form.PMTM0101Form;
import com.pmt.pmtm.pmtm01.model.PMTM0101ResultDetailModel;
import com.pmt.pmtm.pmtm01.service.PMTM0101RetrieveService;
import com.pmt.pmtm.pmtm01.service.PMTM0101SubmitService;

@Controller
@RequestMapping(value = "/pmtm/pmtm01/pmtm0101")
public class PMTM0101Controller {

	@Inject
	private PMTM0101RetrieveService retrieveService;
	
	@Inject
	private PMTM0101SubmitService submitService;
	
	@RequestMapping(method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView initialController(Model model, HttpServletRequest request) {
		PMTM0101Form form = new PMTM0101Form();
		return new ModelAndView("/pmt/pmtm/pmtm01/PMTM0101", "PMTM0101Form", form);
	}

	@Transactional
	@ResponseBody
	@RequestMapping(value = "/retrieve", method = { RequestMethod.POST,RequestMethod.GET }, produces = MediaType.APPLICATION_JSON_VALUE)
	public PMTM0101Form MS0201Retrieve(@RequestBody PMTM0101Form form, 
									   BindingResult br, Model model,
									   HttpServletRequest request) {

		PMTM0101DTO dto = new PMTM0101DTO();
		BeanUtils.copyProperties(form, dto);

			List<PMTM0101ResultDetailModel> detailModelList = retrieveService.getRecords(dto, "PMT");
			form.getResultModel().setResult(detailModelList);

			ObjectMapper mapper = new ObjectMapper();
			try {
				form.getResultModel().setJsonResult(mapper.writeValueAsString(detailModelList));
			} catch (Exception e) {
				e.printStackTrace();
			}

		return form;
	}
	
	@Transactional
	@ResponseBody
	@RequestMapping(method = { RequestMethod.GET, RequestMethod.POST }, value = "/submit", produces = MediaType.APPLICATION_JSON_VALUE)
	public PMTM0101Form MS0201Submit(Model model, @RequestBody PMTM0101Form form, HttpServletRequest request) {

		ObjectMapper mapper = new ObjectMapper();
		TypeReference<List<PMTM0101ResultDetailModel>> mapType = new TypeReference<List<PMTM0101ResultDetailModel>>() {};
		List<PMTM0101ResultDetailModel> detailModelList = null;
		try {
			detailModelList = mapper.readValue(form.getResultModel().getJsonResult(), mapType);

		} catch (Exception e) {
			e.printStackTrace();
		}
		form.getResultModel().setResult(detailModelList);
		
		PMTM0101DTO dto = new PMTM0101DTO();
		BeanUtils.copyProperties(form, dto);
		Boolean errorFlag = submitService.save(dto, "PMT");
		form.setResultModel(dto.getResultModel());
		try {
			form.getResultModel().setJsonResult(mapper.writeValueAsString(dto.getResultModel().getResult()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (errorFlag) {
			return form;
		} else{
			BeanUtils.copyProperties(form, dto);
			List<PMTM0101ResultDetailModel> detailModelList1 = retrieveService.getRecords(dto, "PMT");
			form.getResultModel().setResult(detailModelList1);

			try {
				form.getResultModel().setJsonResult(mapper.writeValueAsString(detailModelList1));
			} catch (Exception e) {
				e.printStackTrace();
			}
		return form;
		}
	}
	
	
}
