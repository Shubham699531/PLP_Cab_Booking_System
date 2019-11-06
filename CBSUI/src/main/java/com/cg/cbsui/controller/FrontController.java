package com.cg.cbsui.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cg.cbsui.dto.Booking;
import com.cg.cbsui.dto.Customer;
import com.cg.cbsui.dto.CustomerRequest;
import com.cg.cbsui.dto.Driver;
import com.cg.cbsui.dto.DriverSignupDetails;
import com.cg.cbsui.dto.Location;
import com.cg.cbsui.dto.User;
import com.cg.cbsui.dto.Vehicle;
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/cbs")
//http://localhost:8180/cbs
public class FrontController {

	RestTemplate restTemplate;
	@Autowired
	public FrontController(RestTemplate template) {
		this.restTemplate = template;
	}
	//http://localhost:8180/cbs/login
	@PostMapping(value = "/loginCustomer", consumes = "application/json"
			,produces = "application/json")
	Customer loginCustomer(@RequestBody User user) {
		Customer cust = restTemplate.postForObject("http://localhost:8079/login/loginCustomer", user, Customer.class); 
		return cust;
	}
	
	@PostMapping(value = "/loginDriver", consumes = "application/json",produces = "application/json")
	Driver loginDriver(@RequestBody User user) {
		Driver driver = restTemplate.postForObject("http://localhost:8079/loginDriver", user, Driver.class);
		return driver;
	}
	
	@PostMapping(value="/signupCustomer", consumes = "application/json",produces = "application/json")
	Customer signupCustomer(@RequestBody Customer customer) {
		System.out.println("*****" + customer.getEmail());
		return restTemplate.postForObject("http://localhost:8079/signupCustomer", customer, Customer.class);
	}
	
	@PostMapping(value = "/signupDriver", consumes = "application/json",produces = "application/json")
	DriverSignupDetails signupDriver(@RequestBody DriverSignupDetails driverSignup) {
		return restTemplate.postForObject("http://localhost:8079/signupDriver", driverSignup, DriverSignupDetails.class);
	}
	@PostMapping(value = "/findACab", consumes = "application/json",
			produces = "application/json")
	Booking booking(@RequestBody CustomerRequest req) {
			Vehicle[] nearByVehicles = restTemplate.postForObject("http://localhost:8082/customer/nearByVehicle", req, Vehicle[].class);
			
			for (Vehicle vehicle : nearByVehicles) {
				System.out.println(vehicle.toString());
			}
			
			//{TO_DO}Select a driver from driver module
			int driverId = 10 + req.getCustomerId();//choose a dirver/vehicle
			Booking bookingdetails = new Booking();
			bookingdetails.setCustomerId(req.getCustomerId());
			bookingdetails.setCustomerStatus("confirmed");
			bookingdetails.setDestination(req.getDestination());
			bookingdetails.setDriverId(driverId);
			bookingdetails.setDriverStatus("confirmed");
			bookingdetails.setVehicleSize(4);
			bookingdetails.setSource(req.getSource());
			Booking booking = restTemplate.postForObject("http://localhost:8082/customer/bookACab", bookingdetails, Booking.class);
			//{TO_DO} send booking details to the driver
			return booking;
		
	}
	
	@PostMapping(value = "/saveCustomerRequest",consumes = "application/json",produces = "application/json")
	public CustomerRequest saveCustomerRequest(@RequestBody CustomerRequest request) {
		return restTemplate.postForObject("http://localhost:8001/tripdetails/add", request, CustomerRequest.class);
	}
	
	@PostMapping(value = "/estimateFare")
	public double estimateFare(@RequestBody CustomerRequest request) {
		return restTemplate.postForObject("http://localhost:8001/tripdetails/estimatePrice", request, Double.class);
	}
	
	@GetMapping(value = "/allLocations")
	public String[] getAllLocations(){
		return restTemplate.getForObject("http://localhost:8001/tripdetails/allLocations", String[].class);
	}
	
	//http://localhost:8180/cbs/pastTrips
	@PostMapping(value = "/pastTrips")
	public Booking[] pastTrips(@RequestBody Customer customer) {
		return restTemplate.postForObject("http://localhost:8082/customer/pastTrips", customer,Booking[].class);
	}
}
