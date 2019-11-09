package com.cg.cabbookingsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.cabbookingsystem.dto.Booking;
import com.cg.cabbookingsystem.dto.Driver;
import com.cg.cabbookingsystem.dto.Report;
import com.cg.cabbookingsystem.exception.DriverNotFoundException;
import com.cg.cabbookingsystem.service.CabBookingService;

/**
 * This is the controller class for handling requests.
 * @author Vineeta
 * @version 1.0
 *
 */

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/cab")
public class CabBokingController {
	
	@Autowired
	private CabBookingService service;
	
	/**
	 * save the driver details after the registration on application page in database
	 * @return
	 * driver details with driver id
	 */
	@PostMapping(value = "/save/driver", consumes = "application/json")
	public Driver saveDriver(@RequestBody Driver driver) {
		return service.saveDriver(driver);
	}
	
	/**
	 * Shows a list of driver details of the driver after registration on the application	
	 * @return
	 * list of driver details 
	 */
	@GetMapping(value = "/driver", produces = "application/json")
	public List<Driver> getAllDriver(){
		return service.getAllDriver();
	}
	
	/**
	 * finds a driver by id
	 * @param id
	 * Id of the driver to be searched
	 * @return
	 * driver for the given id
	 */
	@GetMapping(value = "/driver/{id}", produces = "application/json")
	public Driver findDriver(@PathVariable int id) throws DriverNotFoundException {
		return service.findDriver(id);
	}
	
	/**
	 * delete a driver by id from the database
	 * @param id
	 *    driver details will be deleted for the given id
	 * 
	 */
	@DeleteMapping(value = "/remove/{id}", produces = "application/json")
	public boolean deleteDriver(@PathVariable int id) throws DriverNotFoundException {
		return service.deleteDriver(id);
	}
	
	/**
	 * update the driver details if id exists and save if not in database
	 * @return
	 * store driver details 
	 */
	@PutMapping(value = "/update", consumes = "application/json", 
			produces = "application/json")
	public Driver updateDriver(@RequestBody Driver driver ) {
	
		return service.updateDriver(driver);
	}
	
	/**
	 * Shows a list of issues raised by customers
	 * @return
	 * list of customer issues detail 	
	 */
	@GetMapping( value = "/report", produces = "application/json")
	public List<Report> getAllReport(){
		return service.getAllReport();
	}
	
	/**
	 * save the issues details raised by customer in database
	 * @return
	 *   store report details in database 
	 */
	@PostMapping(value = "/save/report", consumes = "application/json")
	public Report saveReport(@RequestBody Report report) {
		return service.saveReport(report);
	}
	
	/**
	 * save the booking details in database
	 * @return
	 * booking details with booking id
	 */
	@PostMapping(value = "/save/booking", consumes = "application/json")
	public Booking saveBooking(@RequestBody Booking booking) {
		return service.saveBooking(booking);
	}
	
	/**
	 * Shows a list of booking details of the driver after booking
	 * @return
	 * list of booking details 
	 */
	@GetMapping( value = "/booking", produces = "application/json")
	public List<Booking> getAllBooking(){
		return service.getBookingDetails();
	}
}
