package com.module.models;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@XmlRootElement
@JsonIgnoreProperties(ignoreUnknown=true)
public class Train {
	private String trainSerialNumber = null;
	private String operatorSwitchSelection = null;
	private String prediction = "Error: Prediction returned null."; 
	private String trainSwitchDirection = null;
	private Time time = new Time();
	
	public String getTrainSerialNumber() {
		return trainSerialNumber;
	}
	public void setTrainSerialNumber(String trainSerialNumber) {
		this.trainSerialNumber = trainSerialNumber;
	}
	public String getOperatorSwitchSelection() {
		return operatorSwitchSelection;
	}
	public void setOperatorSwitchSelection(String operatorSwitchSelection) {
		this.operatorSwitchSelection = operatorSwitchSelection;
	}
	public String getPrediction() {
		return prediction;
	}
	public void setPrediction(String prediction) {
		this.prediction = prediction;
	}
	public String getTrainSwitchDirection() {
		return trainSwitchDirection;
	}
	public void setTrainSwitchDirection(String trainSwitchDirection) {
		this.trainSwitchDirection = trainSwitchDirection;
	}
	public Time getTime() {
		return time;
	}
	public void setTime(Time time) {
		this.time = time;
	} 
	
	@Override
	public String toString() {
		return "Train [Serial Number=" + trainSerialNumber + ", Operator Switch Selection=" 
				+ operatorSwitchSelection + ", Prediction="
				+ prediction + ", Train Switch Direction=" + trainSwitchDirection
				+ ", Time=" + time + "]";
	}
}

