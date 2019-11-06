package com.cg.cabbookingsystem.repo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import org.hibernate.NonUniqueResultException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cg.cabbookingsystem.dto.Booking;
import com.cg.cabbookingsystem.dto.DriverModel;
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
	public DriverModel save(DriverModel driver) {
		mgr.persist(driver);
		return driver;
	}
	@Override
	public DriverModel getListOfDrivers(List<Vehicle> vehicles) {
		List<DriverModel> drivers = new ArrayList<DriverModel>();
		DriverModel driver = new DriverModel();
		for (Vehicle vehicle : vehicles) {
			drivers.add(mgr.find(DriverModel.class, vehicle.getVehicleNo()));
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
	public DriverModel validateLogin(User user) {
		DriverModel driver = null;
		try {
			 driver = mgr.createNamedQuery("validateLogin",DriverModel.class).setParameter("email", user.getEmail()).setParameter("password", user.getPassword()).getSingleResult();
		} catch (Exception e ) {
			driver = new DriverModel();
			driver.setDriverId(-1);
		}
		return driver;
	}
	
	@Override
	public DriverModel fetchByEmail(String email) {
		DriverModel driver = null;
		try {
			driver =  mgr.createNamedQuery("fetchByEmail", DriverModel.class).setParameter("email", email).getSingleResult();
		} catch (Exception e) {
			driver = new DriverModel();
			driver.setDriverId(-1);
		}
		return driver;
	}
	

}
