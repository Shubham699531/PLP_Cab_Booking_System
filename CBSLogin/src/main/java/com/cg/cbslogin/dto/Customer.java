package com.cg.cbslogin.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;

@Entity
@NamedQuery(name = "fetchByEmail",query = "FROM Customer WHERE email=:email")
@SequenceGenerator(name = "customer_seq", sequenceName = "seq_customer")
public class Customer {

	@Id
	@GeneratedValue(generator = "customer_seq")
	private int id;
	private String name;
	private Date dob;
	private String gender;
	private String contactNo;
	@Column(unique = true)
	private String email;
	private String password;
	private String address;
	private double wallet;
	
	
	public double getWallet() {
		return wallet;
	}
	public void setWallet(double wallet) {
		this.wallet = wallet;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public void setContactNo(String contactNo) {
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
	
	
}
