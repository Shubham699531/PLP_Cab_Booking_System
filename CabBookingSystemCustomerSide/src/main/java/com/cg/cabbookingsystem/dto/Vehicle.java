package com.cg.cabbookingsystem.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "vehicle")
@NamedQuery(name = "getVehicles", query = "FROM Vehicle WHERE (sizeOfCab=:sizeOfCab AND model=:model AND location =:location AND status='free')")
public class Vehicle {

	@Id
	private String vehicleNo;
	private int sizeOfCab;
	private String model;
	private String status; //Free/Booked
	private String location;
	
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
