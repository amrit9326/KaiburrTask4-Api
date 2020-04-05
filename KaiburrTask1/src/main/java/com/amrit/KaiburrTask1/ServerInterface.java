package com.amrit.KaiburrTask1;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ServerInterface extends MongoRepository<Server,Integer> {

	
	
	Server findById(int server_id);
	
	@Query(value="{'name':?0}")
	List<Server>findByServerName(String server_name);
	
	
	
	 
    
}
