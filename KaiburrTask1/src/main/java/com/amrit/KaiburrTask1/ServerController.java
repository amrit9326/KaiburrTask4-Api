package com.amrit.KaiburrTask1;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/server")
@CrossOrigin
public class ServerController {
	
    private ServerInterface serverinterface;
	
	public ServerController(ServerInterface serverinterface)
	{
		this.serverinterface=serverinterface;//setting repository
	}
	
	//To Retrieve all the servers from monogodb
	@GetMapping
    public List<Server>getAll()
    {
    	List<Server>servers=this.serverinterface.findAll();
    	return servers;
    }
	
	
	//Get the server by id
    @GetMapping("/{server_id}")
    public Server getServerId(@PathVariable("server_id") int server_id)
    {
    	//System.out.println("-----------------------"+server_id);
    	Server ser= this.serverinterface.findById(server_id);
    	
    	return ser;
    }
    
    //To get the server by name 
    @GetMapping("servername/{server_name}")
    public List<Server>getServerByName(@PathVariable("server_name") String server_name)
    {
    	List<Server> ser=this.serverinterface.findByServerName(server_name);
    	return ser;
    }
    //TO insert The data in mongodb
    
	@PutMapping
	public void insert(@RequestBody Server server)
	{
		System.out.println(server.getframework());
		System.out.println(server.getSid());
		System.out.println(server.getName());
		
		
	   this.serverinterface.insert(server);	
	  // return new ResponseEntity<>("Data Inserted !",HttpStatus.OK);
	}
	
	
	//To delete the server by id
	@DeleteMapping("/{id}")
	public ResponseEntity<String>delete(@PathVariable("id") int id)
	{
	    this.serverinterface.deleteById(id);
	    return new ResponseEntity<>("Server by id is deleted!", HttpStatus.OK);
	}
	

}
