package com.cg.cabbookingsystem.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.cg.cabbookingsystem.dto.Booking;
import com.cg.cabbookingsystem.dto.Customer;
import com.cg.cabbookingsystem.dto.CustomerRequest;
import com.cg.cabbookingsystem.dto.Location;
import com.cg.cabbookingsystem.dto.Vehicle;

/**
 * Implementation of functions required to interact with the database for cab allocation
 * @author Vishal
 * @version 1.0
 *
 */
@Repository
public class CustomerRepoImpl implements CustomerRepo {

	@PersistenceContext
	EntityManager mgr;

	/**
	 * Fetch the list of all the available vehicles
	 * @param CustomerRequest
	 * 			Contains source, destination and vehicle type as requested by the customer
	 * @return List<Vehicle>
	 * 			List of vehicles that are available at the moment 
	 */
	@Override
	public List<Vehicle> getAvailableVehicles(CustomerRequest req) {
		return mgr.createNamedQuery("fetchVehicleByCategory", Vehicle.class).setParameter("model", req.getModel()).getResultList();
	}

	/**
	 * Persists the booking details to the database
	 * @param Booking
	 * 			Contains the details to be saved to the database
	 * @return Booking
	 * 			
	 */
	@Override
	public Booking bookACab(Booking booking) {
		mgr.persist(booking);
		return booking;
	}

	/**
	 * Fetches the list of past trips for a particular customer
	 * @param Customer
	 * 			Details of the customers whos past trips we need to retrieve
	 * @return List<Booking>
	 * 			List of past trips for a particular customer
	 */
	@Override
	public List<Booking> pastTrips(Customer customer) {
		return mgr.createNamedQuery("getPastRidesOfCustomer", Booking.class).setParameter("customerId", customer.getId()).getResultList();
	}

	/**
	 * Fetches the location details based on the name of the location
	 * @param locationName
	 * 			Name of the location we need to retrieve
	 * @return Location
	 * 			Details of a particular location
	 */
	@Override
	public Location getLocationByName(String locationName) {
		return mgr.createNamedQuery("fetchLocationByName", Location.class).setParameter("name", locationName).getSingleResult();
	}
	
	public Booking checkRatedStatus(@RequestParam int customerId) {
		return mgr.createNamedQuery("checkRatedBookingStatus", Booking.class).setParameter("customerId", customerId).getSingleResult();
	}
}
