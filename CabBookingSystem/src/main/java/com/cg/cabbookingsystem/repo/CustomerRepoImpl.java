package com.cg.cabbookingsystem.repo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.cg.cabbookingsystem.dto.Booking;
import com.cg.cabbookingsystem.dto.CustomerRequirement;
import com.cg.cabbookingsystem.dto.Location;
import com.cg.cabbookingsystem.dto.Vehicle;

@Repository
public class CustomerRepoImpl implements CustomerRepo {

	@PersistenceContext
	EntityManager mgr;
	
	@Override
	public List<Vehicle> getVehicles(CustomerRequirement req) {
		List<Vehicle> vehicles =  mgr.createNamedQuery("fetchBySize", Vehicle.class).setParameter("size", req.getVehicleSize()).getResultList();
		Location location;
		Location source;
		List<Vehicle> nearByVehicles = new ArrayList<Vehicle>();
		for (Vehicle vehicle : vehicles) {
			source = mgr.createNamedQuery("fetchByName", Location.class).setParameter("name", req.getSource()).getSingleResult();
			location = mgr.createNamedQuery("fetchByName", Location.class).setParameter("name", vehicle.getLocation()).getSingleResult();
			double distance = Math.hypot((source.getxCoordinate()-location.getxCoordinate()), (source.getyCoordinate()-location.getyCoordinate()));
			if(distance <= 5)
				nearByVehicles.add(vehicle);
		}
		return nearByVehicles;
	}

	@Override
	public Booking bookACab(Booking booking) {
		/*
		 * Booking booking = new Booking(); booking.setCustomerId(customerId);
		 * booking.setCustomerStatus("confirmed");
		 * booking.setDestination(req.getDestination());
		 * booking.setSource(req.getSource()); booking.setDriverId(driverId);
		 * booking.setDriverStatus("confirmed");
		 * booking.setVehicleSize(req.getVehicleSize());
		 */
		mgr.persist(booking);
		
		return booking;
	}

	@Override
	public List<Vehicle> getAllVehicles() {
		return mgr.createNamedQuery("fetchAll", Vehicle.class).getResultList();
	}
	
	

}
