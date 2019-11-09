package com.cg.cabbookingsystem.dto;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
@NamedQuery(name = "fetchVehicleByCategory", query = "FROM Vehicle WHERE model=:model AND status='free'")
@NamedQuery(name = "fetchAllVehicle", query = "FROM Vehicle")
public class Vehicle {

	@Id
	private String vehicleNo;
	private int categoryId;
	@Column(length = 50)
	private String model;
	@Column(length = 50)
	private String status;
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
