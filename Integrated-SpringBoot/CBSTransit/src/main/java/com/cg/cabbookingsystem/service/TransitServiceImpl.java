package com.cg.cabbookingsystem.service;

import java.util.Optional;

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

	/**
	 * Start the trip.
	 *
	 * @param booking the booking
	 * @return the booking
	 */
	@Override
	public Booking startTrip(Booking booking) {
		booking.setTripStatus("Started");
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
		Driver driver = updateDriverRating(booking);
		Vehicle vehicle = updateVehicleStatus(booking, driver);
		double finalFare = finalFareGeneration(booking, vehicle);
		booking.setFinalFare(finalFare);
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

		if (optionalDriver.isPresent())
			driver = optionalDriver.get();
		else
			throw new InvalidBookingException("No Driver with id " + driverId);

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

		if (optionalVehicle.isPresent())
			vehicle = optionalVehicle.get();
		else
			throw new InvalidBookingException("Vehicle not found for vehicle number " + vehicleNo);

		// Set the final location of the vehicle to destination of booking
		vehicle.setLocation(booking.getDestination());

		// Set the vehicle status to free
		vehicle.setStatus("Free");
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
		if (optionalPrice.isPresent())
			price = optionalPrice.get();
		else
			throw new InvalidBookingException("Invalid vehicle size");

		// Use estimated fare and difference in estimated and final time to calculate
		// dynamic final fare.
		double extraFare = price.getWaitingChargePerMin() * (booking.getFinalTime() - booking.getEstimatedTime());

		// Avoiding reduction in estimated fare.
		extraFare = (extraFare < 0) ? 0 : extraFare;
		return booking.getEstimatedFare() + extraFare;
	}

}
