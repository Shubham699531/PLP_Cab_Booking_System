package com.cg.cbs.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.cbs.dto.TripDetails;
import com.cg.cbs.service.TripService;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/tripdetails")
public class TripController {

	@Autowired
	TripService service;
	
	@PostMapping(value = "/add")
	public TripDetails addTripDetails(@RequestBody TripDetails details) {
		return service.saveTripDetails(details);
	}
	
	@PostMapping(value = "/estimateprice")
	public double estimatePrice(@RequestBody TripDetails details) {
		return service.estimatePrice(details);
	}
	
	@GetMapping(value = "/allLocations")
	public List<String> getAlllLocations(){
		return service.getLocations();
	}
	
}
