package com.cg.cabbookingsystem.service;

import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.cabbookingsystem.dto.Booking;
import com.cg.cabbookingsystem.dto.Driver;
import com.cg.cabbookingsystem.dto.Pricing;
import com.cg.cabbookingsystem.dto.Vehicle;
import com.cg.cabbookingsystem.exception.InvalidBookingException;
import com.cg.cabbookingsystem.repo.BookingRepo;
import com.cg.cabbookingsystem.repo.DriverRepo;
import com.cg.cabbookingsystem.repo.PricingRepo;
import com.cg.cabbookingsystem.repo.VehicleRepo;

/**
 * Implementation of transit service interface for business logic layer.
 *
 * @author Aman Dungarwal
 * @version 1.0
 */

@Service
@Transactional(rollbackFor = InvalidBookingException.class)
public class TransitServiceImpl implements TransitService {

	/** The booking repository. */
	@Autowired
	private BookingRepo bookingRepo;

	/** The driver repository. */
	@Autowired
	private DriverRepo driverRepo;

	/** The vehicle repository. */
	@Autowired
	private VehicleRepo vehicleRepo;

	/** The price repository. */
	@Autowired
	private PricingRepo priceRepo;

	static Logger myLogger = Logger.getLogger(TransitServiceImpl.class.getName());

	/**
	 * Start the trip.
	 *
	 * @param booking the booking
	 * @return the booking
	 */
	@Override
	public Booking startTrip(Booking booking) {
		booking.setTripStatus("Started");
		myLogger.info("Trip Started");
		return bookingRepo.save(booking);
	}

	/**
	 * End the trip.
	 *
	 * @param booking the booking
	 * @return the booking
	 */
	@Override
	public Booking endTrip(Booking booking) {
		booking.setTripStatus("Completed");
		myLogger.info("Trip Ended");
		return bookingRepo.save(booking);
	}

	/**
	 * Rate the trip.
	 *
	 * @param booking the booking
	 * @return the booking
	 * @throws InvalidBookingException the invalid booking exception
	 */
	@Override
	public Booking rateTrip(Booking booking) throws InvalidBookingException {
		booking.setTripStatus("Rated");
		myLogger.info("Trip Status changed to rated");
		Driver driver = updateDriverRating(booking);
		Vehicle vehicle = updateVehicleStatus(booking, driver);
		double finalFare = finalFareGeneration(booking, vehicle);
		booking.setFinalFare(finalFare);
		myLogger.info("Trip Rated");
		return bookingRepo.save(booking);
	}

	/**
	 * Update driver rating and status.
	 *
	 * @param booking the booking
	 * @return the driver
	 * @throws InvalidBookingException the invalid booking exception
	 */
	@Override
	public Driver updateDriverRating(Booking booking) throws InvalidBookingException {
		int driverId = booking.getDriverId();
		Optional<Driver> optionalDriver = driverRepo.findById(driverId);
		Driver driver = null;

		if (optionalDriver.isPresent()) {
			myLogger.info("Driver with driverId " + driverId + " found");
			driver = optionalDriver.get();
		} else {
			myLogger.error("Driver with driverId " + driverId + " not found");
			throw new InvalidBookingException("No Driver with id " + driverId);
		}

		int numberOfTrips = driver.getNumberOfTrips();
		numberOfTrips += 1;
		driver.setNumberOfTrips(numberOfTrips);

		// Generate average rating for driver
		double rating = driver.getRating();
		rating = rating + (booking.getRating() - rating) / numberOfTrips;
		// Minimum rating = 0
		rating = (rating < 0) ? 0 : rating;
		driver.setRating(rating);

		// Set status to free for the driver
		driver.setDriverStatus("Free");
		myLogger.info("Driver Rating and status updated");


		return driverRepo.saveAndFlush(driver);
	}

	/**
	 * Update vehicle status.
	 *
	 * @param booking the booking
	 * @param driver  the driver
	 * @return the vehicle
	 * @throws InvalidBookingException the invalid booking exception
	 */
	@Override
	public Vehicle updateVehicleStatus(Booking booking, Driver driver) throws InvalidBookingException {
		String vehicleNo = driver.getVehicleNo();
		Optional<Vehicle> optionalVehicle = vehicleRepo.findById(vehicleNo);
		Vehicle vehicle = null;

		if (optionalVehicle.isPresent()) {
			myLogger.info("Vehicle with vehicle no. " + vehicleNo + " found");
			vehicle = optionalVehicle.get();
		} else {
			myLogger.error("Vehicle with vehicle no. " + vehicleNo + " not found");
			throw new InvalidBookingException("Vehicle not found for vehicle number " + vehicleNo);
		}
		// Set the final location of the vehicle to destination of booking
		vehicle.setLocation(booking.getDestination());

		// Set the vehicle status to free
		vehicle.setStatus("Free");
		myLogger.info("Vehicle status and location updated");
		return vehicleRepo.saveAndFlush(vehicle);
	}

	/**
	 * Final fare generation.
	 *
	 * @param booking the booking
	 * @param vehicle the vehicle
	 * @return the double
	 * @throws InvalidBookingException the invalid booking exception
	 */
	@Override
	public double finalFareGeneration(Booking booking, Vehicle vehicle) throws InvalidBookingException {
		Optional<Pricing> optionalPrice = priceRepo.findById(vehicle.getCategoryId());

		Pricing price;
		if (optionalPrice.isPresent()) {
			myLogger.info("Pricing for category Id " + vehicle.getCategoryId() + " found");
			price = optionalPrice.get();
		} else {
			myLogger.error("Pricing for category Id " + vehicle.getCategoryId() + " not found");
			throw new InvalidBookingException("Invalid vehicle size");
		}
		// Use estimated fare and difference in estimated and final time to calculate
		// dynamic final fare.
		double extraFare = price.getWaitingChargePerMin() * (booking.getFinalTime() - booking.getEstimatedTime());

		// Avoiding reduction in estimated fare.
		extraFare = (extraFare < 0) ? 0 : extraFare;
		return booking.getEstimatedFare() + extraFare;
	}

}
