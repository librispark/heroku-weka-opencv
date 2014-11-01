package com.example.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/et1")
public class Fep1 {
    
	public static final String CLICHED_MESSAGE = "Hello World!";
    
	@GET
	@Produces("text/plain")
    public String getHello() {
        return CLICHED_MESSAGE;
    }
	
}
 
