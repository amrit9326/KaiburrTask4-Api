package com.amrit.KaiburrTask1;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="server")
public class Server {
	
	@Id
	private int sid;//server id
	private String name;//server name
	private String language;//language
	private String framework;//framework
	
	protected Server()
	{
		
	}
	
	public Server(int sid,String name,String language,String framework)
	{
		this.sid=sid;
		this.name=name;
		this.language=language;
		this.framework=framework;
	}
	
	
	public int getSid()
	{
		return sid;
	}
	public String getName()
	{
		return name;
	}
	public String getLanguage()
	{
		return language;
	}
	public String getframework()
	{
		return framework;
	}

}
