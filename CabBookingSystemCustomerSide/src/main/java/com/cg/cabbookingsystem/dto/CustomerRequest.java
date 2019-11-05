package com.cg.cabbookingsystem.dto;

import org.springframework.stereotype.Component;

@Component
public class CustomerRequest {
	
	private int requestId;
	private String source;
	private String destination;
	private int sizeOf;
	private String model;
	public int getRequestId() {
		return requestId;
	}
	public void setRequestId(int requestId) {
		this.requestId = requestId;
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
	public int getSize() {
		return sizeOf;
	}
	public void setSize(int size) {
		this.sizeOf = size;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}

}
