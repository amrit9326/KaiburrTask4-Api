package com.amrit.KaiburrTask1;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//This class for inserting four server objects into the monogdb while executing the project
@Component
public class DefaultInsert implements CommandLineRunner {
	
	private ServerInterface serverinterface;
	
	public DefaultInsert(ServerInterface serverinterface)
	{
		this.serverinterface=serverinterface;
	}
	@Override
	public void run (String...strings) throws Exception
	{
		Server server1= new Server(1,"Server1","C","DotNet");
		Server server2= new Server(2,"Server2","Java","SpringBoot");
		Server server3=new Server(3,"Server3","Python","Flask");
		Server server4 = new Server(4,"Server4","Python","Django");
		
		this.serverinterface.deleteAll();
		List<Server>servers=Arrays.asList(server1,server2,server3,server4);
		this.serverinterface.saveAll(servers);
	}

}
