package com.cg.cabbookingsystem.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;

import com.cg.cabbookingsystem.dto.Booking;
import com.cg.cabbookingsystem.dto.Customer;
import com.cg.cabbookingsystem.dto.CustomerRequest;
import com.cg.cabbookingsystem.dto.Location;
import com.cg.cabbookingsystem.dto.Vehicle;
import com.cg.cabbookingsystem.exception.VehicleNotFoundException;

public interface CustomerService {

	/**
	 * List the vehicles that are within the 3KM radius of the customer pickup location
	 * @param CustomerRequest
	 * 			Contains source, destination and vehicle type as requested by the customer
	 * @return List<Vehicle>
	 * 			List of available vehicles that close to the pickup location 
	 * @throws VehicleNotFoundException 
	 */
	public List<Vehicle> getNearByVehicles(CustomerRequest req) throws VehicleNotFoundException ;
	
	/**
	 * Get the booking details to the database
	 * @param Booking
	 * 			Contains the details to be saved to the database
	 * @return Booking
	 * 			
	 */
	public Booking bookACab(Booking booking);
	
	/**
	 * Fetches the list of past trips for a particular customer
	 * @param Customer
	 * 			Details of the customers whos past trips we need to retrieve
	 * @return List<Booking>
	 * 			List of past trips for a particular customer
	 */
	public List<Booking> pastTrips(Customer customer);
	
	/**
	 * Estimate the time of trip based on the customer request
	 * @param req
	 * @return int
	 * 			Estimate time in minutes
	 */
	public int estimateTime(CustomerRequest req);
	
	/**
	 * Calculate the distance between two locations
	 * @param source
	 * @param destination
	 * @return double 
	 * 			Distance in KM
	 */
	public double calculateDistance(String source, String destination);

	public Location getLocationByName(String locationName);
	
	public Booking checkRatedStatus(@RequestParam int customerId);

	public Booking getBookingForCustomer(int customerId);
}
