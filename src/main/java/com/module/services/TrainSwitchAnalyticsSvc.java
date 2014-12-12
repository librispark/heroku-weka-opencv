package com.module.services;

import java.net.UnknownHostException;
import java.text.ParseException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.trees.J48;
import weka.core.Attribute;
import weka.core.DenseInstance;
import weka.core.FastVector;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.JSONLoader;

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
	@Path("/testData")
	@Produces(MediaType.APPLICATION_JSON)
	public String testDatabaseInsert() throws UnknownHostException {
		// Test to insert document into database
		MongoClientURI uri  = new MongoClientURI("mongodb://predict:terps623@ds053160.mongolab.com:53160/heroku_app31652369"); 
	    MongoClient client = new MongoClient(uri);
 
        // get/select database
        DB db = client.getDB(uri.getDatabase());
 
        // get collection named "user" from db
        DBCollection collection = db.getCollection("TSA");
 
        // pase JSON string to BasicDBObject
        String jsonInput = "{name: 'Jeremy', age: 25, country: 'United States'}";
        BasicDBObject document = (BasicDBObject) JSON.parse(jsonInput);
        
        // insert
        WriteResult result = collection.insert(document);
        System.out.println("result: " + result);
        
        client.close();
		return result.toString();
	}
	
	@GET
	@Path("/resetPredictionData")
	@Produces(MediaType.APPLICATION_JSON)
	public String resetPredictionData() throws UnknownHostException {
		
		MongoClientURI uri  = new MongoClientURI("mongodb://predict:terps623@ds053160.mongolab.com:53160/heroku_app31652369"); 
	    MongoClient client = new MongoClient(uri);
 
        // get/select database
        DB db = client.getDB(uri.getDatabase());
 
        // get collection named "user" from db
        DBCollection collection = db.getCollection("TSApre");
        
        // remove all
        WriteResult result = collection.remove(new BasicDBObject());
        System.out.println("result: " + result);
        
        client.close();
		return result.toString();
	}
	
	@POST
	@Path("/runPredict")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Train runPredict(Train train) throws Exception {
		
		MongoClientURI uri  = new MongoClientURI("mongodb://predict:terps623@ds053160.mongolab.com:53160/heroku_app31652369"); 
	    MongoClient client = new MongoClient(uri);
 
        // get/select database
        DB db = client.getDB(uri.getDatabase());
 
        // get collection named "user" from db
        DBCollection collection = db.getCollection("TSApre");
        
        // limit query
        //DBCursor result = collection.find().limit(100);
        List<DBObject> result = collection.find().limit(1000).toArray();
        
        int numFound = result.size();
        System.out.println("History Count: "+numFound);
        
        // Declare two numeric attributes
        //Attribute Attribute1 = new Attribute("firstNumeric");
        //Attribute Attribute2 = new Attribute("secondNumeric");
        
        // Declare a nominal attribute along with its values
        FastVector fvNominalVal = new FastVector(2);
        fvNominalVal.addElement("0");
        fvNominalVal.addElement("1");
        Attribute Attribute3 = new Attribute("aNominal", fvNominalVal);
        
        // Declare a nominal attribute along with its values
        FastVector fvNominalVal1 = new FastVector(2);
        fvNominalVal1.addElement("0");
        fvNominalVal1.addElement("1");
        Attribute Attribute31 = new Attribute("bNominal", fvNominalVal1);
        
        // Declare a nominal attribute along with its values
        FastVector fvNominalVal2 = new FastVector(2);
        fvNominalVal2.addElement("0");
        fvNominalVal2.addElement("1");
        Attribute Attribute32 = new Attribute("cNominal", fvNominalVal2);
        
        // Declare a nominal attribute along with its values
        FastVector fvNominalVal3 = new FastVector(2);
        fvNominalVal3.addElement("0");
        fvNominalVal3.addElement("1");
        Attribute Attribute33 = new Attribute("dNominal", fvNominalVal3);
        
        // Declare a nominal attribute along with its values
        FastVector fvNominalVal4 = new FastVector(2);
        fvNominalVal4.addElement("0");
        fvNominalVal4.addElement("1");
        Attribute Attribute34 = new Attribute("eNominal", fvNominalVal4);
        
        // Declare a nominal attribute along with its values
        FastVector fvNominalVal5 = new FastVector(2);
        fvNominalVal5.addElement("0");
        fvNominalVal5.addElement("1");
        Attribute Attribute35 = new Attribute("fNominal", fvNominalVal5);
        
        // Declare a nominal attribute along with its values
        FastVector fvNominalVal6 = new FastVector(2);
        fvNominalVal6.addElement("0");
        fvNominalVal6.addElement("1");
        Attribute Attribute36 = new Attribute("gNominal", fvNominalVal6);
        
        // Declare a nominal attribute along with its values
        FastVector fvNominalVal7 = new FastVector(2);
        fvNominalVal7.addElement("0");
        fvNominalVal7.addElement("1");
        Attribute Attribute37 = new Attribute("hNominal", fvNominalVal7);
        
        // Declare the class attribute along with its values
        FastVector fvClassVal7 = new FastVector(2);
        fvClassVal7.addElement("left");
        fvClassVal7.addElement("right");
        Attribute ClassAttribute = new Attribute("theClass", fvClassVal7);
        
        // Declare the feature vector
        FastVector fvWekaAttributes = new FastVector(8);
        fvWekaAttributes.addElement(Attribute3);    
        fvWekaAttributes.addElement(Attribute31);    
        fvWekaAttributes.addElement(Attribute32);
        fvWekaAttributes.addElement(Attribute33);
        fvWekaAttributes.addElement(Attribute34);
        fvWekaAttributes.addElement(Attribute35);
        fvWekaAttributes.addElement(Attribute36);
        fvWekaAttributes.addElement(Attribute37);
        fvWekaAttributes.addElement(ClassAttribute);
        
        // Create an empty training set
        Instances isTrainingSet = new Instances("Rel", fvWekaAttributes, 100);           
        // Set class index
        isTrainingSet.setClassIndex(8);
        
        for(int j=0; j<numFound; j++) {
        	//System.out.println("Entry: "+result.get(j));
            // Create the instance
            Instance iExample = new DenseInstance(9);
            iExample.setValue((Attribute)fvWekaAttributes.elementAt(0), result.get(j).get("trainData0").toString());      
            iExample.setValue((Attribute)fvWekaAttributes.elementAt(1), result.get(j).get("trainData1").toString());      
            iExample.setValue((Attribute)fvWekaAttributes.elementAt(2), result.get(j).get("trainData2").toString());
            iExample.setValue((Attribute)fvWekaAttributes.elementAt(3), result.get(j).get("trainData3").toString());
            iExample.setValue((Attribute)fvWekaAttributes.elementAt(4), result.get(j).get("trainData4").toString());
            iExample.setValue((Attribute)fvWekaAttributes.elementAt(5), result.get(j).get("trainData5").toString());
            iExample.setValue((Attribute)fvWekaAttributes.elementAt(6), result.get(j).get("trainData6").toString());
            iExample.setValue((Attribute)fvWekaAttributes.elementAt(7), result.get(j).get("trainData7").toString());
            iExample.setValue((Attribute)fvWekaAttributes.elementAt(8), result.get(j).get("operatorSwitchSelection").toString());
            
            // add the instance
            isTrainingSet.add(iExample);
        }
        
        
        System.out.println("isTrainingSet: "+isTrainingSet);
        
        // Create a j48 decision tree classifier 
        Classifier cModel = (Classifier)new J48();
        cModel.buildClassifier(isTrainingSet);
        
        // Create an empty training set
        Instances isTestingSet = new Instances("Rel", fvWekaAttributes, 100);           
        // Set class index
        isTestingSet.setClassIndex(8);
        
        for(int j=0; j<numFound; j++) {
        	//System.out.println("Entry: "+result.get(j));
            // Create the instance
            Instance iExample = new DenseInstance(9);
            iExample.setValue((Attribute)fvWekaAttributes.elementAt(0), result.get(j).get("trainData0").toString());      
            iExample.setValue((Attribute)fvWekaAttributes.elementAt(1), result.get(j).get("trainData1").toString());      
            iExample.setValue((Attribute)fvWekaAttributes.elementAt(2), result.get(j).get("trainData2").toString());
            iExample.setValue((Attribute)fvWekaAttributes.elementAt(3), result.get(j).get("trainData3").toString());
            iExample.setValue((Attribute)fvWekaAttributes.elementAt(4), result.get(j).get("trainData4").toString());
            iExample.setValue((Attribute)fvWekaAttributes.elementAt(5), result.get(j).get("trainData5").toString());
            iExample.setValue((Attribute)fvWekaAttributes.elementAt(6), result.get(j).get("trainData6").toString());
            iExample.setValue((Attribute)fvWekaAttributes.elementAt(7), result.get(j).get("trainData7").toString());
            iExample.setValue((Attribute)fvWekaAttributes.elementAt(8), result.get(j).get("operatorSwitchSelection").toString());
            
            // add the instance
            isTestingSet.add(iExample);
        }
        
        // Test the model
        Evaluation eTest = new Evaluation(isTrainingSet);
        eTest.evaluateModel(cModel, isTestingSet);
        
        // Print the result à la Weka explorer:
        String strSummary = eTest.toSummaryString();
        System.out.println(strSummary);
        
        // Get the confusion matrix
        double[][] cmMatrix = eTest.confusionMatrix();
        
        System.out.println("Confusion Matrix: ");
        for(int k=0; k<cmMatrix.length; k++) {
            for(int l=0; l<cmMatrix[k].length; l++) {
            	if(l == cmMatrix.length-1) {
            		System.out.print("["+k+"]["+l+"]: "+cmMatrix[k][l]+" ");
            		System.out.println("");
            	}
            	else {
            		System.out.print("["+k+"]["+l+"]: "+cmMatrix[k][l]+" ");
            	}
            	
            }
        }
        System.out.println("");
        
        // Create an empty training set
        Instances iUses = new Instances("Rel", fvWekaAttributes, 100);           
        // Set class index
        iUses.setClassIndex(7);
        
        String trainSerialNum = train.getTrainSerialNumber();
        
        // Create the instance
        Instance iUse = new DenseInstance(8);
        iUse.setValue((Attribute)fvWekaAttributes.elementAt(0), String.valueOf(trainSerialNum.toCharArray()[0]));      
        iUse.setValue((Attribute)fvWekaAttributes.elementAt(1), String.valueOf(trainSerialNum.toCharArray()[1]));      
        iUse.setValue((Attribute)fvWekaAttributes.elementAt(2), String.valueOf(trainSerialNum.toCharArray()[2]));
        iUse.setValue((Attribute)fvWekaAttributes.elementAt(3), String.valueOf(trainSerialNum.toCharArray()[3]));
        iUse.setValue((Attribute)fvWekaAttributes.elementAt(4), String.valueOf(trainSerialNum.toCharArray()[4]));
        iUse.setValue((Attribute)fvWekaAttributes.elementAt(5), String.valueOf(trainSerialNum.toCharArray()[5]));
        iUse.setValue((Attribute)fvWekaAttributes.elementAt(6), String.valueOf(trainSerialNum.toCharArray()[6]));
        iUse.setValue((Attribute)fvWekaAttributes.elementAt(7), String.valueOf(trainSerialNum.toCharArray()[7]));
        
        System.out.println("predictionData: "+iUse+", "+trainSerialNum);
        
        // add the instance
        iUses.add(iUse);
        
        // Specify that the instance belong to the training set 
        // in order to inherit from the set description
        iUse.setDataset(isTrainingSet);
        
        // Get the likelihood of each classes 
        // iDistribution[0] is the probability of being “left” 
        // iDistribution[1] is the probability of being “right” 
        double[] iDistribution = cModel.distributionForInstance(iUse);
        
        System.out.println("iDistribution: [0] " + iDistribution[0] + ", [1] "+iDistribution[1]);
        
        client.close();
        
        if(numFound < 10) {
        	System.out.println("count is less than 10");
        	return train;
        }
        
        //String jsonOut = "{probLeft: "+iDistribution[0]+", probRight:"+iDistribution[1]+", wekaSum: "+strSummary+", confMatrix: "+cmMatrix+"}";
        if(iDistribution[0] != iDistribution[1]) {
        	if(iDistribution[0] >= 1.0) {
        		System.out.println("left");
        		train.setPrediction("left");
        		train.setOperatorSwitchSelection(null);
        		train.setTrainSwitchDirection(null);
        	}
        	else if(iDistribution[1] >= 1.0) {
        		System.out.println("right");
        		train.setPrediction("right");
        		train.setOperatorSwitchSelection(null);
        		train.setTrainSwitchDirection(null);
        	}
        }
        System.out.println(train);
		return train;
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
        DBCollection collection2 = db.getCollection("TSApre");
        
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
        document2.put("trainData0", train.getTrainSerialNumber().charAt(0));
        document2.put("trainData1", train.getTrainSerialNumber().charAt(1));
        document2.put("trainData2", train.getTrainSerialNumber().charAt(2));
        document2.put("trainData3", train.getTrainSerialNumber().charAt(3));
        document2.put("trainData4", train.getTrainSerialNumber().charAt(4));
        document2.put("trainData5", train.getTrainSerialNumber().charAt(5));
        document2.put("trainData6", train.getTrainSerialNumber().charAt(6));
        document2.put("trainData7", train.getTrainSerialNumber().charAt(7));
        document2.put("operatorSwitchSelection", train.getOperatorSwitchSelection());
        
        // insert
        WriteResult result = collection.insert(document);
        WriteResult result2 = collection2.insert(document2);
        System.out.println("result: " + result);
        System.out.println("result: " + result2);
		
		System.out.println("Output json server .... \n");
		System.out.println(train);
		
		client.close();
		return train;
	} 
}
