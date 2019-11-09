package com.cg.cabbookingsystem.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.cabbookingsystem.dto.Booking;
import com.cg.cabbookingsystem.dto.Customer;
import com.cg.cabbookingsystem.dto.Driver;
import com.cg.cabbookingsystem.dto.Vehicle;
import com.cg.cabbookingsystem.service.DriverService;
/**
 * Rest Controller for managing requests from the client
 * @author Shubham
 * @version 1.0
 *
 */
@Transactional
@RestController
@RequestMapping(value = "/driver")
public class DriverController {
	
	private DriverService service;
	
	@Autowired
	public DriverController(DriverService service) {
		this.service = service;
	}
	
	/**
	 * Find a suitable driver for the customer from the list of available 
	 *  cabs
	 * @param vehicles
	 * 	List of vehicles coming from customer side which
	 * 	contains information of the vehicles that are nearby and free
	 * @return the selected driver who is assigned for the
	 * coming customer request
	 */
	@PostMapping(value = "/selectOneDriver")
	public Driver selectOneDriver(@RequestBody List<Vehicle> vehicles){
		return service.getOneDriver(vehicles);
	}
	
	/**
	 * Searches for a current Booking for the driver who is logged in
	 * @param driverId
	 * id of the driver who is logged in
	 * @return
	 * customer details who is alloted to the logged in driver
	 */
	@GetMapping(value = "/getCustomerFromBooking")
	public Customer searchForBooking(@RequestParam int driverId) {
		return service.searchForBooking(driverId);
	}
	
	/**
	 * Shows a list of past rides of the logged in driver
	 * @param driverId
	 * 	id of the driver who is logged in
	 * @return
	 * list of past rides along with source, destination and fare
	 */
	@GetMapping(value = "/history")
	public List<Booking> getHistoryOfDriver(@RequestParam int driverId){
		return service.getAllTripsOfADriver(driverId);
	}
	
	/**
	 * Gets a driver by email id
	 * @param email
	 * email Id of the driver to be searched
	 * @return
	 * driver with the entered email id
	 */
	@GetMapping(value = "/fetch")
	public Driver fetchDriver(@RequestParam String email) {
		return service.fetchByEmail(email);
	}
	
	@GetMapping(value = "/getBooking")
	public Booking getBookingForADriver(@RequestParam int driverId){
		return service.getBookingDetailsForADriver(driverId);
	} 

}
