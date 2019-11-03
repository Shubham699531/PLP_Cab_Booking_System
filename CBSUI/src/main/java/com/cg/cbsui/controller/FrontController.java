package com.cg.cbsui.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cg.cbsui.dto.Booking;
import com.cg.cbsui.dto.CustomerRequirement;
import com.cg.cbsui.dto.User;
import com.cg.cbsui.dto.Vehicle;

@RestController
@RequestMapping(value = "/cbs")
//http://localhost:8180/cbs
public class FrontController {

	RestTemplate restTemplate;
	@Autowired
	public FrontController(RestTemplate template) {
		this.restTemplate = template;
	}
	
	@PostMapping(value = "/bookingService", consumes = "application/json", produces = "application/json")
	Object booking(@RequestBody User user) {
		int userId = restTemplate.postForObject("http://localhost:8079/login", user, Integer.class);
		if(userId>0) {
			System.out.println("_____Welcome customer "+userId);
			CustomerRequirement req = new CustomerRequirement(userId,"Thane","Borivali",4);
			Vehicle[] nearByVehicles = restTemplate.postForObject("http://localhost:8082/customer/nearByVehicle", req, Vehicle[].class);
			int driverId = 1;//choose a dirver/vehicle
			for (Vehicle vehicle : nearByVehicles) {
				System.out.println(vehicle.toString());
			}
			Booking bookingdetails = new Booking();
			bookingdetails.setCustomerId(userId);
			bookingdetails.setCustomerStatus("confirmed");
			bookingdetails.setDestination(req.getDestination());
			bookingdetails.setDriverId(driverId);
			bookingdetails.setDriverStatus("confirmed");
			bookingdetails.setVehicleSize(4);
			bookingdetails.setSource(req.getSource());
			Booking booking = restTemplate.postForObject("http://localhost:8082/customer/bookACab", bookingdetails, Booking.class);
			//bookingdetails.setBookingId((int) bookingId);
			return booking;
		}
		else {
			System.out.println("Invalid credentials");
			CustomerRequirement req = new CustomerRequirement(userId,"Thane","Kanjurmarg",6);
			Vehicle[] nearByVehicles = restTemplate.getForObject("http://localhost:8082/customer/nearByVehicle", Vehicle[].class, req);
			return nearByVehicles;
		}
	}
}
