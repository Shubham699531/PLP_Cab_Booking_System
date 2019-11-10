package com.cg.cabbookingsystem.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Data transfer object class for Payment object.
 *
 * @author Aman Dungarwal
 * @version 1.0
 */
@Entity
public class Payment {

	/** The payment id. */
	@Id
	private int paymentId;

	/** The customer id. */
	private int customerId;

	/** The driver id. */
	private int driverId;

	/** The booking id. */
	@Column(unique = true)
	private int bookingId;

	/** The final fare. */
	private double finalFare;

	/**
	 * Gets the payment id.
	 *
	 * @return the payment id
	 */
	public int getPaymentId() {
		return paymentId;
	}

	/**
	 * Sets the payment id.
	 *
	 * @param paymentId the new payment id
	 */
	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
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
	 * Gets the final fare.
	 *
	 * @return the final fare
	 */
	public double getFinalFare() {
		return finalFare;
	}

	/**
	 * Sets the final fare.
	 *
	 * @param finalFare the new final fare
	 */
	public void setFinalFare(double finalFare) {
		this.finalFare = finalFare;
	}
}