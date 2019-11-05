package com.cg.cbs.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cg.cbs.dto.Location;
import com.cg.cbs.dto.TripDetails;

@Repository
public class EstimateDistanceDaoImpl implements EstimateDistanceDao{

	@Autowired
	EntityManager mgr;
	
	@Override
	public List<Location> estimateDistance(TripDetails details) {
		List<Location> journey = new ArrayList<Location>();
		Location source = mgr.createNamedQuery("getCoordinates",Location.class).setParameter(1, details.getSource()).getSingleResult();
		Location destination = mgr.createNamedQuery("getCoordinates", Location.class).setParameter(1, details.getDestination()).getSingleResult();
		
		journey.add(source);
		journey.add(destination);
		
		return journey;
	}

	@Override
	public List<String> listOfLocations() {
		List<Location> locationsDetails = mgr.createNamedQuery("getLocations", Location.class).getResultList();
		List<String> locations = new ArrayList<String>();
		for(Location location: locationsDetails)
			locations.add(location.getLocation());
		return locations;
	}

}
