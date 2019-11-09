package com.cg.cab.controller;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.cab.dto.Customer;
import com.cg.cab.dto.Driver;
import com.cg.cab.dto.User;
import com.cg.cab.dto.Vehicle;
import com.cg.cab.exception.UserNotFoundException;
import com.cg.cab.service.ICabService;


@Transactional
@RestController
@RequestMapping(value = "/cab")
public class CabController {
	private ICabService service;
    
	@Autowired
	public CabController(ICabService service) {
		this.service = service;
	}
	
	static Logger myLogger =  Logger.getLogger(CabController.class);
	//http://localhost:8880/cab/loginCustomer
	@PostMapping(value = "/loginCustomer", consumes = "application/json", produces = "application/json")
	Customer verifyCustomer(@RequestBody User user) throws UserNotFoundException {
		myLogger.info("================================================");
		myLogger.info("POST MAPPING REQUEST to VALIDATE Customer");

		System.out.println("======"+user.getEmail());
		return service.validateLoginCustomer(user);
	}
	
	//http://localhost:8880/cab/signupCustomer
	@PostMapping(value = "/signupCustomer" , consumes = "application/json",produces = "application/json")
	Customer signupCustomer(@RequestBody Customer customer) {
		myLogger.info("================================================");
		myLogger.info("POST MAPPING REQUEST for SIGN-UP Customer");

		return service.saveCustomer(customer);
	}
	

	//http://localhost:8880/cab/saveDriver
	@PostMapping(value = "/saveDriver", consumes = "application/json")
	public Driver saveDriver(@RequestBody Driver driver) {
		myLogger.info("================================================");
		myLogger.info("POST MAPPING REQUEST for SIGN-UP Driver");
		return service.saveDriver(driver);
	}
	
	//http://localhost:8880/cab/saveVehicle
	@PostMapping(value = "/saveVehicle")
	public Vehicle saveVehicle(@RequestBody Vehicle vehicle) {
		return service.saveVehicle(vehicle);
	}
	
	//http://localhost:8880/cab/loginDriver
	@PostMapping(value = "/loginDriver")
	public Driver validateLogin(@RequestBody User user) throws UserNotFoundException {
		myLogger.info("================================================");
		myLogger.info("POST MAPPING REQUEST to VALIDATE Driver");

		Driver driver =  service.validateLoginDriver(user);
		System.out.println(driver.getDriverId());
		return driver;
	}
}
