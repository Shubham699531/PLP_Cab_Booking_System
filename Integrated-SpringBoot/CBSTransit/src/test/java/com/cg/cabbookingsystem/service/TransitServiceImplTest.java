/**
 * 
 */
package com.cg.cabbookingsystem.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.cg.cabbookingsystem.dto.Booking;
import com.cg.cabbookingsystem.dto.Driver;
import com.cg.cabbookingsystem.dto.Vehicle;
import com.cg.cabbookingsystem.exception.InvalidBookingException;

/**
 * @author Aman Dungarwal
 * @version 1.0
 */
public class TransitServiceImplTest {

	@Autowired
	TransitService transitService;

	/**
	 * Change the status to "Started". Test method for
	 * {@link com.cg.cabbookingsystem.service.TransitServiceImpl#startTrip(com.cg.cabbookingsystem.dto.Booking)}.
	 */
	@Test
	public void testStartTrip() {
		Booking booking = new Booking(124, "andheri", "sakinaka", "Confirmed", 100, 0, 10, "Booked", 20, 10, 12, 5,
				"issues");
		booking = transitService.startTrip(booking);
		assertEquals("Started", booking.getTripStatus());
	}

	/**
	 * Change the status to "Completed". Test method for
	 * {@link com.cg.cabbookingsystem.service.TransitServiceImpl#endTrip(com.cg.cabbookingsystem.dto.Booking)}.
	 */
	@Test
	public void testEndTrip() {
		Booking booking = new Booking(124, "andheri", "sakinaka", "Started", 100, 0, 10, "Booked", 20, 10, 12, 4,
				"issues");
		booking = transitService.endTrip(booking);
		assertEquals("Completed", booking.getTripStatus());
	}

	/**
	 * For valid booking the test will change the trip status to "Rated". Test
	 * method for
	 * {@link com.cg.cabbookingsystem.service.TransitServiceImpl#rateTrip(com.cg.cabbookingsystem.dto.Booking)}.
	 * Existing driver, vehicle and pricing entries required for the corresponding
	 * booking.
	 * 
	 * @throws InvalidBookingException
	 */
	@Test
	public void testRateTrip() throws InvalidBookingException {
		Booking booking = new Booking(124, "andheri", "sakinaka", "Completed", 100, 0, 10, "Booked", 20, 10, 12, 4,
				"issues");

		booking = transitService.rateTrip(booking);
		assertEquals("Rated", booking.getTripStatus());
	}

	/**
	 * Driver object will be returned with updated details. Test method for
	 * {@link com.cg.cabbookingsystem.service.TransitServiceImpl#updateDriverRating(com.cg.cabbookingsystem.dto.Booking)}.
	 * Valid driver entry must be present.
	 * 
	 * @throws InvalidBookingException the invalid booking exception
	 */
	@Test
	public void testUpdateDriverRating() throws InvalidBookingException {
		Booking booking = new Booking(124, "andheri", "sakinaka", "Completed", 100, 0, 10, "Booked", 20, 10, 12, 5,
				"issues");
		Driver driver = transitService.updateDriverRating(booking);
		assertNotNull(driver);
	}

	/**
	 * Exception will be thrown as driver with give id is not present. Test method
	 * for
	 * {@link com.cg.cabbookingsystem.service.TransitServiceImpl#updateDriverRating(com.cg.cabbookingsystem.dto.Booking)}.
	 * 
	 * @throws InvalidBookingException the invalid booking exception
	 */
	@Test(expected = InvalidBookingException.class)
	public void testUpdateDriverRatingException() throws InvalidBookingException {
		Booking booking = new Booking(124, "andheri", "sakinaka", "Completed", 100, 0, 10, "Booked", 20, 10, 12, 5,
				"issues");
		Driver driver = transitService.updateDriverRating(booking);
		assertNotNull(driver);
	}

	/**
	 * UPdate vehicle details. Test method for
	 * {@link com.cg.cabbookingsystem.service.TransitServiceImpl#updateVehicleStatus(com.cg.cabbookingsystem.dto.Booking, com.cg.cabbookingsystem.dto.Driver)}.
	 * 
	 * @throws InvalidBookingException
	 */
	@Test
	public void testUpdateVehicleStatus() throws InvalidBookingException {
		Booking booking = new Booking(124, "andheri", "sakinaka", "Completed", 100, 0, 10, "Booked", 20, 10, 12, 5,
				"issues");
		Driver driver = transitService.updateDriverRating(booking);
		Vehicle vehicle = transitService.updateVehicleStatus(booking, driver);
		assertNotNull(vehicle);
	}

	/**
	 * Change the vehicle location. Test method for
	 * {@link com.cg.cabbookingsystem.service.TransitServiceImpl#updateVehicleStatus(com.cg.cabbookingsystem.dto.Booking, com.cg.cabbookingsystem.dto.Driver)}.
	 * 
	 * @throws InvalidBookingException
	 */
	@Test
	public void testUpdateVehicleLocation() throws InvalidBookingException {
		Booking booking = new Booking(124, "andheri", "sakinaka", "Completed", 100, 0, 10, "Booked", 20, 10, 12, 5,
				"issues");
		Driver driver = transitService.updateDriverRating(booking);
		Vehicle vehicle = transitService.updateVehicleStatus(booking, driver);
		assertEquals("sakinaka", vehicle.getLocation());
	}

	/**
	 * Throws exception due to invalid vehicle Id. Test method for
	 * {@link com.cg.cabbookingsystem.service.TransitServiceImpl#updateVehicleStatus(com.cg.cabbookingsystem.dto.Booking, com.cg.cabbookingsystem.dto.Driver)}.
	 * Vehicle Id should not exist in the table.
	 * 
	 * @throws InvalidBookingException
	 */
	@Test(expected = InvalidBookingException.class)
	public void testUpdateVehicleStatusException() throws InvalidBookingException {
		Booking booking = new Booking(124, "andheri", "sakinaka", "Completed", 100, 0, 10, "Booked", 20, 11, 12, 5,
				"issues");
		Driver driver = transitService.updateDriverRating(booking);
		Vehicle vehicle = transitService.updateVehicleStatus(booking, driver);
		assertNotNull(vehicle);
	}

	/**
	 * final fare with waiting charge = 5Rs per minute. Test method for
	 * {@link com.cg.cabbookingsystem.service.TransitServiceImpl#finalFareGeneration(com.cg.cabbookingsystem.dto.Booking, com.cg.cabbookingsystem.dto.Vehicle)}.
	 * 
	 * @throws InvalidBookingException
	 */
	@Test
	public void testFinalFareGeneration() throws InvalidBookingException {
		Booking booking = new Booking(124, "andheri", "sakinaka", "Completed", 100, 0, 10, "Booked", 20, 10, 12, 5,
				"issues");
		Driver driver = transitService.updateDriverRating(booking);
		Vehicle vehicle = transitService.updateVehicleStatus(booking, driver);
		double finalFare = transitService.finalFareGeneration(booking, vehicle);
		assertEquals(110.0, finalFare, 0.5);
	}
}
