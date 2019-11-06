package com.cg.cbs.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
/**
 * TripDetails class for holding properties of TripDetails object.
 * It is mapped to "trip_details" with primary key request_id which is auto_generated
 * @author Akash
 *
 */
@Entity
@Table(name = "customer_request")
public class CustomerRequest {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "request_id")
	private int requestId;
	
	@Column(name = "customer_id")
	private int customerId;
	private String source;
	private String destination;
	private int vehicleSize;
	private String model;
	
	public CustomerRequest() {
		
	}

	public CustomerRequest(int requestId, int user_id, String source, String destination, int sizeOf, String model) {
		super();
		this.requestId = requestId;
		this.customerId = user_id;
		this.source = source;
		this.destination = destination;
		this.vehicleSize = sizeOf;
		this.model = model;
	}

	public int getRequestId() {
		return requestId;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}

	public int getUserId() {
		return customerId;
	}

	public void setUserId(int userId) {
		this.customerId = userId;
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

	public int getSizeOf() {
		return vehicleSize;
	}

	public void setSizeOf(int sizeOf) {
		this.vehicleSize = sizeOf;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}
	
}
