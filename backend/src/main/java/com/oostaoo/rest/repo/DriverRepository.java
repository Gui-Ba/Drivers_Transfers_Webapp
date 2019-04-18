package com.oostaoo.rest.repo;


import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.oostaoo.rest.model.Driver;

@Repository 
public interface DriverRepository extends MongoRepository<Driver, Integer>{
	List<Driver> findByAge(int experience);
	List<Driver> findByVoiture(String voiture);
	void deleteById(int id);
	Optional<Driver> findById(int id);	
}
