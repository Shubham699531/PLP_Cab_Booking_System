package com.cg.cabbookingsystem.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Vehicle {

	@Id
	private String vehicleNo;
	private int categoryId;
	@Column(length = 50)
	private String model;
	@Column(length = 50)
	private String status;
	@NotNull(message = "Car location cannot be empty")
	@Column(length = 50)
	private String location;
	
	public String getVehicleNo() {
		return vehicleNo;
	}
	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}
	public int getSize() {
		return categoryId;
	}
	public void setSize(int size) {
		this.categoryId = size;
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
