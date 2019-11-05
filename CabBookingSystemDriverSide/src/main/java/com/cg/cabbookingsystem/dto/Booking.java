package com.cg.cabbookingsystem.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@NamedQuery(name = "getPastRidesOfDriver", query = "FROM Booking WHERE driverId =:driverId")
@SequenceGenerator(name = "BOOKING_ID_GEN", sequenceName = "booking_id_gen")
public class Booking {

	@Id
	@GeneratedValue(generator = "booking_id_gen")
	private int bookingId;
	@Size(min = 2,max = 40)
	private String source;
	@Size(min = 2,max = 40)
	private String destination;
	private int vehicleSize;
	private int driverId;
	private int customerId;
	private String driverStatus;
	private String customerStatus;
	private String tripStatus;
	private double estimatedFare;
	private double estimatedTime;
	private double finalFare;
	private int rating;
	
	public double getEstimatedFare() {
		return estimatedFare;
	}
	public void setEstimatedFare(double estimatedFare) {
		this.estimatedFare = estimatedFare;
	}
	public double getEstimatedTime() {
		return estimatedTime;
	}
	public void setEstimatedTime(double estimatedTime) {
		this.estimatedTime = estimatedTime;
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
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
}
