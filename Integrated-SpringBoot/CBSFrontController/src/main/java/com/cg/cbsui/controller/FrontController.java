package com.cg.cbsui.controller;

import java.util.Arrays;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.cg.cbsui.dto.Booking;
import com.cg.cbsui.dto.Customer;
import com.cg.cbsui.dto.CustomerRequest;
import com.cg.cbsui.dto.Driver;
import com.cg.cbsui.dto.Location;
import com.cg.cbsui.dto.Payment;
import com.cg.cbsui.dto.Report;
import com.cg.cbsui.dto.Users;
import com.cg.cbsui.dto.Vehicle;
import com.cg.cbsui.exception.BackendException;
import com.cg.cbsui.exception.DriverNotFoundException;
import com.cg.cbsui.exception.InsufficientWalletBalanceException;
import com.cg.cbsui.exception.InvalidBookingException;
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/cbs")
//http://localhost:8180/cbs
public class FrontController {

	RestTemplate restTemplate;
	@Autowired
	public FrontController(RestTemplate template) {
		this.restTemplate = template;
	}
	
	//Surjani $
	//http://localhost:8180/cbs/loginCustomer
	@PostMapping(value = "/loginCustomer", consumes = "application/json",produces = "application/json")
	Customer loginCustomer(@RequestBody Users user) throws BackendException{
		Customer cust = new Customer();
		HttpEntity<Users> requestEntity = new HttpEntity<>(user);
		try {
			ResponseEntity<Customer> response = restTemplate.exchange("http://localhost:8880/cab/loginCustomer", HttpMethod.POST, requestEntity, Customer.class); 
			cust = response.getBody();
			System.out.println("%%%%%%%%%%%" + cust.getId());
		}catch (HttpClientErrorException e) { 
			throw new BackendException(e.getResponseBodyAsString());
		}
		return cust;
	}
	
	//Surjani $
	//http://localhost:8180/cbs/signupCustomer
	@PostMapping(value="/signupCustomer", consumes = "application/json",produces = "application/json")
	Customer signupCustomer(@RequestBody Customer customer) throws BackendException{
		Customer cust = new Customer();
		HttpEntity<Customer> requestEntity = new HttpEntity<>(customer);
		try {
			System.out.println("*****" + customer.getEmail());
			ResponseEntity<Customer> response = restTemplate.exchange("http://localhost:8880/cab/signupCustomer", HttpMethod.POST, requestEntity, Customer.class);
			cust = response.getBody();
		}catch (HttpClientErrorException e) { 
			throw new BackendException(e.getResponseBodyAsString());
		}
		return cust;
	}
	
	//Surjani $
	//http://localhost:8180/cbs/loginDriver
	@PostMapping(value = "/loginDriver")
	public Driver validateDriver(@RequestBody Users user) throws BackendException{
		Driver driver = new Driver();
		HttpEntity<Users> requestEntity = new HttpEntity<>(user);
		try {
			ResponseEntity<Driver> response = restTemplate.exchange("http://localhost:8880/cab/loginDriver", HttpMethod.POST, requestEntity, Driver.class);
			driver = response.getBody();
		}catch (HttpClientErrorException e) { 
			throw new BackendException(e.getResponseBodyAsString());
		}
		return driver;
	}
		
	//Surjani $
 	//http://localhost:8180/cbs/signupDriver
	@PostMapping(value = "/signupDriver")
	public Driver saveDriver(@RequestBody Driver driver) throws BackendException{
		Driver saveDriver = new Driver();
		HttpEntity<Driver> requestEntity = new HttpEntity<>(driver);
		try {
			ResponseEntity<Driver> response = restTemplate.exchange("/http://localhost:8880/cab/saveDriver", HttpMethod.POST, requestEntity, Driver.class);
			driver = response.getBody();
		}catch (HttpClientErrorException e) { 
			throw new BackendException(e.getResponseBodyAsString());
		}
		return saveDriver;
	}
		
	//Surjani $
 	//http://localhost:8180/cbs/saveVehicle
	@PostMapping(value = "/saveVehicle")
	public Vehicle saveVehicle(@RequestBody Vehicle vehicle) throws BackendException{
		Vehicle saveVehicle = new Vehicle();
		HttpEntity<Vehicle> requestEntity = new HttpEntity<>(saveVehicle);
		try {
			 ResponseEntity<Vehicle> response = restTemplate.exchange("http://localhost:8880/cab/saveVehicle", HttpMethod.POST, requestEntity, Vehicle.class);
			 saveVehicle = response.getBody();
		}catch (HttpClientErrorException e) { 
			throw new BackendException(e.getResponseBodyAsString());
		}
		return saveVehicle;
	}
	
