package com.cg.cabbookingsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.cabbookingsystem.dto.CustomerRequest;
import com.cg.cabbookingsystem.dto.Vehicle;
import com.cg.cabbookingsystem.repo.CustomerRepo;

@RestController
@RequestMapping(value = "/customer")
public class CustomerController {
	private CustomerRepo repo;
	
	@Autowired
	public CustomerController(CustomerRepo repo) {
		this.repo = repo;
	}
	
	@GetMapping(value = "/locations", consumes = "application/json")
	public double calculateDistance(@RequestBody CustomerRequest request) {
		return repo.calculateDistance(request.getSource(), request.getDestination());
	}
	
	@GetMapping(value = "/get", produces = "application/json")
	public List<Vehicle> getVehicles(@RequestParam String source, @RequestParam String cabSize, @RequestParam int size){
		return repo.getVehicleNumbers(source, cabSize, size);
	}
	

}
