package com.cg.cabbookingsystem.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cg.cabbookingsystem.dto.Booking;
import com.cg.cabbookingsystem.dto.DriverModel;
import com.cg.cabbookingsystem.dto.Vehicle;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/front")
public class FrontController {
	private RestTemplate template;
	@Autowired
	public FrontController(RestTemplate template) {
		this.template = template;
	}
	
	//Custom Object containing source, destination, cabsize can be obtained from Trip Selection Module(Akash Verma) and
	//further these can be extracted before passing in the query
	@GetMapping(value = "/get")
	public List<DriverModel> getListOfVehicles(@RequestParam String source, @RequestParam String cabSize, @RequestParam int size){
		DriverModel driver = null;
		List<DriverModel> drivers = new ArrayList<DriverModel>();
		List<Vehicle> vehicles = Arrays.asList(template.getForObject("http://localhost:8880/customer/get?source=" +source + "&cabSize=" + cabSize +"&size=" + size, Vehicle[].class));
		for(Vehicle vehicle : vehicles) {
			driver = template.postForObject("http://localhost:8882/driver/driverList",vehicle, DriverModel.class);
			drivers.add(driver);
		}
		
		return drivers;
	}
	
	@PostMapping(value = "/save")
	public DriverModel saveDriver(@RequestBody DriverModel driver) {
		DriverModel saveDriver = template.postForObject("http://localhost:8883/register", driver, DriverModel.class);
		return saveDriver;
	}
	
	@PostMapping(value = "/showBooking")
	public Booking showBookingDetails(@RequestBody Booking booking) {
		return template.postForObject("http://localhost:8883/register/booking", booking, Booking.class);
	}
	
	@GetMapping(value = "/fetch")
	public DriverModel getDriverByEmail(@RequestParam String email) {
		return template.getForObject("http://localhost:8883/register/fetch?email=" + email, DriverModel.class);
	}
	
	@GetMapping(value="/history")
	public List<Booking> getHistoryOfDriver(@RequestParam int driverId){
		return Arrays.asList(template.getForObject("http://localhost:8882/driver/history?driverId=" + driverId, Booking[].class));
	}

}
