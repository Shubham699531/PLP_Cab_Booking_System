package com.cg.cabbookingsystem.repo;

import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;

import com.cg.cabbookingsystem.dto.Booking;
import com.cg.cabbookingsystem.dto.Customer;
import com.cg.cabbookingsystem.dto.CustomerRequest;
import com.cg.cabbookingsystem.dto.Location;
import com.cg.cabbookingsystem.dto.Vehicle;

/**
 * Functions required to interact with the database for cab allocation
 * @author Vishal
 * @version 1.0
 *
 */
public interface CustomerRepo {

	/**
	 * Fetch the list of all the available vehicles
	 * @param CustomerRequest
	 * 			Contains source, destination and vehicle type as requested by the customer
	 * @return List<Vehicle>
	 * 			List of vehicles that are available at the moment 
	 */
	List<Vehicle> getAvailableVehicles(CustomerRequest req);
	
	/**
	 * Persists the booking details to the database
	 * @param Booking
	 * 			Contains the details to be saved to the database
	 * @return Booking
	 * 			
	 */
	Booking bookACab(Booking booking);
	
	/**
	 * Fetches the list of past trips for a particular customer
	 * @param Customer
	 * 			Details of the customers whos past trips we need to retrieve
	 * @return List<Booking>
	 * 			List of past trips for a particular customer
	 */
	List<Booking> pastTrips(Customer customer);
	
	/**
	 * Fetches the location details based on the name of the location
	 * @param locationName
	 * 			Name of the location we need to retrieve
	 * @return Location
	 * 			Details of a particular location
	 */
	Location getLocationByName(String name);
	
	/**
	 * 
	 * @param customerId
	 * @return
	 */
	public Booking checkRatedStatus(@RequestParam int customerId);

	Booking getBookingForCustomer(int customerId);
}