	//Vishal $
	//http://localhost:8180/cbs/findACab
	@PostMapping(value = "/findACab", consumes = "application/json",produces = "application/json")
	Booking booking(@RequestBody CustomerRequest req) {
			Vehicle[] nearByVehicles = restTemplate.postForObject("http://localhost:8082/customer/nearByVehicle", req, Vehicle[].class);
			
			for (Vehicle vehicle : nearByVehicles) {
				System.out.println("#####"+vehicle.toString());
			}
			
			//May have an issue because this function accepts List<Vehicles>
			Driver allocatedDriver = restTemplate.postForObject("http://localhost:8882/driver/selectOneDriver", nearByVehicles, Driver.class);
			System.out.println("****" + allocatedDriver.getEmail());
			Booking bookingdetails = new Booking();
			bookingdetails.setCustomerId(req.getCustomerId());
			bookingdetails.setDestination(req.getDestination());
			bookingdetails.setDriverId(allocatedDriver.getDriverId());
			bookingdetails.setDriverStatus("confirmed");
			bookingdetails.setTripStatus("confirmed");
			bookingdetails.setSource(req.getSource());
			bookingdetails.setEstimatedFare(restTemplate.postForObject("http://localhost:8001/tripdetails/estimatePrice", req, Double.class));
			bookingdetails.setEstimatedTime(restTemplate.postForObject("http://localhost:8082/customer/estimateTime", req, Integer.class));
			Booking booking = restTemplate.postForObject("http://localhost:8082/customer/bookACab", bookingdetails, Booking.class);
			return booking;
	}
	
	//Vishal $
	//http://localhost:8180/cbs/estimateTime
	@PostMapping(value = "/estimateTime")
	public int estimateTime(@RequestBody CustomerRequest req) throws BackendException{
		int time = 0;
		HttpEntity<CustomerRequest> requestEntity = new HttpEntity<>(req);
		try {
			ResponseEntity<Integer> response = restTemplate.exchange("http://localhost:8082/customer/estimateTime", HttpMethod.POST, requestEntity, Integer.class);
			time = response.getBody();
		}catch (HttpClientErrorException e) { 
			throw new BackendException(e.getResponseBodyAsString());
		}
		return time;
	}
	
	//Shubham $
	//http://localhost:8180/cbs/getBookingForADriver?driverId=
	@GetMapping(value = "/getBookingForADriver")
	public Booking getBookingForADriver(@RequestParam int driverId) throws BackendException{
		Booking booking = new Booking();
		HttpEntity<Integer> requestEntity = new HttpEntity<>(driverId);
		try {
			ResponseEntity<Booking> response = restTemplate.exchange("http://localhost:8882/driver/getBooking?driverId="+driverId, HttpMethod.GET, requestEntity, Booking.class);
			booking = response.getBody();
		} catch (HttpClientErrorException e) { 
			throw new BackendException(e.getResponseBodyAsString());
		}
		return booking;
	}
	
	//Shubham $
	//http://localhost:8180/cbs/selectDriver
	@GetMapping(value = "/selectDriver")
	public Driver selectADriver(@RequestBody List<Vehicle> listOfSelectedVehicles) throws BackendException{
		Driver driver = new Driver();
		HttpEntity<List<Vehicle>> requestEntity = new HttpEntity<>(listOfSelectedVehicles);
		try {
			ResponseEntity<Driver> response = restTemplate.exchange("http://localhost:8882/driver/driverList", HttpMethod.GET, requestEntity, Driver.class);
			driver = response.getBody();
		} catch (HttpClientErrorException e) { 
			throw new BackendException(e.getResponseBodyAsString());
		}
		return driver;	
	}
	
	//Shubham $
	//http://localhost:8180/cbs/fetchDriverByEmail?email=
	@GetMapping(value = "/fetchDriverByEmail")
	public Driver getDriverByEmail(@RequestParam String email) throws BackendException{
		Driver driver = new Driver();
		HttpEntity<String> requestEntity = new HttpEntity<>(email);
		try {
			ResponseEntity<Driver> response = restTemplate.exchange("http://localhost:8882/driver/fetch?email=" + email, HttpMethod.GET, requestEntity, Driver.class);
			driver = response.getBody();
		} catch (HttpClientErrorException e) { 
			throw new BackendException(e.getResponseBodyAsString());
		}
		return driver;	
	}
	
