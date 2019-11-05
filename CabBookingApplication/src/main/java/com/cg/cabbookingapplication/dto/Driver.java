package com.cg.cabbookingapplication.dto;

import java.util.Date;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "driver")
@SequenceGenerator(name = "dseq", sequenceName = "driver_seq")
@NamedQuery(name = "byCredential", query = "From Driver where email=:email and password=:password")
public class Driver {

	@Id
	@GeneratedValue(generator = "dseq")
	private int id;
	private String name;
	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date dob;
	private String gender;
	private long contactNo;
	private String email;
	private String address;
	private String vehicleNo;
	private double rating = 0;
	private String password;
	private int noOfTrips = 0;
	private String status= "not confirmed";

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Driver() {
		// TODO Auto-generated constructor stub
	}

	

	public Driver(int id, String name, Date dob, String gender, long contactNo, String email, String address,
			String vehicleNo, double rating, String password, int noOfTrips, String status) {
		super();
		this.id = id;
		this.name = name;
		this.dob = dob;
		this.gender = gender;
		this.contactNo = contactNo;
		this.email = email;
		this.address = address;
		this.vehicleNo = vehicleNo;
		this.rating = rating;
		this.password = password;
		this.noOfTrips = noOfTrips;
		this.status = status;
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

	public long getContactNo() {
		return contactNo;
	}

	public void setContactNo(long contactNo) {
		this.contactNo = contactNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getNoOfTrips() {
		return noOfTrips;
	}

	public void setNoOfTrips(int noOfTrips) {
		this.noOfTrips = noOfTrips;
	}

}
