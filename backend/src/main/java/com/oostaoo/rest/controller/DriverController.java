package com.oostaoo.rest.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oostaoo.rest.model.Driver;
import com.oostaoo.rest.repo.DriverRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class DriverController {

	@Autowired
	DriverRepository repository;
	
	@GetMapping("/drivers")
	public List<Driver> getAllDrivers() {
		System.out.println("Get all Drivers...");
 
		List<Driver> drivers = new ArrayList<>();
		repository.findAll().forEach(drivers::add);
 
		return drivers;
	}
 
	@PostMapping("/driver")
	public Driver postDriver(@RequestBody Driver driver) {
 
		Driver _driver = repository.save(new Driver(driver.getNom(), driver.getPrenom(), driver.getAge(), driver.getVoiture()));
		return _driver;
	}
 
	@DeleteMapping("/driver/{id}")
	public ResponseEntity<String> deleteDriver(@PathVariable("id") int id) {
		System.out.println("Delete Driver with ID = " + id + "...");
 
		repository.deleteById(id);
 
		return new ResponseEntity<>("Driver has been deleted!", HttpStatus.OK);
	}
 
	
	@GetMapping("/driver/{id}")
	public Driver findDriver(@PathVariable("id") int id) {
		System.out.println(" Driver with ID = " + id + "...");
 
		Optional<Driver> driver= repository.findById(id);
		Driver _driver = driver.get();
		return _driver;
	}
	
	@GetMapping("drivers/experience/{experience}")
	public List<Driver> findByAge(@PathVariable int experience) {
 
		List<Driver> drivers = repository.findByAge(experience);
		return drivers;
	}
	
	@GetMapping("drivers/voiture/{voiture}")
	public List<Driver> findByVoiture(@PathVariable String voiture) {
 
		List<Driver> drivers = repository.findByVoiture(voiture);
		return drivers;
	}
 
	@PutMapping("/driver/{id}")
	public ResponseEntity<Driver> updateDriver(@PathVariable("id") int id, @RequestBody Driver driver) {
		System.out.println("Update Driver with ID = " + id + "...");
 
		Optional<Driver> driverData = repository.findById(id);
 
		if (driverData.isPresent()) {
			Driver _driver = driverData.get();
			_driver.setNom(driver.getNom());
			_driver.setPrenom(driver.getPrenom());
			_driver.setExperience(driver.getExperience());
			_driver.setVoiture(driver.getVoiture());
			_driver.setActive(driver.isActive());
			return new ResponseEntity<>(repository.save(_driver), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
}
