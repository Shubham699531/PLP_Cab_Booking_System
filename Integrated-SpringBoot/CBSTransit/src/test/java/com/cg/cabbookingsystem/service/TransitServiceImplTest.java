/**
 * 
 */
package com.cg.cabbookingsystem.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.cabbookingsystem.dto.Booking;
import com.cg.cabbookingsystem.dto.Driver;
import com.cg.cabbookingsystem.dto.Vehicle;
import com.cg.cabbookingsystem.exception.InvalidBookingException;
import com.cg.cabbookingsystem.repo.BookingRepo;

/**
 * @author Aman Dungarwal
 * @version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TransitServiceImplTest {

	@Autowired
	TransitService transitService;

	@Autowired
	BookingRepo repo;
	
	@Test
	public void testStartTrip() {
		Booking booking = new Booking(124,"andheri","sakinaka","Started",100,100,10,"Booked",20,15,17,4,"issues");
	repo.save(booking);
	}
//	
//	/**
//	 * Test method for
//	 * {@link com.cg.cabbookingsystem.service.TransitServiceImpl#startTrip(com.cg.cabbookingsystem.dto.Booking)}.
//	 */
//	@Test
//	public void testStartTrip() {
//		Booking booking = new Booking();
//		booking = transitService.startTrip(booking);
//		assertEquals("Started", booking.getTripStatus());
//	}

	/**
	 * Test method for
	 * {@link com.cg.cabbookingsystem.service.TransitServiceImpl#endTrip(com.cg.cabbookingsystem.dto.Booking)}.
	 * 
	 * @throws InvalidBookingException
	 */
	@Test
	public void testEndTrip() throws InvalidBookingException {
		Booking booking = new Booking();
		booking = transitService.endTrip(booking);
		assertEquals("Completed", booking.getTripStatus());
	}
	
	/**
	 * Test method for
	 * {@link com.cg.cabbookingsystem.service.TransitServiceImpl#rateTrip(com.cg.cabbookingsystem.dto.Booking)}.
	 * 
	 * @throws InvalidBookingException
	 */
	@Test
	public void testRateTripStatus() throws InvalidBookingException {
		Booking booking = new Booking();
		booking = transitService.endTrip(booking);
		assertEquals("Rated", booking.getTripStatus());
	}
	
	/**
	 * Test method for
	 * {@link com.cg.cabbookingsystem.service.TransitServiceImpl#rateTrip(com.cg.cabbookingsystem.dto.Booking)}.
	 * 
	 * @throws InvalidBookingException
	 */
//	@Test
//	public void testRateTrip() throws InvalidBookingException {
//		Booking booking = new Booking(124,"andheri","sakinaka","Completed",200,0,10,1000,15,20,5);
////		"bookingId": 124,
////	    "source": "andheri",
////	    "destination": "sakinaka",
////	    "tripStatus": "Completed",
////	    "estimatedFare": 200.0,
////	    "finalFare": 0.0,
////	    "driverId": 10,
////	    "customerId": 1000,
////	    "estimatedTime": 15,
////	    "finalTime": 20,
////	    "rating": 5
//		booking = transitService.endTrip(booking);
//		Booking expectedBooking = new Booking(124,"andheri","sakinaka","Rated",200,250,10,1000,15,20,5);
//		assertEquals(expectedBooking, booking);
//	}
	
	/**
	 * Test method for
	 * {@link com.cg.cabbookingsystem.service.TransitServiceImpl#rndTrip(com.cg.cabbookingsystem.dto.Booking)}.
	 * 
	 * @throws InvalidBookingException
	 */
	@Test(expected = InvalidBookingException.class)
	public void testRateTripNegative() throws InvalidBookingException {
		Booking booking = new Booking();
		booking = transitService.endTrip(booking);
		Booking expectedBooking = new Booking();
		assertEquals(expectedBooking, booking);
	}

	/**
	 * Test method for
	 * {@link com.cg.cabbookingsystem.service.TransitServiceImpl#updateDriverRating(com.cg.cabbookingsystem.dto.Booking)}.
	 * 
	 * @throws InvalidBookingException
	 */
	@Test
	public void testUpdateDriverRating() throws InvalidBookingException {
		Booking booking = new Booking();
		Driver driver = transitService.updateDriverRating(booking);
		assertEquals(5.0, driver.getRating(), 0);
	}

	/**
	 * Test method for
	 * {@link com.cg.cabbookingsystem.service.TransitServiceImpl#updateDriverRating(com.cg.cabbookingsystem.dto.Booking)}.
	 * 
	 * @throws InvalidBookingException
	 */
	@Test(expected = InvalidBookingException.class)
	public void testUpdateDriverRatingNegative() throws InvalidBookingException {
		Booking booking = new Booking();
		System.out.println(transitService);
		Driver driver = transitService.updateDriverRating(booking);
		assertEquals(5.0, driver.getRating(), 0);
	}

	/**
	 * Test method for
	 * {@link com.cg.cabbookingsystem.service.TransitServiceImpl#updateVehicleStatus(com.cg.cabbookingsystem.dto.Booking, com.cg.cabbookingsystem.dto.Driver)}.
	 * 
	 * @throws InvalidBookingException
	 */
	@Test
	public void testUpdateVehicleStatus() throws InvalidBookingException {
		Booking booking = new Booking();
		Driver driver = new Driver();
		Vehicle vehicle = transitService.updateVehicleStatus(booking, driver);
	}

	/**
	 * Test method for
	 * {@link com.cg.cabbookingsystem.service.TransitServiceImpl#finalFareGeneration(com.cg.cabbookingsystem.dto.Booking, com.cg.cabbookingsystem.dto.Vehicle)}.
	 * 
	 * @throws InvalidBookingException
	 */
	@Test
	public void testFinalFareGeneration() throws InvalidBookingException {
		Booking booking = new Booking();
		Vehicle vehicle = new Vehicle();
		double finalFare = transitService.finalFareGeneration(booking, vehicle);
	}

}
