package com.cg.cabbookingsystem.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CustomerRequest {
	@Id
	private int requestId;
	private int customerId;
	private String source;
	private String destination;
	private int vehicleSize;
	private String model;

	public int getRequestId() {
		return requestId;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
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

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}
}
