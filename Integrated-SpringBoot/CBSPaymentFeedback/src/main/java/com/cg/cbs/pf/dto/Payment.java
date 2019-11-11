package com.cg.cbs.pf.dto;

/**
 * This is the bean class for Payment entity.
 * @author Anchita Roy
 * @version 1.0
 */

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "payment_seq", sequenceName = "seq_payment")
public class Payment {

	@Id
	@GeneratedValue(generator = "payment_seq")
	private int paymentId;
	private int customerId;
	private int driverId;
	@Column(unique = true)
	private int bookingId;
	private double finalFare;

	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getDriverId() {
		return driverId;
	}

	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public double getFinalFare() {
		return finalFare;
	}

	public void setFinalFare(double finalFare) {
		this.finalFare = finalFare;
	}
}