package com.cg.cabbookingsystem.service;

import com.cg.cabbookingsystem.dto.Booking;
import com.cg.cabbookingsystem.dto.Driver;
import com.cg.cabbookingsystem.dto.Vehicle;
import com.cg.cabbookingsystem.exception.InvalidBookingException;

// TODO: Auto-generated Javadoc
/**
 * Interface of transit service for business logic.
 *
 * @author Aman Dungarwal
 * @version 1.0
 */
public interface TransitService {

	/**
	 * Start trip.
	 *
	 * @param booking the booking
	 * @return the booking
	 */
	Booking startTrip(Booking booking);

	/**
	 * End trip.
	 *
	 * @param booking the booking
	 * @return the booking
	 */
	Booking endTrip(Booking booking);

	/**
	 * Update driver rating and status.
	 *
	 * @param booking the booking
	 * @return the driver
	 * @throws InvalidBookingException the invalid booking exception
	 */
	Driver updateDriverRating(Booking booking) throws InvalidBookingException;

	/**
	 * Update vehicle status.
	 *
	 * @param booking the booking
	 * @param driver  the driver
	 * @return the vehicle
	 * @throws InvalidBookingException the invalid booking exception
	 */
	Vehicle updateVehicleStatus(Booking booking, Driver driver) throws InvalidBookingException;

	/**
	 * Generate final fare.
	 *
	 * @param booking the booking
	 * @param vehicle the vehicle
	 * @return the double
	 * @throws InvalidBookingException the invalid booking exception
	 */
	double finalFareGeneration(Booking booking, Vehicle vehicle) throws InvalidBookingException;

	/**
	 * Rate trip.
	 *
	 * @param booking the booking
	 * @return the booking
	 * @throws InvalidBookingException the invalid booking exception
	 */
	Booking rateTrip(Booking booking) throws InvalidBookingException;

}
