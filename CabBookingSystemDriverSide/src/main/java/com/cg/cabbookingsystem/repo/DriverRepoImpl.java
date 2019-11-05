package com.cg.cabbookingsystem.repo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cg.cabbookingsystem.dto.Booking;
import com.cg.cabbookingsystem.dto.Driver;
import com.cg.cabbookingsystem.dto.Vehicle;

@Repository
public class DriverRepoImpl implements DriverRepo {
	private EntityManager mgr;
	@Autowired
	public DriverRepoImpl(EntityManager mgr) {
		this.mgr = mgr;
	}
	
	@Override
	public Driver getListOfDrivers(List<Vehicle> vehicles) {
		List<Driver> drivers = new ArrayList<Driver>();
		Driver driver = new Driver();
		for (Vehicle vehicle : vehicles) {
			drivers.add(mgr.find(Driver.class, vehicle.getVehicleNo()));
		}
		driver = drivers.get(1);
		driver.setDriverStatus("Booked");
		return driver;
	}

	@Override
	public Booking showBookingDetails(Booking booking) {
		mgr.persist(booking);
		return booking;
	}

	@Override
	public List<Booking> getAllTripsOfADriver(int driverId) {
		return mgr.createNamedQuery("getPastRidesOfDriver").setParameter("driverId", driverId).getResultList();
	}
	

}
