package com.cg.cbs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.cbs.dto.CustomerRequest;
import com.cg.cbs.service.TripService;

/**
 * Rest controller class for delegating http calss to eifferent methods.
 * @author Akash
 *
 */
//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/tripdetails")
//http://localhost:8001/tripdetails
public class TripController {

	@Autowired
	TripService service;
	
	/**
	 * Post mapping for saving the trip details which is sent.
	 * @param details
	 * @return
	 */
	@PostMapping(value = "/add")
	public CustomerRequest addCustomerRequest(@RequestBody CustomerRequest details) {
		return service.saveCustomerRequest(details);
	}
	
	/**
	 * Post mapping for returning estimated price for trip details which is sent.
	 * @param details
	 * @return double price
	 */
	@PostMapping(value = "/estimatePrice")
	public double estimatePrice(@RequestBody CustomerRequest details) {
		return service.estimatePrice(details);
	}
	
	/**
	 * Get Mapping for fetching all location names.
	 * @param
	 * @return List<String>
	 */
	@GetMapping(value = "/allLocations")
	public List<String> getAlllLocations(){
		return service.getLocations();
	}
	
}