	//Shubham $
	//http://localhost:8180/cbs/pastTripsDriver?driverId=
	@GetMapping(value="/pastTripsDriver")
	public List<Booking> getHistoryOfDriver(@RequestParam int driverId) {
		return Arrays.asList(restTemplate.getForObject("http://localhost:8882/driver/history?driverId=" + driverId, Booking[].class));	
	}
	
	
	//Shubham $
	//http://localhost:8180/cbs/getCustomerFromBooking?driverId=
	@GetMapping(value = "/getCustomerFromBooking")
	public Customer getCustomerDetails(@RequestParam int driverId) throws BackendException{
		Customer customer = new Customer();
		HttpEntity<Integer> requestEntity = new HttpEntity<>(driverId);
		try {
			ResponseEntity<Customer> response = restTemplate.exchange("http://localhost:8882/driver/getCustomerFromBooking?driverId=" + driverId, HttpMethod.GET, requestEntity, Customer.class);
			customer = response.getBody();
		} catch (HttpClientErrorException e) { 
			throw new BackendException(e.getResponseBodyAsString());
		}
		return customer;		
	}

	
	//Akash $
	//http://localhost:8180/cbs/saveCustomerRequest
	@PostMapping(value = "/saveCustomerRequest",consumes = "application/json",produces = "application/json")
	public CustomerRequest saveCustomerRequest(@RequestBody CustomerRequest request) throws BackendException{
		CustomerRequest customerRequest = new CustomerRequest();
		HttpEntity<CustomerRequest> requestEntity = new HttpEntity<>(request);
		try {
			ResponseEntity<CustomerRequest> response = restTemplate.exchange("http://localhost:8001/tripdetails/add", HttpMethod.POST, requestEntity, CustomerRequest.class);
			customerRequest = response.getBody();
		} catch (HttpClientErrorException e) { 
			throw new BackendException(e.getResponseBodyAsString());
		}
		return customerRequest;
	}
	
	//Akash $
	//http://localhost:8180/cbs/estimateFare
	@PostMapping(value = "/estimateFare")
	public double estimateFare(@RequestBody CustomerRequest request) throws BackendException{
		double estimatedFare = 0;
		HttpEntity<CustomerRequest> requestEntity = new HttpEntity<>(request);
		try {
			ResponseEntity<Double> response = restTemplate.exchange("http://localhost:8001/tripdetails/estimatePrice", HttpMethod.POST, requestEntity, Double.class);
			estimatedFare = response.getBody();
		} catch (HttpClientErrorException e) { 
			throw new BackendException(e.getResponseBodyAsString());
		}
		return estimatedFare;
	}
	
	//Akash $
	//http://localhost:8180/cbs/allLocations
	@GetMapping(value = "/allLocations")
	public String[] getAllLocations(){
		return restTemplate.getForObject("http://localhost:8001/tripdetails/allLocations", String[].class);
	}
	
	//Vishal $
	//http://localhost:8180/cbs/pastTrips
	@PostMapping(value = "/pastTrips")
	public Booking[] pastTrips(@RequestBody Customer customer) {
		return restTemplate.postForObject("http://localhost:8082/customer/pastTrips", customer,Booking[].class);
	}
	
	//Aman $
	//http://localhost:8180/cbs/startTrip
	@PostMapping(value = "/startTrip")
	public Booking startTrip(@RequestBody Booking booking) throws BackendException{
		Booking newBooking = new Booking();
		HttpEntity<Booking> requestEntity = new HttpEntity<>(booking);
		try {
			ResponseEntity<Booking> response = restTemplate.exchange("http://localhost:8810/transit/startTrip", HttpMethod.POST, requestEntity, Booking.class);
			newBooking = response.getBody();
		} catch (HttpClientErrorException e) { 
			throw new BackendException(e.getResponseBodyAsString());
		}
		return newBooking;
	}
	
	//Aman $
	//http://localhost:8180/cbs/endTrip
	@PostMapping(value = "/endTrip")
	public Booking endTrip(@RequestBody Booking booking) throws BackendException{
		Booking newBooking = new Booking();
		HttpEntity<Booking> requestEntity = new HttpEntity<>(booking);
		try {
			ResponseEntity<Booking> response = restTemplate.exchange("http://localhost:8810/transit/endTrip", HttpMethod.POST, requestEntity, Booking.class);
			newBooking = response.getBody();
		} catch (HttpClientErrorException e) { 
			throw new BackendException(e.getResponseBodyAsString());
		}
		return newBooking;	
	}
	
	//Aman $
	//http://localhost:8180/cbs/rateTrip
	@PostMapping(value = "/rateTrip")
	public Booking rateTrip(@RequestBody Booking booking) throws BackendException {
		Booking newBooking = new Booking();
		HttpEntity<Booking> requestEntity = new HttpEntity<>(booking);
		try {
			ResponseEntity<Booking> response = restTemplate.exchange("http://localhost:8810/transit/rateTrip", HttpMethod.POST, requestEntity, Booking.class);
			newBooking = response.getBody();
		} catch (HttpClientErrorException e) { 
			throw new BackendException(e.getResponseBodyAsString());
		}
		return newBooking;	
	}
	
