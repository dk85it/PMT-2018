package com.pmt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pmt.model.City;
import com.pmt.service.ICityService;

@Controller
public class MyController {
    
    @Autowired
    ICityService cityService;

    @RequestMapping("/showCities")
    public String findCities(Model model) {
        
    	List<City> cities = (List<City>) cityService.findAll();
        model.addAttribute("cities", cities);
        
        return "showCities";
    }
    
    @RequestMapping(value="/addCity", method = RequestMethod.GET)
	public String addCityPage(ModelMap model){
		return "addCity";
	}
    
    /*@RequestMapping(value="/addCity", method = RequestMethod.POST)
   	public String findCities(ModelMap model){
    	cityService.saveCity(city);
   		return "addCity";
   	}
    
    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("city") City city, BindingResult bindingResult, Model model) {
    	cityService.save(city);

        return "redirect:/showCities";
    }*/

}
