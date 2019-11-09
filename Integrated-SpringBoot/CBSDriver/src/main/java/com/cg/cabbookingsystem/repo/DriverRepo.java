package com.cg.cabbookingsystem.repo;

import java.util.List;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cg.cabbookingsystem.dto.Booking;
import com.cg.cabbookingsystem.dto.Customer;
import com.cg.cabbookingsystem.dto.Driver;
import com.cg.cabbookingsystem.dto.Vehicle;
import com.cg.cabbookingsystem.exception.NoBookingFoundException;
import com.cg.cabbookingsystem.exception.NoPastRidesFoundException;

/**
 * Interface for defining specific roles of driver 
 * @author Shubham
 * @version 1.0
 *
 */
public interface DriverRepo {
	
	/**
	 * Find a suitable driver for the customer from the list of available 
	 *  cabs
	 * @param vehicles
	 * 	List of vehicles coming from customer side which
	 * 	contains information of the vehicles that are nearby and free
	 * @return the selected driver who is assigned for the
	 * coming customer request
	 */
	Driver getOneDriver(List<Vehicle> vehicles);
	
	/**
	 * Shows a list of past rides of the logged in driver
	 * @param driverId
	 * 	id of the driver who is logged in
	 * @return
	 * list of past rides along with source, destination and fare
	 * @throws NoPastRidesFoundException 
	 * if no past rides exist for the driver with the queried driverId
	 */
	List<Booking> getAllTripsOfADriver(int userId) throws NoPastRidesFoundException;

	/**
	 * Gets a driver by email id
	 * @param email
	 * email Id of the driver to be searched
	 * @return
	 * driver with the entered email id
	 */
	Driver fetchByEmail(String email);
	
	/**
	 * Searches for a current Booking for the driver who is logged in
	 * @param driverId
	 * id of the driver who is logged in
	 * @return
	 * customer details who is alloted to the logged in driver
	 * @throws NoBookingFoundException 
	 * if there's no booking for the driver with the given driverId
	 */
	Customer searchForBooking(int driverId) throws NoBookingFoundException;
	
	/**
	 * Gets booking details for a particular driver
	 * @param driverId
	 * id of the driver whose booking details are to be fetched
	 * @return
	 * confirmed booking details for the driver
	 * @throws NoBookingFoundException 
	 * if there's no booking for the driver with the given driverId
	 */
	Booking getBookingDetailsForADriver(int driverId) throws NoBookingFoundException;


}
