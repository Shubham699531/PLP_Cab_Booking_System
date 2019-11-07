package com.cg.cbslogin.dto;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class CustomerRequest {

	private int customerId;
	private String source;
	private String destination;
	private int vehicleSize;
	private String model;
	
	
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public int getVehicleSize() {
		return vehicleSize;
	}
	public void setVehicleSize(int vehicleSize) {
		this.vehicleSize = vehicleSize;
	}
	
	
}