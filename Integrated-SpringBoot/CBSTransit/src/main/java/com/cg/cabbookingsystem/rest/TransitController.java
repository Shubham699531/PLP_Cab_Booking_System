package com.cg.cabbookingsystem.rest;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.cabbookingsystem.dto.Booking;
import com.cg.cabbookingsystem.dto.Driver;
import com.cg.cabbookingsystem.exception.InvalidBookingException;
import com.cg.cabbookingsystem.service.TransitService;


@RestController
@RequestMapping("/transit")
public class TransitController {

	@Autowired
	private TransitService transitService;

	@PostMapping(value = "/startTrip", consumes = "application/json", produces = "application/json")
	public Booking startTrip(@Valid @RequestBody Booking booking) {
		return transitService.startTrip(booking);
	}
	
	@PostMapping(value = "/endTrip", consumes = "application/json", produces = "application/json")
	public Booking endTrip(@Valid @RequestBody Booking booking){
		return transitService.endTrip(booking);
	}
	
	@PostMapping(value = "/rateTrip", consumes = "application/json", produces = "application/json")
	public Booking rateTrip(@Valid @RequestBody Booking booking) throws InvalidBookingException {
		return transitService.rateTrip(booking);
	}
	
	@GetMapping(value = "/book", produces = "application/json")
	public Booking dummyBooking(){
//		return new Booking(123, "andheri", "marol", "Confirmed", 200, 0, 10, 1000, 12, 0, 0);
		return transitService.getBooking();
	}
	
//	@GetMapping(value = "/driver/{id}", produces = "application/json")
//	public Driver getdriver(@PathVariable int id) {
////		Price booking = new Price(1,10,3);
////		Vehicle booking1 = new Vehicle("MH12",1,"Honda","Busy","andheri");
//		return new Driver(id, "rahul", new Date(), "male", 9876543210L, "asalpha", "MH12", 4.82, 12);
//	}
}
