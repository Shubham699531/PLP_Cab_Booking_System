package com.cg.cab.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@NamedQuery(name = "validateLogin",query = "FROM Driver WHERE email=:email AND password=:password")
@SequenceGenerator(name = "DRIVER_SEQ_GEN", sequenceName = "driver_seq")
public class Driver {
	@Id
	@GeneratedValue(generator = "DRIVER_SEQ_GEN")//(strategy = GenerationType.IDENTITY)
	private int driverId;
	@Column(length = 50)
	private String name;
	@Column(length = 50)
	private String password;
	private Date dob;
	@Column(length = 50)
	private String gender;
	@Column(length = 50)
	private String contactNo;
	@Column(length = 50,unique = true)
	private String email;
	@Column(length = 80)
	private String address;
	@Column(length = 50)
	private String driverStatus; //status
	@Column(length = 30)
	private String vehicleNo;
	private String drivingLicense;
	private int rating;
	private int numberOfTrips;
	
	
	//To be added - drivingLicense, rating, numberOfTrips
	//@Column(length=20)
	//private String vehicleType;
	
	public String getDrivingLicense() {
		return drivingLicense;
	}
	public void setDrivingLicense(String drivingLicense) {
		this.drivingLicense = drivingLicense;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public int getNumberOfTrips() {
		return numberOfTrips;
	}
	public void setNumberOfTrips(int numberOfTrips) {
		this.numberOfTrips = numberOfTrips;
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
