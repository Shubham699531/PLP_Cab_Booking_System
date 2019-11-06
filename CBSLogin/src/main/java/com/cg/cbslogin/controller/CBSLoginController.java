package com.cg.cbslogin.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.cbslogin.dto.Customer;
import com.cg.cbslogin.dto.Driver;
import com.cg.cbslogin.dto.DriverSignupDetails;
import com.cg.cbslogin.dto.User;
import com.cg.cbslogin.repo.CBSLoginRepo;
import com.cg.cbslogin.service.CBSLoginService;



@RestController
@RequestMapping(value = "/login")
public class CBSLoginController {
	//http://localhost:8079/login
	private CBSLoginService service;;
	
	@Autowired
	public CBSLoginController(CBSLoginService service) {
		this.service = service;
	}
	
	@PostMapping(value = "/loginCustomer", consumes = "application/json", produces = "application/json")
	Customer verifyCustomer(@RequestBody User user) {
		System.out.println("======"+user.getEmail());
		return service.loginCustomer(user);
	}
	
	@PostMapping(value = "/loginDriver", consumes = "application/json",produces = "application/json")
	Driver verifyDriver(@RequestBody User user) {
		return service.loginDriver(user);
	}
	
	@PostMapping(value = "/signupCustomer" , consumes = "application/json",produces = "application/json")
	Customer signupCustomer(@RequestBody Customer customer) {
		return service.signupCustomer(customer);
	}
	
	@PostMapping(value = "/signupDriver", consumes = "application/json",produces = "application/json")
	DriverSignupDetails signupDriver(@RequestBody DriverSignupDetails driver) {
		return service.signupDriver(driver);
	}
}
