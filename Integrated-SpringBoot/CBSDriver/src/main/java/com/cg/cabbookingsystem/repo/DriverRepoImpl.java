package com.cg.cabbookingsystem.repo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cg.cabbookingsystem.dto.Booking;
import com.cg.cabbookingsystem.dto.Customer;
import com.cg.cabbookingsystem.dto.Driver;
import com.cg.cabbookingsystem.dto.Vehicle;

/**
 * Implementing specific roles of a driver
 * @author Shubham
 * @version 1.0
 *
 */
@Repository
public class DriverRepoImpl implements DriverRepo {
	private EntityManager mgr;
	static Logger myLogger = Logger.getLogger(DriverRepoImpl.class);
	@Autowired
	public DriverRepoImpl(EntityManager mgr) {
		this.mgr = mgr;
	}
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
		ArrayList<Driver> drivers = new ArrayList<Driver>();
		Driver driver = new Driver();
		for (Vehicle vehicle : vehicles) {
			drivers.add(mgr.createNamedQuery("fetchDriverByVehicleNo", Driver.class).setParameter("vehicleNo", vehicle.getVehicleNo()).getSingleResult());
		}
		
		driver = drivers.get(0);
		mgr.createNamedQuery("updateDriverStatus").setParameter("status","Booked").setParameter("id", driver.getDriverId());
		driver.setDriverStatus("Booked");
		return driver;
	}

	/**
	 * Shows a list of past rides of the logged in driver
	 * @param driverId
	 * 	id of the driver who is logged in
	 * @return
	 * list of past rides along with source, destination and fare
	 * @throws NoPastRidesFoundException 
	 * if no past rides exist for the driver with the queried driverId
	 */
	@Override
	public List<Booking> getAllTripsOfADriver(int driverId) throws NoPastRidesFoundException {
		List<Booking> bookings = new ArrayList<Booking>();
		bookings = mgr.createNamedQuery("getPastRidesOfDriver",Booking.class).setParameter("driverId", driverId).getResultList();
		if(bookings.size()>0) {
			return bookings;
		}
		else {
			myLogger.warn("No past rides found for driver with driver Id: " + driverId);
			throw new NoPastRidesFoundException("Driver Id: " + driverId + " No past rides for you.");
		}
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
		Driver driver = null;
		try {
			driver =  mgr.createNamedQuery("fetchDriverByEmail", Driver.class).setParameter("email", email).getSingleResult();
		} catch (Exception e) {
			myLogger.warn("Exception occured when email entered is : " + email +  " with messsage: " + e.getMessage());
			driver = new Driver();
			driver.setDriverId(-1);
		}
		return driver;
	}
	
	/**
	 * Searches for a current Booking for the driver who is logged in
	 * @param driverId
	 * id of the driver who is logged in
	 * @return
	 * customer details who is alloted to the logged in driver
	 * @throws NoBookingFoundException 
	 * if there's no booking for the driver with the given driverId
	 */
	@Override
	public Customer searchForBooking(int driverId) throws NoBookingFoundException{
		Customer customer = null;
		Booking booking = mgr.createNamedQuery("searchBookingDetails", Booking.class).setParameter("driverId", driverId).getSingleResult();
		if(booking != null) {
			try {
				customer = mgr.createNamedQuery("getCustomerById", Customer.class).setParameter("customerId", booking.getCustomerId()).getSingleResult();
			} catch (Exception e) {
				myLogger.warn("No bookings for driver Id: " + driverId + " Exception thrown: " + e.getMessage() );
				throw new NoBookingFoundException("No bookings found for Id: " + driverId);
			}
		}
		return customer;
	}
	
	/**
	 * Gets booking details for a particular driver
	 * @param driverId
	 * id of the driver whose booking details are to be fetched
	 * @return
	 * confirmed booking details for the driver
	 * @throws NoBookingFoundException 
	 * if there's no booking for the driver with the given driverId
	 */
	@Override
	public Booking getBookingDetailsForADriver(int driverId) throws NoBookingFoundException{
		Booking booking =  null;
		try {
			booking = mgr.createNamedQuery("searchBookingDetails", Booking.class).setParameter("driverId", driverId).getSingleResult();
		} catch (Exception e) {
			myLogger.warn("No bookings for driver Id: " + driverId + " Exception thrown: " + e.getMessage() );			
			throw new NoBookingFoundException("No bookings found for Id: " + driverId);
		}
		return booking;
	}

}
