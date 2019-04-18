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

import com.oostaoo.rest.model.Client;
import com.oostaoo.rest.repo.ClientRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ClientController {

	@Autowired
	ClientRepository repository;
	
	@GetMapping("/clients")
	public List<Client> getAllClients() {
		System.out.println("Get all Clients...");
 
		List<Client> clients = new ArrayList<>();
		repository.findAll().forEach(clients::add);
 
		return clients;
	}
 
	@PostMapping("/client")
	public Client postClient(@RequestBody Client client) {
 
		Client _client = repository.save(new Client(client.getNom(), client.getPrenom()));
		return _client;
	}
 
	@DeleteMapping("/client/{id}")
	public ResponseEntity<String> deleteClient(@PathVariable("id") int id) {
		System.out.println("Delete Client with ID = " + id + "...");
 
		repository.deleteById(id);
 
		return new ResponseEntity<>("Client has been deleted!", HttpStatus.OK);
	}
 
	
	@GetMapping("/client/{id}")
	public Client findClient(@PathVariable("id") int id) {
		System.out.println(" Client with ID = " + id + "...");
 
		Optional<Client> client= repository.findById(id);
		Client _client = client.get();
		return _client;
	}
	

 
	@PutMapping("/client/{id}")
	public ResponseEntity<Client> updateClient(@PathVariable("id") int id, @RequestBody Client client) {
		System.out.println("Update Client with ID = " + id + "...");
 
		Optional<Client> clientData = repository.findById(id);
 
		if (clientData.isPresent()) {
			Client _client = clientData.get();
			_client.setNom(client.getNom());
			_client.setPrenom(client.getPrenom());
			return new ResponseEntity<>(repository.save(_client), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
}
