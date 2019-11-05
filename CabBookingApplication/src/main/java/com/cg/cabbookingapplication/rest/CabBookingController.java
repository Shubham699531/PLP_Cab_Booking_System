
package com.cg.cabbookingapplication.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.cabbookingapplication.dto.Customer;
import com.cg.cabbookingapplication.dto.Driver;
import com.cg.cabbookingapplication.exception.InvalidLoginDetails;
import com.cg.cabbookingapplication.service.CabBookingService;


@RestController
@RequestMapping("/cabbooking")
@CrossOrigin(origins = "http://localhost:4200")
public class CabBookingController {
	
	@Autowired
	private CabBookingService service;
	
	@GetMapping(value="/customer/{email}/{password}", produces="application/json")
	public List<Customer> getCustomer(@PathVariable String email, @PathVariable String password) throws InvalidLoginDetails {
		return service.findCustomer(email, password);		
	}
	@GetMapping(value="/driver/{email}/{password}", produces="application/json")
	public List<Driver> getDriver(@PathVariable String email, @PathVariable String password) throws InvalidLoginDetails {
		return service.findDriver(email, password);	
	}
	@PostMapping(value="/addCustomer", consumes="application/json", produces = "application/json")
	public Customer addCustomer(@Valid @RequestBody Customer customer) {
		return service.addCustomer(customer);
		
	}
	
	@PostMapping(value="/addDriver", consumes="application/json", produces = "application/json")
	public Driver addDriver(@RequestBody Driver driver) {
		return service.addDriver(driver);
		
	}

}
