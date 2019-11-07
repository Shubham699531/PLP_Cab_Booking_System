package com.cg.cabbookingsystem.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Booking {

	@Id
	private int bookingId;
	@Column(length = 50)
	private String source;
	@Column(length = 50)
	private String destination;
	private int driverId;
	private int customerId;
	@Column(length = 50)
	private String tripStatus;
	@Column(length = 50)
	private String driverStatus;
	private double estimatedFare;
	private double finalFare;
	private int estimatedTime;
	private int finalTime;
	private int rating;
	private String issues;

	public Booking() {
	}

	public Booking(int bookingId, String source, String destination, int driverId, int customerId, String tripStatus,
			double estimatedFare, double finalFare, int estimatedTime, int finalTime, int rating, String driverStatus) {
		this.bookingId = bookingId;
		this.source = source;
		this.destination = destination;
		this.driverId = driverId;
		this.customerId = customerId;
		this.tripStatus = tripStatus;
		this.estimatedFare = estimatedFare;
		this.finalFare = finalFare;
		this.estimatedTime = estimatedTime;
		this.finalTime = finalTime;
		this.rating = rating;
		this.driverStatus = driverStatus;
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

	public String getDriverStatus() {
		return driverStatus;
	}

	public void setDriverStatus(String driverStatus) {
		this.driverStatus = driverStatus;
	}
}
