package com.module.services;

import static org.junit.Assert.*;

import java.net.UnknownHostException;
import java.text.ParseException;
import java.util.List;

import org.junit.Test;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

public class TrainSwitchAnalyticsSvcTestClearPredictDb {

	@Test
	public void test() throws UnknownHostException {
		String string = "Error";
		TrainSwitchAnalyticsSvc trainSwitchAnalyticsSvc = new com.module.services.TrainSwitchAnalyticsSvc();
		try {
			string = trainSwitchAnalyticsSvc.resetPredictionData();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(string);
		
        // connect to mongodb
		MongoClientURI uri  = new MongoClientURI("mongodb://predict:terps623@ds053160.mongolab.com:53160/heroku_app31652369"); 
	    MongoClient client = new MongoClient(uri);
	    
        // get/select database
        DB db = client.getDB(uri.getDatabase());
        
        // get collection named "user" from db
        DBCollection collection = db.getCollection("TSApre");
        
        //DBCursor result = collection.find().limit(100);
        List<DBObject> result = collection.find().limit(100).toArray();
        client.close();
        
        int numFound = result.size();
		assertEquals(numFound,0);
	}

}
