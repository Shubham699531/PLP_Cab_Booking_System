package com.cg.cabbookingsystem.repo;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cg.cabbookingsystem.dto.Location;
import com.cg.cabbookingsystem.dto.Vehicle;

@Repository
public class CustomerRepoImpl implements CustomerRepo{

	@Autowired
	EntityManager mgr;
	
	@Override
	public List<Vehicle> getVehicleNumbers(String source, String cabSize, int size) {
		return mgr.createNamedQuery("getVehicles").setParameter("sizeOfCab", size).setParameter("model", cabSize).setParameter("location", source).getResultList();
	}

	@Override
	public double calculateDistance(String source, String destination) {
		Location src = (Location) mgr.createNamedQuery("getLocation").setParameter("name", source).getSingleResult();
		Location dest = (Location) mgr.createNamedQuery("getLocation").setParameter("name", destination).getSingleResult();
		return Math.sqrt((dest.getyCoordinate() - src.getyCoordinate()) * (dest.getyCoordinate() - src.getyCoordinate()) + (dest.getxCoordinate() - src.getxCoordinate()) * (dest.getxCoordinate() - src.getxCoordinate()));
	}

}
