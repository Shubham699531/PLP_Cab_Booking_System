 package com.cg.cabbookingsystem.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
/**
 * An entity class which contains the information of a Booking Object.
 * @author Vineeta
 * @version 1.0
 *
 */
@Entity 
@SequenceGenerator(name = "bookseq", sequenceName = "seq_booking")
public class Booking {
	@Id
	@GeneratedValue(generator = "bookseq")
	private int bookingId;
	private String source;
	private String destination;
	private int driverId;
	private int customerId;
	private String driverStatus;
	private String tripStatus;
	private double estimatedFare;
	private int estimatedTime;
	private int finalTime;
	private double finalFare;
	private int rating;
	
	
	public Booking() { 
		
	}


	public Booking(int bookingId, String source, String destination, int driverId, int customerId, String driverStatus,
			String tripStatus, double estimatedFare, int estimatedTime, int finalTime, double finalFare, int rating) {
		super();
		this.bookingId = bookingId;
		this.source = source;
		this.destination = destination;
		this.driverId = driverId;
		this.customerId = customerId;
		this.driverStatus = driverStatus;
		this.tripStatus = tripStatus;
		this.estimatedFare = estimatedFare;
		this.estimatedTime = estimatedTime;
		this.finalTime = finalTime;
		this.finalFare = finalFare;
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


	public String getDriverStatus() {
		return driverStatus;
	}


	public void setDriverStatus(String driverStatus) {
		this.driverStatus = driverStatus;
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


	public double getFinalFare() {
		return finalFare;
	}


	public void setFinalFare(double finalFare) {
		this.finalFare = finalFare;
	}


	public int getRating() {
		return rating;
	}


	public void setRating(int rating) {
		this.rating = rating;
	}

	
	
}
