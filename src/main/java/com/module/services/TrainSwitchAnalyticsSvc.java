package com.module.services;

import java.net.UnknownHostException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.module.models.Train;
import com.mongodb.*;
import com.mongodb.util.JSON;

@Path("/analytics")
public class TrainSwitchAnalyticsSvc {
	@GET
	@Path("/getSchema")
	@Produces(MediaType.APPLICATION_JSON)
	public Train getSchema() {
		Train train = new Train();
		train.setTrainSerialNumber("11001100");
		train.setOperatorSwitchSelection("left");
		train.getPrediction();
		train.setTrainSwitchDirection("left");
		train.getTime();
		return train;
	}
	
	@GET
	@Path("/getAnalytics")
	@Produces(MediaType.APPLICATION_JSON)
	public Train getPrediction() {
		Train train = new Train();
		train.setTrainSerialNumber("11001100");
		train.setOperatorSwitchSelection("left");
		train.getPrediction();
		train.setTrainSwitchDirection("left");
		train.getTime();
		return train;
	}
	
	@GET
	@Path("/getData")
	@Produces(MediaType.APPLICATION_JSON)
	public String testDatabaseInsert() throws UnknownHostException {
		
		MongoClientURI uri  = new MongoClientURI("mongodb://predict:terps623@ds053160.mongolab.com:53160/heroku_app31652369"); 
	    MongoClient client = new MongoClient(uri);
 
        // get/select database
        DB db = client.getDB(uri.getDatabase());
 
        // get collection named "user" from db
        DBCollection collection = db.getCollection("TSA");
 
        // pase JSON string to BasicDBObject
        String jsonInput = "{name: 'Max', age: 24, country: 'India'}";
        BasicDBObject document = (BasicDBObject) JSON.parse(jsonInput);
        
        // insert
        WriteResult result = collection.insert(document);
        System.out.println("result: " + result);
        
		return result.toString();
	}
	
	@POST
	@Path("/postAnalytics")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Train postAnaltyics(Train train) throws UnknownHostException {
        // connect to mongodb
		MongoClientURI uri  = new MongoClientURI("mongodb://predict:terps623@ds053160.mongolab.com:53160/heroku_app31652369"); 
	    MongoClient client = new MongoClient(uri);
 
        // get/select database
        DB db = client.getDB(uri.getDatabase());
        
        // get collection named "user" from db
        DBCollection collection = db.getCollection("TSA");
        
        // pase JSON string to BasicDBObject
        BasicDBObject document = new BasicDBObject();
        document.put("trainSerialNumber", train.getTrainSerialNumber());
        document.put("operatorSwitchSelection", train.getOperatorSwitchSelection());
        document.put("prediction", train.getPrediction());
        document.put("trainSwitchDirection", train.getTrainSwitchDirection());
        BasicDBObject time = new BasicDBObject();
        time.put("timezone",train.getTime().getTimezone());
        time.put("month",train.getTime().getMonth());
        time.put("day",train.getTime().getDay());
        time.put("hour",train.getTime().getHour());
        time.put("minute",train.getTime().getMinute());
        time.put("second",train.getTime().getSecond());
        document.put("time", time);
        
        // insert
        WriteResult result = collection.insert(document);
        System.out.println("result: " + result);
		
		System.out.println("Output json server .... \n");
		System.out.println(train);
		
		return train;
	} 
}
