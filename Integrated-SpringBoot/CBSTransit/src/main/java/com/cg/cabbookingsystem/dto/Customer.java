package com.cg.cabbookingsystem.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

/**
 * Data transfer object class for customer object.
 *
 * @author Aman Dungarwal
 * @version 1.0
 */
@Entity
@NamedQuery(name = "fetchByEmail", query = "FROM Customer WHERE email=:email")
public class Customer {

	/** The customer id. */
	@Id
	private int customerId;

	/** The name. */
	@Column(length = 50)
	private String name;

	/** The dob. */
	private Date dob;

	/** The gender. */
	@Column(length = 50)
	private String gender;

	/** The contact no. */
	@Column(length = 50)
	private String contactNo;

	/** The email. */
	@Column(length = 50, unique = true)
	private String email;

	/** The password. */
	@Column(length = 50)
	private String password;

	/** The address. */
	@Column(length = 50)
	private String address;

	/** The wallet. */
	private double wallet;

	/**
	 * Gets the wallet.
	 *
	 * @return the wallet
	 */
	public double getWallet() {
		return wallet;
	}

	/**
	 * Sets the wallet.
	 *
	 * @param wallet the new wallet
	 */
	public void setWallet(double wallet) {
		this.wallet = wallet;
	}

	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password.
	 *
	 * @param password the new password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getId() {
		return customerId;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(int id) {
		this.customerId = id;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the dob.
	 *
	 * @return the dob
	 */
	public Date getDob() {
		return dob;
	}

	/**
	 * Sets the dob.
	 *
	 * @param dob the new dob
	 */
	public void setDob(Date dob) {
		this.dob = dob;
	}

	/**
	 * Gets the gender.
	 *
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * Sets the gender.
	 *
	 * @param gender the new gender
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * Gets the contact no.
	 *
	 * @return the contact no
	 */
	public String getContactNo() {
		return contactNo;
	}

	/**
	 * Sets the contact no.
	 *
	 * @param contactNo the new contact no
	 */
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email.
	 *
	 * @param email the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Gets the address.
	 *
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Sets the address.
	 *
	 * @param address the new address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

}
