package com.cg.cabbookingsystem.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "searchBookingDetails", query = "FROM Booking WHERE driverId=:driverId AND tripStatus='confirmed'")
@NamedQuery(name = "getPastRidesOfDriver", query = "FROM Booking WHERE driverId =:driverId AND tripStatus='Rated'")
public class Booking {

	@Id
	private int bookingId;
	@Column(length = 15)
	private String source;
	@Column(length = 15)
	private String destination;
	@Column(length = 15)
	private String tripStatus;
	private double estimatedFare;
	private double finalFare;
	private int driverId;
	private String driverStatus;
	private int customerId;
	private int estimatedTime;
	private int finalTime;
	private int rating;
	private String issues;
	
	public String getIssues() {
		return issues;
	}

	public void setIssues(String issues) {
		this.issues = issues;
	}

	public String getDriverStatus() {
		return driverStatus;
	}

	public void setDriverStatus(String driverStatus) {
		this.driverStatus = driverStatus;
	}

	public Booking() {
	}

	public Booking(int bookingId, String source, String destination, String tripStatus, double estimatedFare,
			double finalFare, int driverId, int customerId, int estimatedTime, int finalTime, int rating) {
		this.bookingId = bookingId;
		this.source = source;
		this.destination = destination;
		this.tripStatus = tripStatus;
		this.estimatedFare = estimatedFare;
		this.finalFare = finalFare;
		this.driverId = driverId;
		this.customerId = customerId;
		this.estimatedTime = estimatedTime;
		this.finalTime = finalTime;
		this.rating = rating;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getTripStatus() {
		return tripStatus;
	}

	public void setTripStatus(String tripStatus) {
		this.tripStatus = tripStatus;
	}

	public double getEstimatedFare() {
		return estimatedFare;
	}

	public void setEstimatedFare(double estimatedFare) {
		this.estimatedFare = estimatedFare;
	}

	public double getFinalFare() {
		return finalFare;
	}

	public void setFinalFare(double finalFare) {
		this.finalFare = finalFare;
	}

	public int getDriverId() {
		return driverId;
	}

	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getEstimatedTime() {
		return estimatedTime;
	}

	public void setEstimatedTime(int estimatedTime) {
		this.estimatedTime = estimatedTime;
	}

	public int getFinalTime() {
		return finalTime;
	}

	public void setFinalTime(int finalTime) {
		this.finalTime = finalTime;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
}
