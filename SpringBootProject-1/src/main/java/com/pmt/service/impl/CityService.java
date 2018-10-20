package com.pmt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pmt.model.City;
import com.pmt.repository.CityRepository;
import com.pmt.service.ICityService;

@Service
public class CityService implements ICityService {

    @Autowired
    private CityRepository repository;

    @Override
    public List<City> findAll() {

        List<City> cities = (List<City>) repository.findAll();
        
        return cities;
    }
    
    public void saveCity(City city) {
    	repository.save(city);
	}
    
    public City findById(long id) {
    	List<City> cities = (List<City>) repository.findAll();
		for(City city : cities){
			if(city.getId() == id){
				return city;
			}
		}
		return null;
	}
}
