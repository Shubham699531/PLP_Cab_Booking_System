package com.cg.cabbookingsystem.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Report {

	@Id
	private int reportId;
	private int bookingId;
	private int customerId;
	private int driverId;
	private String issues;

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public int getDriverId() {
		return driverId;
	}

	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}

	public String getIssues() {
		return issues;
	}

	public void setIssues(String issues) {
		this.issues = issues;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

}
