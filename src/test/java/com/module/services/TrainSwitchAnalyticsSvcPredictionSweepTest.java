package com.module.services;

import static org.junit.Assert.*;

import java.net.UnknownHostException;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.module.models.Train;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.WriteResult;

public class TrainSwitchAnalyticsSvcPredictionSweepTest {

	@Before
	public void before() throws UnknownHostException {
		/*/
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
		//*/
	}
	
	@Test
	public void test() throws UnknownHostException {
		/*/
        TrainSwitchAnalyticsSvc trainSwitchAnalyticsSvc = new TrainSwitchAnalyticsSvc();
		
		// connect to mongodb
		MongoClientURI uri  = new MongoClientURI("mongodb://predict:terps623@ds053160.mongolab.com:53160/heroku_app31652369"); 
	    MongoClient client = new MongoClient(uri);
 
        // get/select database
        DB db = client.getDB(uri.getDatabase());
        
        // get collection named "user" from db
        DBCollection collection = db.getCollection("TSA");
        DBCollection collection2 = db.getCollection("TSApre");
		
		int[] occurSlots = new int[256];
		String string = "Error";
		String left = "left";
		String right = "right";
		Integer intSelect = new Integer(128);
		String strSelect = intSelect.toString(intSelect, 2);
		
		for(int i = 0; i<256; i++) {
			Train train = new Train();
			
			String trainSerial = train.getTrainSerialNumber();
			
			Integer intCount = i;
			String randSerialStr = intCount.toString(i,2);
			
			int countTo = 8-randSerialStr.length();
			for(int j=0; j<countTo; j++) {
				randSerialStr = "0"+randSerialStr;
			}
			
			train.setTrainSerialNumber(randSerialStr);
			
			if(randSerialStr.equals(strSelect)) {
				train.setOperatorSwitchSelection(left);
				train.setTrainSwitchDirection(left);
			}
			else {
				train.setOperatorSwitchSelection(right);
				train.setTrainSwitchDirection(right);
			}
			
	        // pase JSON string to BasicDBObject
	        BasicDBObject document = new BasicDBObject();
	        document.put("trainSerialNumber", train.getTrainSerialNumber());
	        document.put("operatorSwitchSelection", train.getOperatorSwitchSelection());
	        document.put("prediction", "N/A");
	        document.put("trainSwitchDirection", train.getTrainSwitchDirection());
	        BasicDBObject time = new BasicDBObject();
	        time.put("timezone",train.getTime().getTimezone());
	        time.put("month",train.getTime().getMonth());
	        time.put("day",train.getTime().getDay());
	        time.put("hour",train.getTime().getHour());
	        time.put("minute",train.getTime().getMinute());
	        time.put("second",train.getTime().getSecond());
	        document.put("time", time);
	        
	        BasicDBObject document2 = new BasicDBObject();
	        
	        document2.put("trainData0", String.valueOf(train.getTrainSerialNumber().charAt(0)));
	        document2.put("trainData1", String.valueOf(train.getTrainSerialNumber().charAt(1)));
	        document2.put("trainData1", String.valueOf(train.getTrainSerialNumber().charAt(1)));
	        document2.put("trainData2", String.valueOf(train.getTrainSerialNumber().charAt(2)));
	        document2.put("trainData3", String.valueOf(train.getTrainSerialNumber().charAt(3)));
	        document2.put("trainData4", String.valueOf(train.getTrainSerialNumber().charAt(4)));
	        document2.put("trainData5", String.valueOf(train.getTrainSerialNumber().charAt(5)));
	        document2.put("trainData6", String.valueOf(train.getTrainSerialNumber().charAt(6)));
	        document2.put("trainData7", String.valueOf(train.getTrainSerialNumber().charAt(7)));
	        document2.put("operatorSwitchSelection", train.getOperatorSwitchSelection());
	        
	        // insert
	        WriteResult result = collection.insert(document);
	        WriteResult result2 = collection2.insert(document2);
	        //System.out.println("result: " + result);
	        //System.out.println("result: " + result2);
		}
		
		for(int i = 0; i<25; i++) {
			Train train = new Train();
			
			String trainSerial = train.getTrainSerialNumber();
			
			Integer intCount = i;
			String randSerialStr = intCount.toString(128,2);
			
			int countTo = 8-randSerialStr.length();
			for(int j=0; j<countTo; j++) {
				randSerialStr = "0"+randSerialStr;
			}
			
			train.setTrainSerialNumber(randSerialStr);
			
			if(randSerialStr.equals(strSelect)) {
				train.setOperatorSwitchSelection(left);
				train.setTrainSwitchDirection(left);
			}
			else {
				train.setOperatorSwitchSelection(right);
				train.setTrainSwitchDirection(right);
			}
			
	        // pase JSON string to BasicDBObject
	        BasicDBObject document = new BasicDBObject();
	        document.put("trainSerialNumber", train.getTrainSerialNumber());
	        document.put("operatorSwitchSelection", train.getOperatorSwitchSelection());
	        document.put("prediction", "N/A");
	        document.put("trainSwitchDirection", train.getTrainSwitchDirection());
	        BasicDBObject time = new BasicDBObject();
	        time.put("timezone",train.getTime().getTimezone());
	        time.put("month",train.getTime().getMonth());
	        time.put("day",train.getTime().getDay());
	        time.put("hour",train.getTime().getHour());
	        time.put("minute",train.getTime().getMinute());
	        time.put("second",train.getTime().getSecond());
	        document.put("time", time);
	        
	        BasicDBObject document2 = new BasicDBObject();
	        
	        document2.put("trainData0", String.valueOf(train.getTrainSerialNumber().charAt(0)));
	        document2.put("trainData1", String.valueOf(train.getTrainSerialNumber().charAt(1)));
	        document2.put("trainData1", String.valueOf(train.getTrainSerialNumber().charAt(1)));
	        document2.put("trainData2", String.valueOf(train.getTrainSerialNumber().charAt(2)));
	        document2.put("trainData3", String.valueOf(train.getTrainSerialNumber().charAt(3)));
	        document2.put("trainData4", String.valueOf(train.getTrainSerialNumber().charAt(4)));
	        document2.put("trainData5", String.valueOf(train.getTrainSerialNumber().charAt(5)));
	        document2.put("trainData6", String.valueOf(train.getTrainSerialNumber().charAt(6)));
	        document2.put("trainData7", String.valueOf(train.getTrainSerialNumber().charAt(7)));
	        document2.put("operatorSwitchSelection", train.getOperatorSwitchSelection());
	        
	        // insert
	        WriteResult result = collection.insert(document);
	        WriteResult result2 = collection2.insert(document2);
	        //System.out.println("result: " + result);
	        //System.out.println("result: " + result2);
		}
		
		for(int i = 0; i<256; i++) {
			Train train = new Train();
			
			String trainSerial = train.getTrainSerialNumber();
			
			Integer intCount = i;
			String randSerialStr = intCount.toString(i,2);
			
			int countTo = 8-randSerialStr.length();
			for(int j=0; j<countTo; j++) {
				randSerialStr = "0"+randSerialStr;
			}
			
			train.setTrainSerialNumber(randSerialStr);
			
			if(randSerialStr.equals(strSelect)) {
				train.setOperatorSwitchSelection(left);
				train.setTrainSwitchDirection(left);
			}
			else {
				train.setOperatorSwitchSelection(right);
				train.setTrainSwitchDirection(right);
			}
			
	        // pase JSON string to BasicDBObject
	        BasicDBObject document = new BasicDBObject();
	        document.put("trainSerialNumber", train.getTrainSerialNumber());
	        document.put("operatorSwitchSelection", train.getOperatorSwitchSelection());
	        document.put("prediction", "N/A");
	        document.put("trainSwitchDirection", train.getTrainSwitchDirection());
	        BasicDBObject time = new BasicDBObject();
	        time.put("timezone",train.getTime().getTimezone());
	        time.put("month",train.getTime().getMonth());
	        time.put("day",train.getTime().getDay());
	        time.put("hour",train.getTime().getHour());
	        time.put("minute",train.getTime().getMinute());
	        time.put("second",train.getTime().getSecond());
	        document.put("time", time);
	        
	        BasicDBObject document2 = new BasicDBObject();
	        
	        document2.put("trainData0", String.valueOf(train.getTrainSerialNumber().charAt(0)));
	        document2.put("trainData1", String.valueOf(train.getTrainSerialNumber().charAt(1)));
	        document2.put("trainData1", String.valueOf(train.getTrainSerialNumber().charAt(1)));
	        document2.put("trainData2", String.valueOf(train.getTrainSerialNumber().charAt(2)));
	        document2.put("trainData3", String.valueOf(train.getTrainSerialNumber().charAt(3)));
	        document2.put("trainData4", String.valueOf(train.getTrainSerialNumber().charAt(4)));
	        document2.put("trainData5", String.valueOf(train.getTrainSerialNumber().charAt(5)));
	        document2.put("trainData6", String.valueOf(train.getTrainSerialNumber().charAt(6)));
	        document2.put("trainData7", String.valueOf(train.getTrainSerialNumber().charAt(7)));
	        document2.put("operatorSwitchSelection", train.getOperatorSwitchSelection());
	        
	        // insert
	        WriteResult result = collection.insert(document);
	        WriteResult result2 = collection2.insert(document2);
	        //System.out.println("result: " + result);
	        //System.out.println("result: " + result2);
		}
		
		for(int i = 0; i<256; i++) {
			Train train = new Train();
			
			String trainSerial = train.getTrainSerialNumber();
			
			Integer intCount = i;
			String randSerialStr = intCount.toString(i,2);
			
			int countTo = 8-randSerialStr.length();
			for(int j=0; j<countTo; j++) {
				randSerialStr = "0"+randSerialStr;
			}
			
			train.setTrainSerialNumber(randSerialStr);
			
			if(randSerialStr.equals(strSelect)) {
				train.setOperatorSwitchSelection(left);
				train.setTrainSwitchDirection(left);
			}
			else {
				train.setOperatorSwitchSelection(right);
				train.setTrainSwitchDirection(right);
			}
			
	        // pase JSON string to BasicDBObject
	        BasicDBObject document = new BasicDBObject();
	        document.put("trainSerialNumber", train.getTrainSerialNumber());
	        document.put("operatorSwitchSelection", train.getOperatorSwitchSelection());
	        document.put("prediction", "N/A");
	        document.put("trainSwitchDirection", train.getTrainSwitchDirection());
	        BasicDBObject time = new BasicDBObject();
	        time.put("timezone",train.getTime().getTimezone());
	        time.put("month",train.getTime().getMonth());
	        time.put("day",train.getTime().getDay());
	        time.put("hour",train.getTime().getHour());
	        time.put("minute",train.getTime().getMinute());
	        time.put("second",train.getTime().getSecond());
	        document.put("time", time);
	        
	        BasicDBObject document2 = new BasicDBObject();
	        
	        document2.put("trainData0", String.valueOf(train.getTrainSerialNumber().charAt(0)));
	        document2.put("trainData1", String.valueOf(train.getTrainSerialNumber().charAt(1)));
	        document2.put("trainData1", String.valueOf(train.getTrainSerialNumber().charAt(1)));
	        document2.put("trainData2", String.valueOf(train.getTrainSerialNumber().charAt(2)));
	        document2.put("trainData3", String.valueOf(train.getTrainSerialNumber().charAt(3)));
	        document2.put("trainData4", String.valueOf(train.getTrainSerialNumber().charAt(4)));
	        document2.put("trainData5", String.valueOf(train.getTrainSerialNumber().charAt(5)));
	        document2.put("trainData6", String.valueOf(train.getTrainSerialNumber().charAt(6)));
	        document2.put("trainData7", String.valueOf(train.getTrainSerialNumber().charAt(7)));
	        document2.put("operatorSwitchSelection", train.getOperatorSwitchSelection());
	        
	        // insert
	        WriteResult result = collection.insert(document);
	        WriteResult result2 = collection2.insert(document2);
	        //System.out.println("result: " + result);
	        //System.out.println("result: " + result2);
		}
		
		List<DBObject> result = collection2.find().limit(1000).toArray();
		int numFound = result.size();
		assertEquals(numFound,256*3+25);
		
		Train train = new Train();
		Train predictTrain = new Train();
		train.setTrainSerialNumber(strSelect);
		train.setOperatorSwitchSelection(left);
		train.setTrainSwitchDirection(left);
		try {
			predictTrain = trainSwitchAnalyticsSvc.runPredict(train);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(predictTrain.getPrediction());
		//assertEquals(train.getPrediction(),"left");
		client.close();
		//*/
	}

	@After
	public void after() throws UnknownHostException {
		/*/
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
		//*/
	}
}
