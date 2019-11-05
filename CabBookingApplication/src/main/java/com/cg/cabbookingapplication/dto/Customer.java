package com.cg.cabbookingapplication.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

//import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name = "customer")
@SequenceGenerator(name = "cseq", sequenceName = "cust_seq")
@NamedQuery(name = "byCustomerCredential", query = "From Customer where email=:email and password=:password")
public class Customer {

	@Id
	@GeneratedValue(generator = "cseq")
	private int id;
	//@NotEmpty(message = "Name is mandatory")
	@Column(length = 20)
	private String name;
	//@NotEmpty(message = "Age is mandatory")
	@Column(length = 10)
	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date dob;
	private String gender;
	//@NotEmpty(message = "Contact number cannot be empty")
	private long contactNo;
	//@NotEmpty(message = "email cannot be empty")
	private String email;
	//@NotEmpty(message = "address cannot be empty")
	private String address;
	private String password;
	private double wallet;

	public Customer() {
		// TODO Auto-generated constructor stub
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

	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getWallet() {
		return wallet;
	}

	public void setWallet(double wallet) {
		this.wallet = wallet;
	}

	public Customer(int id, String name, Date dob, String gender, long contactNo, String email, String address,
			String password, double wallet) {
		super();
		this.id = id;
		this.name = name;
		this.dob = dob;
		this.gender = gender;
		this.contactNo = contactNo;
		this.email = email;
		this.address = address;
		
		this.password = password;
		this.wallet = wallet;
	}

}
