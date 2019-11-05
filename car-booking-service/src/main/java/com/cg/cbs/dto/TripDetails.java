package com.cg.cbs.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "trip_details")
public class TripDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "request_id")
	private int requestId;
	
	@Column(name = "user_id")
	private int userId;
	private String source;
	private String destination;
	private int sizeOf;
	private String model;
	
	public TripDetails() {
		
	}

	public TripDetails(int requestId, int user_id, String source, String destination, int sizeOf, String model) {
		super();
		this.requestId = requestId;
		this.userId = user_id;
		this.source = source;
		this.destination = destination;
		this.sizeOf = sizeOf;
		this.model = model;
	}

	public int getRequestId() {
		return requestId;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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
		return sizeOf;
	}

	public void setSizeOf(int sizeOf) {
		this.sizeOf = sizeOf;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}
	
}
