package com.cg.cbs.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
/**
 * DTO for holding customer trip details 
 * @author Akash
 *
 */

@Entity
@SequenceGenerator(name = "request_seq",sequenceName = "seq_request")
public class CustomerRequest {

	@Id
	@GeneratedValue(generator = "request_seq")
	private int requestId;
	private int customerId;
	private String source;
	private String destination;
	private int vehicleSize;
	private String model;
	
	
	public CustomerRequest(int requestId, int customerId, String source, String destination, int vehicleSize,
			String model) {
		super();
		this.requestId = requestId;
		this.customerId = customerId;
		this.source = source;
		this.destination = destination;
		this.vehicleSize = vehicleSize;
		this.model = model;
	}
	public int getRequestId() {
		return requestId;
	}
	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}
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
