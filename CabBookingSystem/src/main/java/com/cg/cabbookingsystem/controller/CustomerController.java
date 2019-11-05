package com.cg.cabbookingsystem.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.cabbookingsystem.dto.Booking;
import com.cg.cabbookingsystem.dto.CustomerRequirement;
import com.cg.cabbookingsystem.dto.Vehicle;
import com.cg.cabbookingsystem.repo.CustomerRepo;

@Transactional
@RestController
@RequestMapping(value = "/customer")
//http://localhost:8082/customer
public class CustomerController {

	private CustomerRepo repo;
	
	@Autowired
	public CustomerController(CustomerRepo repo) {
		this.repo = repo;
	}
	
	@PostMapping(value = "/nearByVehicle", consumes = "application/json", produces = "application/json")
	public List<Vehicle> getNearByVehicle(@RequestBody CustomerRequirement req){
		return repo.getVehicles(req);
	}
	
	@PostMapping(value = "/bookACab", consumes = "application/json")
	public Booking bookACab(@RequestBody Booking booking) {
		return repo.bookACab(booking);
	}
}
