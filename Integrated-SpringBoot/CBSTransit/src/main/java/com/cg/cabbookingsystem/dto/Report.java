package com.cg.cabbookingsystem.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/**
 * Data transfer object class for report object.
 *
 * @author Aman Dungarwal
 * @version 1.0
 */
@Entity
@SequenceGenerator(name = "repseq", sequenceName = "rep_seq", allocationSize = 1)
public class Report {

	/** The report id. */
	@Id
	private int reportId;

	/** The booking id. */
	@Column(unique = true)
	private int bookingId;

	/** The customer id. */
	private int customerId;

	/** The driver id. */
	private int driverId;

	/** The issues. */
	private String issues;

	/**
	 * Gets the booking id.
	 *
	 * @return the booking id
	 */
	public int getBookingId() {
		return bookingId;
	}

	/**
	 * Sets the booking id.
	 *
	 * @param bookingId the new booking id
	 */
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
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
	 * @param driverId the new driver id
	 */
	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}

	/**
	 * Gets the issues.
	 *
	 * @return the issues
	 */
	public String getIssues() {
		return issues;
	}

	/**
	 * Sets the issues.
	 *
	 * @param issues the new issues
	 */
	public void setIssues(String issues) {
		this.issues = issues;
	}

	/**
	 * Gets the customer id.
	 *
	 * @return the customer id
	 */
	public int getCustomerId() {
		return customerId;
	}

	/**
	 * Sets the customer id.
	 *
	 * @param customerId the new customer id
	 */
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

}