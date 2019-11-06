package com.cg.cabbookingsystem.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;

@Entity
@NamedQuery(name = "fetchByEmail", query = "FROM DriverModel WHERE email=:email")
@NamedQuery(name = "validateLogin",query = "FROM DriverModel WHERE email=:email AND password=:password")
//@SequenceGenerator(name = "DRIVER_SEQ_GEN", sequenceName = "driver_seq")
public class DriverModel{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	@Column(name ="vehicle_no", length = 30)
	private String vehicleNo;
	@Column(length=20)
	private String vehicleType;
	
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
	public int getDriverId() {
		return driverId;
	}
	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
