package com.oostaoo.rest.repo;



import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.oostaoo.rest.model.Client;


@Repository 
public interface ClientRepository extends MongoRepository<Client, Integer>{
	

	void deleteById(int id);
	Optional<Client> findById(int id);	
}
