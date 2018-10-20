package com.pmt.repository;

import org.springframework.stereotype.Repository;
import com.pmt.model.City;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface CityRepository extends CrudRepository<City, Long> {
}
