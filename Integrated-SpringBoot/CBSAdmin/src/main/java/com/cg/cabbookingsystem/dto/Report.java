package com.cg.cabbookingsystem.dto;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/**
 * An entity class which contains the information of a Report Object.
 * @author Vineeta
 * @version 1.0
 *
 */

@Entity
@SequenceGenerator(name = "rseq", allocationSize = 10, initialValue = 1001, sequenceName = "seq_report")
public class Report {
	@Id
	@GeneratedValue(generator = "rseq")
	private int reportId;
	@Column(unique = true)
	private int bookingId;
	private int customerId;
	private int driverId;
	private String issues;

	public Report() {

	}

	public Report(int reportId, int bookingId, int customerId, int driverId, String issues) {
		super();
		this.reportId = reportId;
		this.bookingId = bookingId;
		this.customerId = customerId;
		this.driverId = driverId;
		this.issues = issues;
	}

	public int getReportId() {
		return reportId;
	}

	public void setReportId(int reportId) {
		this.reportId = reportId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

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

}
