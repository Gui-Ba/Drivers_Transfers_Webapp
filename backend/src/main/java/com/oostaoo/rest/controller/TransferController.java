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

import com.oostaoo.rest.model.Transfer;
import com.oostaoo.rest.repo.TransferRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class TransferController {

	@Autowired
	TransferRepository repository;
	
	@GetMapping("/transfers")
	public List<Transfer> getAllTransfers() {
		System.out.println("Get all Transfers...");
 
		List<Transfer> transfers = new ArrayList<>();
		repository.findAll().forEach(transfers::add);
 
		return transfers;
	}
 
	@PostMapping("/transfer")
	public Transfer postTransfer(@RequestBody Transfer transfer) {
 
		Transfer _transfer = repository.save(new Transfer(transfer.getDriver(), transfer.getClient(), transfer.getDistance(), transfer.getDate()));
		return _transfer;
	}
 
	@DeleteMapping("/transfer/{id}")
	public ResponseEntity<String> deleteTransfer(@PathVariable("id") int id) {
		System.out.println("Delete Transfer with ID = " + id + "...");
 
		repository.deleteById(id);
 
		return new ResponseEntity<>("Transfer has been deleted!", HttpStatus.OK);
	}
 
	
	@GetMapping("/transfer/{id}")
	public Transfer findTransfer(@PathVariable("id") int id) {
		System.out.println(" Transfer with ID = " + id + "...");
 
		Optional<Transfer> transfer= repository.findById(id);
		Transfer _transfer = transfer.get();
		return _transfer;
	}
	


 
	@PutMapping("/transfer/{id}")
	public ResponseEntity<Transfer> updateTransfer(@PathVariable("id") int id, @RequestBody Transfer transfer) {
		System.out.println("Update Transfer with ID = " + id + "...");
 
		Optional<Transfer> transferData = repository.findById(id);
 
		if (transferData.isPresent()) {
			Transfer _transfer = transferData.get();
			_transfer.setDate(transfer.getDate());
			_transfer.setDriver(transfer.getDriver());
			_transfer.setClient(transfer.getClient());
			_transfer.setPrice(transfer.getPrice());
			_transfer.setActive(transfer.isActive());
			return new ResponseEntity<>(repository.save(_transfer), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
}
