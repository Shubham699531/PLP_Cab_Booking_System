package com.cg.cabbookingsystem.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.cabbookingsystem.dto.Booking;
import com.cg.cabbookingsystem.dto.Customer;
import com.cg.cabbookingsystem.dto.CustomerRequest;
import com.cg.cabbookingsystem.dto.Location;
import com.cg.cabbookingsystem.dto.Vehicle;
import com.cg.cabbookingsystem.exception.VehicleNotFoundException;
import com.cg.cabbookingsystem.repo.CustomerRepo;
import com.cg.cabbookingsystem.service.CustomerService;

/**
 * Rest Controller for the cab allocation microservice
 * @author Vishal
 *
 */
@RestController
@RequestMapping(value = "/customer")
//http://localhost:8082/customer
public class CustomerController {

	private CustomerService service;
	static Logger myLogger = Logger.getLogger(CustomerController.class);
	
	@Autowired
	public CustomerController(CustomerService service) {
		this.service = service;
	}
	
	/**
	 * List the vehicles that are within the 3KM radius of the customer pickup location
	 * @param CustomerRequest
	 * 			Contains source, destination and vehicle type as requested by the customer
	 * @return List<Vehicle>
	 * 			List of available vehicles that close to the pickup location 
	 * @throws VehicleNotFoundException 
	 */
	//http://localhost:8082/customer/nearByVehicle
	@PostMapping(value = "/nearByVehicle", consumes = "application/json", produces = "application/json")
	public List<Vehicle> getNearByVehicle(@RequestBody CustomerRequest req) throws VehicleNotFoundException{
		myLogger.info("Customer " + req.getCustomerId() + "requested a cab");
		return service.getNearByVehicles(req);
	}
	//http://localhost:8082/customer/nearByVehicle
		@GetMapping(value = "/getBookingForCustomer", consumes = "application/json", produces = "application/json")
		public Booking getBookingForCustomer(@RequestParam int customerId) {
			return service.getBookingForCustomer(customerId);
		}
	/**
	 * Get the booking details to the database
	 * @param Booking
	 * 			Contains the details to be saved to the database
	 * @return Booking
	 * 			
	 */
	//http://localhost:8082/customer/bookACab
	@PostMapping(value = "/bookACab", consumes = "application/json")
	public Booking bookACab(@RequestBody Booking booking) {
		Booking book = service.bookACab(booking);
		myLogger.info("Booking details entered with booking id: " + book.getBookingId());
		return book;
	}
	
	/**
	 * Fetches the list of past trips for a particular customer
	 * @param Customer
	 * 			Details of the customers who's past trips we need to retrieve
	 * @return List<Booking>
	 * 			List of past trips for a particular customer
	 */
	//http://localhost:8082/customer/pastTrips
	@PostMapping(value = "/pastTrips")
	public List<Booking> pastTrips(@RequestBody Customer customer){
		myLogger.info("Customer " + customer.getId() + "requested for past trips");
		return service.pastTrips(customer);
	}
	
	/**
	 * Estimate time taken for the trip based on customer request
	 */
	//http://localhost:8082/customer/estimateTime
	@PostMapping(value = "/estimateTime")
	public int estimateTime(@RequestBody CustomerRequest req) {
		myLogger.info("Customer " + req.getCustomerId() + "requested for estimate time");
		return service.estimateTime(req);
	}
	
//	@PostMapping(value = "/getLocation/{locationName}")
//	public Location getLocationByName(String locationName) {
//		return service.getLocationByName(locationName);
//	}
	
	@GetMapping(value = "/getRatedStatus")
	public Booking checkRatedStatus(@RequestParam int customerId) {
		return service.checkRatedStatus(customerId);
	}
}
