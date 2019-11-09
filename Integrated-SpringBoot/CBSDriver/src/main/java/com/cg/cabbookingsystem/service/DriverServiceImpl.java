package com.cg.cabbookingsystem.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.cabbookingsystem.dto.Booking;
import com.cg.cabbookingsystem.dto.Customer;
import com.cg.cabbookingsystem.dto.Driver;
import com.cg.cabbookingsystem.dto.Vehicle;
import com.cg.cabbookingsystem.repo.DriverRepo;

@Transactional
@Service
public class DriverServiceImpl implements DriverService{
	
	@Autowired
	private DriverRepo repo;

	/**
	 * Find a suitable driver for the customer from the list of available 
	 *  cabs
	 * @param vehicles
	 * 	List of vehicles coming from customer side which
	 * 	contains information of the vehicles that are nearby and free
	 * @return the selected driver who is assigned for the
	 * coming customer request
	 */
	@Override
	public Driver getOneDriver(List<Vehicle> vehicles) {
		return repo.getOneDriver(vehicles);
	}

	/**
	 * Shows a list of past rides of the logged in driver
	 * @param driverId
	 * 	id of the driver who is logged in
	 * @return
	 * list of past rides along with source, destination and fare
	 */
	@Override
	public List<Booking> getAllTripsOfADriver(int userId) {
		return repo.getAllTripsOfADriver(userId);
	}

	/**
	 * Gets a driver by email id
	 * @param email
	 * email Id of the driver to be searched
	 * @return
	 * driver with the entered email id
	 */
	@Override
	public Driver fetchByEmail(String email) {
		return repo.fetchByEmail(email);
	}

	/**
	 * Searches for a current Booking for the driver who is logged in
	 * @param driverId
	 * id of the driver who is logged in
	 * @return
	 * customer details who is alloted to the logged in driver
	 */
	@Override
	public Customer searchForBooking(int driverId) {
		return repo.searchForBooking(driverId);
	}
	
	@Override
	public Booking getBookingDetailsForADriver(int driverId) {
		return repo.getBookingDetailsForADriver(driverId);
	}

}
