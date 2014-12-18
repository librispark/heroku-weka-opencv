package com.module.services;

import static org.junit.Assert.*;

import java.net.UnknownHostException;
import java.text.ParseException;

import org.junit.Test;

import com.module.models.Train;

public class TrainSwitchAnalyticsSvcGetPredictionTest {

	@Test
	public void testPredict() {
		TrainSwitchAnalyticsSvc trainSwitchAnalyticsSvc = new com.module.services.TrainSwitchAnalyticsSvc();
		
		String string = "Error";
		Train train = trainSwitchAnalyticsSvc.getSchema();
		String trainSerial = train.getTrainSerialNumber();
		
		String randSerialStr = Math.round(Math.random())
				+""+Math.round(Math.random())
				+""+Math.round(Math.random())
				+""+Math.round(Math.random())
				+""+Math.round(Math.random())
				+""+Math.round(Math.random())
				+""+Math.round(Math.random())
				+""+Math.round(Math.random());
		
		train.setTrainSerialNumber(randSerialStr);
		//train.setTrainSerialNumber(  );
		
		try {
			string = trainSwitchAnalyticsSvc.runPredict(train).getPrediction();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(string);
	}

}
