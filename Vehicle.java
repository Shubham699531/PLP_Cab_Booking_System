package com.cg.cabbookingsystem.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Vehicle {

	@Id
	private String vehicleNo;
	private int categoryId;
	@Column(length = 50)
	private String model;
	@Column(length = 50)
	private String location;

	public Vehicle() {
	}

	public Vehicle(String vehicleNo, int categoryId, String model, String location) {
		this.vehicleNo = vehicleNo;
		this.categoryId = categoryId;
		this.model = model;
		this.location = location;
	}

	public String getVehicleNo() {
		return vehicleNo;
	}

	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int size) {
		this.categoryId = size;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
}
