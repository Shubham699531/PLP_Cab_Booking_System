package com.cg.cbs.pf.dto;

/**
 * This is the bean class for Report entity.
 * @author Anchita Roy
 * @version 1.0
 * 
 */

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "repseq", sequenceName = "rep_seq", allocationSize = 1)
public class Report {

	@Id
	@GeneratedValue(generator = "repseq")
	private int reportId;
	@Column(unique = true)
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