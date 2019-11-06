package com.cg.cbslogin.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;

@Entity
@NamedQuery(name = "fetchDriverByEmail",query = "FROM Driver WHERE email=:email")
@SequenceGenerator(name = "driver_seq", sequenceName = "seq_driver")
public class Driver {

	@Id
	@GeneratedValue(generator = "driver_seq")
	private int id;
	private String name;
	private Date dob;
	private String gender;
	private String contactNo;
	@Column(unique = true)
	private String email;
	private String address;
	private String vehicleNo;
	private String status;
	
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getContactNo() {
		return contactNo;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getVehicleNo() {
		return vehicleNo;
	}
	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}
	
	
	
}
