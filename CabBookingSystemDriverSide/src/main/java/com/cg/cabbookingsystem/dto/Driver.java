package com.cg.cabbookingsystem.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "DRIVER_SEQ_GEN", sequenceName = "driver_seq")
public class Driver {
	
	@GeneratedValue(generator = "DRIVER_SEQ_GEN")
	private int driverId;
	@Column(length = 40)
	private String name;
	@Column(length = 30)
	private String password;
	private Date dob;
	@Column(length = 10)
	private String gender;
	@Column(length = 20)
	private String contactNo;
	@Column(length = 40)
	private String email;
	@Column(length = 80)
	private String address;
	@Column(length = 20)
	private String driverStatus = "Free";
	@Id
	@Column(name ="vehicle_no", length = 30)
	private String vehicleNo;
	
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDriverStatus() {
		return driverStatus;
	}
	public void setDriverStatus(String driverStatus) {
		this.driverStatus = driverStatus;
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
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
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
