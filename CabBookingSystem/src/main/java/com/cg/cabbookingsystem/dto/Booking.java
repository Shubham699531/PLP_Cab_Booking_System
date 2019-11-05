package com.cg.cabbookingsystem.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "booking_id_seq",sequenceName = "seq_booking_id")
public class Booking {

	@Id
	@GeneratedValue(generator = "booking_id_seq")
	private int bookingId;
	private String source;
	private String destination;
	private int vehicleSize;
	private int driverId;
	private int customerId;
	private String driverStatus;
	private String customerStatus;
	private String tripStatus;
	private double fare;
	private int rating;
	
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public double getFare() {
		return fare;
	}
	public void setFare(double fare) {
		this.fare = fare;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
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
	public int getVehicleSize() {
		return vehicleSize;
	}
	public void setVehicleSize(int vehicleSize) {
		this.vehicleSize = vehicleSize;
	}
	public int getDriverId() {
		return driverId;
	}
	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}
	public String getDriverStatus() {
		return driverStatus;
	}
	public void setDriverStatus(String driverStatus) {
		this.driverStatus = driverStatus;
	}
	public String getCustomerStatus() {
		return customerStatus;
	}
	public void setCustomerStatus(String customerStatus) {
		this.customerStatus = customerStatus;
	}
	public String getTripStatus() {
		return tripStatus;
	}
	public void setTripStatus(String tripStatus) {
		this.tripStatus = tripStatus;
	}
	
	
}
