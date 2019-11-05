package com.cg.cabbookingsystem.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class Vehicle{

	private String vehicleNo;
	private int sizeOfCab;
	private String model;
	private String status; //Free/Booked
	private String location;
	
	public Vehicle() {
		// TODO Auto-generated constructor stub
	}
	
	public Vehicle(String vehicleNo, int sizeOfCab, String model, String status, String location) {
		super();
		this.vehicleNo = vehicleNo;
		this.sizeOfCab = sizeOfCab;
		this.model = model;
		this.status = status;
		this.location = location;
	}

	public String getVehicleNo() {
		return vehicleNo;
	}
	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}
	public int getSize() {
		return sizeOfCab;
	}
	public void setSize(int size) {
		this.sizeOfCab = size;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
}
