package com.cg.cbsui.dto;

import java.util.List;

public class CustomerRequirement {

	private int customerId;
	private String source;
	private String destination;
	private int vehicleSize;
	
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public CustomerRequirement() {
	}
	public CustomerRequirement(int customerId,String source, String destination, int vehicleSize) {
		super();
		this.customerId = customerId;
		this.source = source;
		this.destination = destination;
		this.vehicleSize = vehicleSize;
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
