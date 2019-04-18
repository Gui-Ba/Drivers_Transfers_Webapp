package com.oostaoo.rest.repo;



import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


import com.oostaoo.rest.model.Transfer;


@Repository 
public interface TransferRepository extends MongoRepository<Transfer, Integer>{
	

	void deleteById(int id);
	Optional<Transfer> findById(int id);	
}
