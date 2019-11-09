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

@Repository
public class DriverRepoImpl implements DriverRepo {
	private EntityManager mgr;
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
	 */
	@Override
	public List<Booking> getAllTripsOfADriver(int driverId) {
		return mgr.createNamedQuery("getPastRidesOfDriver",Booking.class).setParameter("driverId", driverId).getResultList();
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
	 */
	@Override
	public Customer searchForBooking(int driverId) {
		Booking booking = mgr.createNamedQuery("searchBookingDetails", Booking.class).setParameter("driverId", driverId).getSingleResult();
		if(booking != null) {
			return mgr.find(Customer.class, booking.getCustomerId()) ;
		}
		return null;
	}
	
	@Override
	public Booking getBookingDetailsForADriver(int driverId) {
		Booking booking = mgr.createNamedQuery("searchBookingDetails", Booking.class).setParameter("driverId", driverId).getSingleResult();
		return booking;
	}

}
