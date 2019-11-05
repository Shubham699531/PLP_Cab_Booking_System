package com.cg.cabbookingsystem.repo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import org.hibernate.NonUniqueResultException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cg.cabbookingsystem.dto.Booking;
import com.cg.cabbookingsystem.dto.Driver;
import com.cg.cabbookingsystem.dto.User;
import com.cg.cabbookingsystem.dto.Vehicle;
import com.cg.cabbookingsystem.exception.InvalidLoginException;

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

	@Override
	public Driver validateLogin(User user) {
		Driver driver = null;
		try {
			 driver = mgr.createNamedQuery("validateLogin",Driver.class).setParameter("email", user.getEmail()).setParameter("password", user.getPassword()).getSingleResult();
		} catch (Exception e ) {
			driver = new Driver();
			driver.setDriverId(-1);
		}
		return driver;
	}
	

}
