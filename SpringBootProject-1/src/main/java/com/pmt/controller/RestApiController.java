package com.pmt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.pmt.model.City;
import com.pmt.service.ICityService;

@RestController
@RequestMapping("/api")
public class RestApiController {
    
    @Autowired
    ICityService cityService;

    // Get All City
    @RequestMapping(value = "/city/", method = RequestMethod.GET)
    public ResponseEntity<List<City>> findAll() {
        List<City> city = cityService.findAll();
        if (city.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<City>>(city, HttpStatus.OK);
    }
    
 // -------------------Retrieve Single City------------------------------------------

 	@RequestMapping(value = "/city/{id}", method = RequestMethod.GET)
 	public ResponseEntity<?> getCity(@PathVariable("id") long id) {
 		City city = cityService.findById(id);
 		/*if (user == null) {
 			return new ResponseEntity(new CustomErrorType("City with id " + id 
 					+ " not found"), HttpStatus.NOT_FOUND);
 		}*/
 		return new ResponseEntity<City>(city, HttpStatus.OK);
 	}
    
    // Add City 
    @RequestMapping(value = "/addCity", method = RequestMethod.POST)
	public ResponseEntity<?> createCity(@RequestBody City city, UriComponentsBuilder ucBuilder) {
    	
    	cityService.saveCity(city);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/city/{id}").buildAndExpand(city.getId()).toUri());
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}
}
