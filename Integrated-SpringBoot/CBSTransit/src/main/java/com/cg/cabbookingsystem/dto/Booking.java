package com.cg.cabbookingsystem.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Data transfer object class for booking object
 * 
 * @author Aman Dungarwal
 * @version 1.0
 */
@Entity
public class Booking {

	/** The booking id. */
	@Id
	private int bookingId;

	/** The source. */
	@Column(length = 15)
	private String source;

	/** The destination. */
	@Column(length = 15)
	private String destination;

	/** The trip status. */
	@Column(length = 15)
	private String tripStatus;

	/** The estimated fare. */
	private double estimatedFare;

	/** The final fare. */
	private double finalFare;

	/** The driver id. */
	private int driverId;

	/** The driver status. */
	private String driverStatus;

	/** The customer id. */
	private int customerId;

	/** The estimated time. */
	private int estimatedTime;

	/** The final time. */
	private int finalTime;

	/** The rating. */
	private int rating;

	/** The issues. */
	private String issues;

	/**
	 * Gets the issues.
	 *
	 * @return the issues
	 */
	public String getIssues() {
		return issues;
	}

	/**
	 * Instantiates a new booking.
	 *
	 * @param bookingId     the booking id
	 * @param source        the source
	 * @param destination   the destination
	 * @param tripStatus    the trip status
	 * @param estimatedFare the estimated fare
	 * @param finalFare     the final fare
	 * @param driverId      the driver id
	 * @param driverStatus  the driver status
	 * @param customerId    the customer id
	 * @param estimatedTime the estimated time
	 * @param finalTime     the final time
	 * @param rating        the rating
	 * @param issues        the issues
	 */
	public Booking(int bookingId, String source, String destination, String tripStatus, double estimatedFare,
			double finalFare, int driverId, String driverStatus, int customerId, int estimatedTime, int finalTime,
			int rating, String issues) {
		super();
		this.bookingId = bookingId;
		this.source = source;
		this.destination = destination;
		this.tripStatus = tripStatus;
		this.estimatedFare = estimatedFare;
		this.finalFare = finalFare;
		this.driverId = driverId;
		this.driverStatus = driverStatus;
		this.customerId = customerId;
		this.estimatedTime = estimatedTime;
		this.finalTime = finalTime;
		this.rating = rating;
		this.issues = issues;
	}

	/**
	 * Sets the issues.
	 *
	 * @param issues the new issues
	 */
	public void setIssues(String issues) {
		this.issues = issues;
	}

	/**
	 * Gets the driver status.
	 *
	 * @return the driver status
	 */
	public String getDriverStatus() {
		return driverStatus;
	}

	/**
	 * Sets the driver status.
	 *
	 * @param driverStatus the new driver status
	 */
	public void setDriverStatus(String driverStatus) {
		this.driverStatus = driverStatus;
	}

	/**
	 * Instantiates a new booking.
	 */
	public Booking() {
	}

	/**
	 * Instantiates a new booking.
	 *
	 * @param bookingId     the booking id
	 * @param source        the source
	 * @param destination   the destination
	 * @param tripStatus    the trip status
	 * @param estimatedFare the estimated fare
	 * @param finalFare     the final fare
	 * @param driverId      the driver id
	 * @param customerId    the customer id
	 * @param estimatedTime the estimated time
	 * @param finalTime     the final time
	 * @param rating        the rating
	 */
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
	 * Gets the source.
	 *
	 * @return the source
	 */
	public String getSource() {
		return source;
	}

	/**
	 * Sets the source.
	 *
	 * @param source the new source
	 */
	public void setSource(String source) {
		this.source = source;
	}

	/**
	 * Gets the destination.
	 *
	 * @return the destination
	 */
	public String getDestination() {
		return destination;
	}

	/**
	 * Sets the destination.
	 *
	 * @param destination the new destination
	 */
	public void setDestination(String destination) {
		this.destination = destination;
	}

	/**
	 * Gets the trip status.
	 *
	 * @return the trip status
	 */
	public String getTripStatus() {
		return tripStatus;
	}

	/**
	 * Sets the trip status.
	 *
	 * @param tripStatus the new trip status
	 */
	public void setTripStatus(String tripStatus) {
		this.tripStatus = tripStatus;
	}

	/**
	 * Gets the estimated fare.
	 *
	 * @return the estimated fare
	 */
	public double getEstimatedFare() {
		return estimatedFare;
	}

	/**
	 * Sets the estimated fare.
	 *
	 * @param estimatedFare the new estimated fare
	 */
	public void setEstimatedFare(double estimatedFare) {
		this.estimatedFare = estimatedFare;
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
	 * Gets the estimated time.
	 *
	 * @return the estimated time
	 */
	public int getEstimatedTime() {
		return estimatedTime;
	}

	/**
	 * Sets the estimated time.
	 *
	 * @param estimatedTime the new estimated time
	 */
	public void setEstimatedTime(int estimatedTime) {
		this.estimatedTime = estimatedTime;
	}

	/**
	 * Gets the final time.
	 *
	 * @return the final time
	 */
	public int getFinalTime() {
		return finalTime;
	}

	/**
	 * Sets the final time.
	 *
	 * @param finalTime the new final time
	 */
	public void setFinalTime(int finalTime) {
		this.finalTime = finalTime;
	}

	/**
	 * Gets the rating.
	 *
	 * @return the rating
	 */
	public int getRating() {
		return rating;
	}

	/**
	 * Sets the rating.
	 *
	 * @param rating the new rating
	 */
	public void setRating(int rating) {
		this.rating = rating;
	}
}
