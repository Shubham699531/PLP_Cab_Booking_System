package com.cg.cbs.controller;

import java.util.List;

import org.apache.log4j.Logger;
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
 * Rest controller class for delegating http class to different methods.
 * @author Akash
 *
 */
//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/tripdetails")
//http://localhost:8001/tripdetails
public class TripController {

	//Logger for auditing application
	static Logger log = Logger.getLogger(TripController.class);
	
	@Autowired
	TripService service;
	
	/**
	 * Post mapping for saving the trip details which is sent.
	 * @param CustomerRequest
	 * @return CustomerRequest
	 * http://localhost:8001/tripdetails/add
	 */
	@PostMapping(value = "/add")
	public CustomerRequest addCustomerRequest(@RequestBody CustomerRequest details) {
		log.info("calling service method for saving customer request with source: "+details.getSource()+" destination: "+details.getDestination());
		return service.saveCustomerRequest(details);
	}
	
	/**
	 * Post mapping for returning estimated price for trip details which is sent.
	 * @param details
	 * @return double price
	 * http://localhost:8001/tripdetails/estimateprice
	 */
	@PostMapping(value = "/estimatePrice")
	public double estimatePrice(@RequestBody CustomerRequest details) {
		log.info("calling service method for estimating price with source: "+details.getSource()+" destination: "+details.getDestination());
		return service.estimatePrice(details);
	}
	
	/**
	 * Get Mapping for fetching all location names.
	 * @param
	 * @return List<String>
	 * http://localhost:8001/tripdetails/allLocations
	 */
	@GetMapping(value = "/allLocations")
	public List<String> getAlllLocations(){
		log.info("calling service method for estimating location");
		return service.getLocations();
	}
	
}
