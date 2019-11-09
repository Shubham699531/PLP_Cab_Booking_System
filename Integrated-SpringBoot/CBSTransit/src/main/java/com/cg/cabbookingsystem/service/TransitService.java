package com.cg.cabbookingsystem.service;

import com.cg.cabbookingsystem.dto.Booking;
import com.cg.cabbookingsystem.dto.Driver;
import com.cg.cabbookingsystem.dto.Vehicle;
import com.cg.cabbookingsystem.exception.InvalidBookingException;

public interface TransitService {

	Booking startTrip(Booking booking);

	Booking endTrip(Booking booking);

	Driver updateDriverRating(Booking booking) throws InvalidBookingException;

	Vehicle updateVehicleStatus(Booking booking, Driver driver) throws InvalidBookingException;

	double finalFareGeneration(Booking booking, Vehicle vehicle) throws InvalidBookingException;

	Booking getBooking();

	Booking rateTrip(Booking booking) throws InvalidBookingException;

}
