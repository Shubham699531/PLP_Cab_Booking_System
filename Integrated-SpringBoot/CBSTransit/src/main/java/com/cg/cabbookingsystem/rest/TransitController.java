package com.cg.cabbookingsystem.rest;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.cabbookingsystem.dto.Booking;
import com.cg.cabbookingsystem.exception.InvalidBookingException;
import com.cg.cabbookingsystem.service.TransitService;

/**
 * Transit controller class for web requests
 * 
 * @author Aman Dungarwal
 * @version 1.0
 */
@RestController
@RequestMapping("/transit")
public class TransitController {

	/** The transit service. */
	@Autowired
	private TransitService transitService;

	/**
	 * Start trip.
	 *
	 * @param booking the booking
	 * @return the booking
	 */
	// http://localhost:8810/transit/startTrip
	@PostMapping(value = "/startTrip", consumes = "application/json", produces = "application/json")
	public Booking startTrip(@Valid @RequestBody Booking booking) {
		return transitService.startTrip(booking);
	}

	/**
	 * End trip.
	 *
	 * @param booking the booking
	 * @return the booking
	 */
	// http://localhost:8810/transit/endTrip
	@PostMapping(value = "/endTrip", consumes = "application/json", produces = "application/json")
	public Booking endTrip(@Valid @RequestBody Booking booking) {
		return transitService.endTrip(booking);
	}

	/**
	 * Rate trip.
	 *
	 * @param booking the booking
	 * @return the booking
	 * @throws InvalidBookingException the invalid booking exception
	 */
	// http://localhost:8810/transit/rateTrip
	@PostMapping(value = "/rateTrip", consumes = "application/json", produces = "application/json")
	public Booking rateTrip(@Valid @RequestBody Booking booking) throws InvalidBookingException {
		return transitService.rateTrip(booking);
	}

}