	//Anchita $
	//http://localhost:8180/cbs/payment
	@PostMapping(value="/payment", produces = "application/json", consumes = "application/json")
	public Payment addPayment(@RequestBody Booking booking) throws BackendException {
		Payment payment = new Payment();
		HttpEntity<Booking> requestEntity = new HttpEntity<>(booking);
		try {
			ResponseEntity<Payment> response = restTemplate.exchange("http://localhost:8885/paymentsfeedback/payment",HttpMethod.POST, requestEntity, Payment.class);
			payment = response.getBody();
		} catch (HttpClientErrorException e) { 
			throw new BackendException(e.getResponseBodyAsString());
		}
		return payment;
	}
	
	//Anchita $
	//http://localhost:8180/cbs/feedback
	@PostMapping(value = "/feedback", produces = "application/json", consumes = "application/json")
	public Report feedback(@RequestBody Booking booking) {
		return restTemplate.postForObject("http://localhost:8885/paymentsfeedback/updateFeedback", booking, Report.class);
	}
	
	//Anchita $
	//http://localhost:8180/cbs/findCustomer
	@PostMapping(value = "/findCustomer", produces = "application/json",consumes = "application/json")
	public Customer findCustomer(@RequestBody Booking booking) throws BackendException {
		Customer customer = new Customer();
		HttpEntity<Booking> requestEntity = new HttpEntity<>(booking);
		try{
			ResponseEntity<Customer> response = restTemplate.exchange("http://localhost:8885/paymentsfeedback/findCustomer", HttpMethod.GET, requestEntity, Customer.class);
			customer = response.getBody();
		} catch (HttpClientErrorException e) {
			throw new BackendException(e.getResponseBodyAsString());
		}
		return customer;
	}
	
	//Vineeta $
	//http://localhost:8180/cbs/getAllDrivers
	@GetMapping(value = "getAllDrivers", produces = "application/json")
	public Driver[] getAllDrivers() {
		return restTemplate.getForObject("http://localhost:8888/admin/getAllDrivers", Driver[].class);
	}
	
	//Vineeta $
	//http://localhost:8180/cbs/driverById/
	@GetMapping(value = "/driverById/{id}", produces = "application/json")
	public Driver findDriver(@PathVariable int id) throws BackendException{
		Driver driver = new Driver();
		HttpEntity<Integer> requestEntity = new HttpEntity<>(id);
		try{
			ResponseEntity<Driver> response = restTemplate.exchange("http://localhost:8888/admin/driver/" + id, HttpMethod.GET, requestEntity, Driver.class);
			driver = response.getBody();
		} catch (HttpClientErrorException e) {
			throw new BackendException(e.getResponseBodyAsString());
		}
		return driver;
	}
	
	//Vineeta $
	//http://localhost:8180/cbs/deleteDriver/
	@GetMapping(value = "/deleteDriver/{id}", produces = "application/json")
	public boolean deleteDriver(@PathVariable int id) throws BackendException {
		boolean result = false;
		HttpEntity<Integer> requestEntity = new HttpEntity<>(id);
		try{
			ResponseEntity<Boolean> response = restTemplate.exchange("http://localhost:8888/admin/remove/" + id, HttpMethod.GET, requestEntity, Boolean.class);
			result = response.getBody();
		} catch (HttpClientErrorException e) {
			throw new BackendException(e.getResponseBodyAsString());
		}
		return result;
	}
	
	//Vineeta $
	//http://localhost:8180/cbs/updateDriver
	@PostMapping(value = "/updateDriver", consumes = "application/json", produces = "application/json")
	public Driver updateDriver(@RequestBody Driver driver ) throws BackendException{
		Driver registeredDriver = new Driver();
		HttpEntity<Driver> requestEntity = new HttpEntity<>(driver);
		try{
			ResponseEntity<Driver> response = restTemplate.exchange("http://localhost:8888/admin/updateDriver", HttpMethod.POST, requestEntity, Driver.class);
			registeredDriver = response.getBody();
		} catch (HttpClientErrorException e) {
			throw new BackendException(e.getResponseBodyAsString());
		}
		return registeredDriver;
	}
	
	//Vineeta $
	//http://localhost:8180/cbs/getAllReport
	@GetMapping( value = "/getAllReport", produces = "application/json")
	public Report[] getAllReport(){
		return restTemplate.getForObject("http://localhost:8888/admin/report", Report[].class);
	}
	
	
	//Vineeta $
	//http://localhost:8180/cbs/getAllBooking
	@GetMapping( value = "/getAllBooking", produces = "application/json")
	public Booking[] getAllBooking(){
		return restTemplate.getForObject("http://localhost:8888/admin/getAllBooking", Booking[].class);
	}
	
}
