package com.example.services;

import java.util.TimeZone;

import com.example.models.Time;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.PathParam;
import java.util.TimeZone;

@Path("/et1")
@Produces(MediaType.APPLICATION_JSON)
public class Fep1 {

    @GET
    public String test1() {
        
    	return "Meow?";
    }
	
}
