/**
 * 
 */
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
 * @author Aman Dungarwal
 * @version 1.0
 */

@Service
@Transactional(rollbackFor = InvalidBookingException.class)
public class TransitServiceImpl implements TransitService {

	@Autowired
	private BookingRepo bookingRepo;
	@Autowired
	private DriverRepo driverRepo;
	@Autowired
	private VehicleRepo vehicleRepo;
	@Autowired
	private PricingRepo priceRepo;

	@Override
	public Booking startTrip(Booking booking) {
		booking.setTripStatus("Started");
		return bookingRepo.save(booking);
	}

	@Override
	public Booking endTrip(Booking booking) {
		booking.setTripStatus("Completed");
		return bookingRepo.save(booking);
	}

	@Override
	public Booking rateTrip(Booking booking) throws InvalidBookingException {
		booking.setTripStatus("Rated");
		Driver driver = updateDriverRating(booking);
		Vehicle vehicle = updateVehicleStatus(booking, driver);
		double finalFare = finalFareGeneration(booking, vehicle);
		booking.setFinalFare(finalFare);
		return bookingRepo.save(booking);
	}

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
		numberOfTrips+=1;
		driver.setNumberOfTrips(numberOfTrips);
		double rating = driver.getRating();
		rating = rating + (booking.getRating() - rating) / numberOfTrips;
		rating = (rating < 0) ? 0 : rating;
		driver.setRating(rating);
		driver.setDriverStatus("Free");
		return driverRepo.saveAndFlush(driver);
	}

	@Override
	public Vehicle updateVehicleStatus(Booking booking, Driver driver) throws InvalidBookingException {
		String vehicleNo = driver.getVehicleNo();
		Optional<Vehicle> optionalVehicle = vehicleRepo.findById(vehicleNo);
		Vehicle vehicle = null;

		if (optionalVehicle.isPresent())
			vehicle = optionalVehicle.get();
		else
			throw new InvalidBookingException("Vehicle not found for vehicle number " + vehicleNo);

		vehicle.setLocation(booking.getDestination());
		vehicle.setStatus("Free");
		return vehicleRepo.saveAndFlush(vehicle);
	}

	@Override
	public double finalFareGeneration(Booking booking, Vehicle vehicle) throws InvalidBookingException {
		Optional<Pricing> optionalPrice = priceRepo.findById(vehicle.getCategoryId());

		Pricing price;
		if (optionalPrice.isPresent())
			price = optionalPrice.get();
		else
			throw new InvalidBookingException("Invalid vehicle size");
		double extraFare = price.getWaitingChargePerMin() * (booking.getFinalTime() - booking.getEstimatedTime());
		extraFare = (extraFare < 0) ? 0 : extraFare;
		return booking.getEstimatedFare() + extraFare;
	}

	@Override
	public Booking getBooking() {
		return bookingRepo.findById(124).get();
	}
}
