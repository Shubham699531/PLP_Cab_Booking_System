package com.cg.cabbookingsystem.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Data transfer object class for Driver object.
 *
 * @author Aman Dungarwal
 * @version 1.0
 */
@Entity
public class Driver {

	/** The driver id. */
	@Id
	private int driverId;

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

	/** The vehicle no. */
	@Column(length = 50)
	private String vehicleNo;

	/** The driving license. */
	@Column(length = 50)
	private String drivingLicense;

	/** The driver status. */
	@Column(length = 50)
	private String driverStatus;

	/** The rating. */
	private double rating;

	/** The number of trips. */
	private int numberOfTrips;

	/**
	 * Instantiates a new driver.
	 */
	public Driver() {
	}

	/**
	 * Instantiates a new driver.
	 *
	 * @param driverId       the driver id
	 * @param name           the name
	 * @param dob            the dob
	 * @param gender         the gender
	 * @param contactNo      the contact no
	 * @param email          the email
	 * @param password       the password
	 * @param address        the address
	 * @param vehicleNo      the vehicle no
	 * @param drivingLicense the driving license
	 * @param driverStatus   the driver status
	 * @param rating         the rating
	 * @param numberOfTrips  the number of trips
	 */
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

	/**
	 * Gets the driver id.
	 *
	 * @return the driver id
	 */
	public int getDriverId() {
		return driverId;
	}

	/**
	 * Sets the driver id.
	 *
	 * @param id the new driver id
	 */
	public void setDriverId(int id) {
		this.driverId = id;
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

	/**
	 * Gets the vehicle no.
	 *
	 * @return the vehicle no
	 */
	public String getVehicleNo() {
		return vehicleNo;
	}

	/**
	 * Sets the vehicle no.
	 *
	 * @param vehicleNo the new vehicle no
	 */
	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
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
	 * Gets the driving license.
	 *
	 * @return the driving license
	 */
	public String getDrivingLicense() {
		return drivingLicense;
	}

	/**
	 * Sets the driving license.
	 *
	 * @param drivingLicense the new driving license
	 */
	public void setDrivingLicense(String drivingLicense) {
		this.drivingLicense = drivingLicense;
	}

	/**
	 * Gets the driver status.
	 *
	 * @return the driver status
	 */
	public String getDriverStatus() {
		return driverStatus;
	}

	/**
	 * Sets the driver status.
	 *
	 * @param driverStatus the new driver status
	 */
	public void setDriverStatus(String driverStatus) {
		this.driverStatus = driverStatus;
	}

	/**
	 * Gets the rating.
	 *
	 * @return the rating
	 */
	public double getRating() {
		return rating;
	}

	/**
	 * Sets the rating.
	 *
	 * @param rating the new rating
	 */
	public void setRating(double rating) {
		this.rating = rating;
	}

	/**
	 * Gets the number of trips.
	 *
	 * @return the number of trips
	 */
	public int getNumberOfTrips() {
		return numberOfTrips;
	}

	/**
	 * Sets the number of trips.
	 *
	 * @param numberOfTrips the new number of trips
	 */
	public void setNumberOfTrips(int numberOfTrips) {
		this.numberOfTrips = numberOfTrips;
	}
}