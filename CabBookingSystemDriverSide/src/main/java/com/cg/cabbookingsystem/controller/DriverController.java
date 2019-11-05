package com.cg.cabbookingsystem.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.cabbookingsystem.dto.Booking;
import com.cg.cabbookingsystem.dto.Driver;
import com.cg.cabbookingsystem.dto.User;
import com.cg.cabbookingsystem.dto.Vehicle;
import com.cg.cabbookingsystem.exception.InvalidLoginException;
import com.cg.cabbookingsystem.repo.DriverRepo;

@Transactional
@RestController
@RequestMapping(value = "/driver")
public class DriverController {
	
	private DriverRepo repo;
	
	@Autowired
	public DriverController(DriverRepo repo) {
		this.repo = repo;
	}
	
	@PostMapping(value = "/driverList")
	public Driver listAllDrivers(@RequestBody List<Vehicle> vehicles){
		return repo.getListOfDrivers(vehicles);
	}
	
	@PostMapping(value = "/booking")
	public Booking getBookingDetails(@RequestBody Booking booking) {
		return repo.showBookingDetails(booking);
	}
	
	@GetMapping(value = "/history")
	public List<Booking> getHistoryOfDriver(@RequestParam int driverId){
		List<Booking> l = repo.getAllTripsOfADriver(driverId);
		System.out.println("$$$$$$$" + l.get(0));
		return l;
	}
	
	@PostMapping(value = "/validate")
	public Driver validateLogin(@RequestBody User user) {
		return repo.validateLogin(user);
	}

}
