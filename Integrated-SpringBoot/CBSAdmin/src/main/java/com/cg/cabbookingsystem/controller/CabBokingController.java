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
import org.springframework.web.bind.annotation.RequestParam;
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
@RequestMapping("/admin")
public class CabBokingController {
	
	@Autowired
	private CabBookingService service;
	
	//http://localhost:8888/admin/saveDriver
	@PostMapping(value = "/saveDriver", consumes = "application/json")
	public Driver saveDriver(@RequestBody Driver driver) {
		return service.saveDriver(driver);
	}
	
	@GetMapping(value = "/getAllDrivers", produces = "application/json")
	public List<Driver> getAllDriver(){
		return service.getAllDriver();
	}
	@GetMapping(value = "/driver/{id}", produces = "application/json")
	public Driver findDriver(@PathVariable int id) throws DriverNotFoundException {
		return service.findDriver(id);
	}
	
	@GetMapping(value = "/remove/{id}", produces = "application/json")
	public boolean deleteDriver(@PathVariable int id) throws DriverNotFoundException {
		return service.deleteDriver(id);
	}
	
	@PostMapping(value = "/updateDriver", consumes = "application/json", 
			produces = "application/json")
	public Driver updateDriver(@RequestBody Driver driver ) {
	
		return service.updateDriver(driver);
	}
	
	@GetMapping( value = "/report", produces = "application/json")
	public List<Report> getAllReport(){
		return service.getAllReport();
	}
	@PostMapping(value = "/saveReport", consumes = "application/json")
	public Report saveReport(@RequestBody Report report) {
		return service.saveReport(report);
	}
	
	@PostMapping(value = "/saveBooking", consumes = "application/json")
	public Booking saveBooking(@RequestBody Booking booking) {
		return service.saveBooking(booking);
	}
	
	@GetMapping( value = "/getAllBooking", produces = "application/json")
	public List<Booking> getAllBooking(){
		return service.getBookingDetails();
	}
}
