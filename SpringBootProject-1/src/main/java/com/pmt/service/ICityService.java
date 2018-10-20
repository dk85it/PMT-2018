package com.pmt.service;

import java.util.List;

import com.pmt.model.City;

public interface ICityService {

	public List<City> findAll();
	
	void saveCity(City city);
	
	City findById(long id);
}
