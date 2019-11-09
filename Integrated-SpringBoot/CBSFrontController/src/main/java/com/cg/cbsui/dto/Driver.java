package com.cg.cbsui.dto;

import java.util.Date;


public class Driver {

	private int driverId;
	private String name;
	private Date dob;
	private String gender;
	private String contactNo;
	private String email;
	private String password;
	private String address;
	private String vehicleNo;
	private String drivingLicense;
	private String driverStatus;
	private double rating;
	private int numberOfTrips;

	public Driver() {
	}

	public Driver(int driverId, String name, Date dob, String gender, String contactNo, String email, String password,
			String address, String vehicleNo, String drivingLicense, String driverStatus, double rating,
			int numberOfTrips) {
		this.driverId = driverId;
		this.name = name;
		this.dob = dob;
		this.gender = gender;
		this.contactNo = contactNo;
		this.email = email;
		this.password = password;
		this.address = address;
		this.vehicleNo = vehicleNo;
		this.drivingLicense = drivingLicense;
		this.driverStatus = driverStatus;
		this.rating = rating;
		this.numberOfTrips = numberOfTrips;
	}

	public int getDriverId() {
		return driverId;
	}

	public void setDriverId(int id) {
		this.driverId = id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDrivingLicense() {
		return drivingLicense;
	}

	public void setDrivingLicense(String drivingLicense) {
		this.drivingLicense = drivingLicense;
	}

	public String getDriverStatus() {
		return driverStatus;
	}

	public void setDriverStatus(String driverStatus) {
		this.driverStatus = driverStatus;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public int getNumberOfTrips() {
		return numberOfTrips;
	}

	public void setNumberOfTrips(int numberOfTrips) {
		this.numberOfTrips = numberOfTrips;
	}
}