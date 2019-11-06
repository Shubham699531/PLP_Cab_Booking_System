package com.cg.cbs.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cg.cbs.dto.Location;
import com.cg.cbs.dto.CustomerRequest;
/**
 * Dao class containing two methods for fetching location details of source and destination
 * and fetching all locations names.
 * @author Akash
 *
 */
@Repository
public class GetLocataionDaoImpl implements GetLocationDao{

	@Autowired
	EntityManager mgr;
	
	/**
	 * This method fetches the Location Details of source and destination 
	 * given in the Trip Details from Location Entity.
	 * @param CustomerRequest
	 * @return List<Location> It returns list of Location objects
	 */
	@Override
	public List<Location> getLocationDetails(CustomerRequest details) {
		List<Location> journey = new ArrayList<Location>();
		Location source = mgr.createNamedQuery("getCoordinates",Location.class).setParameter(1, details.getSource()).getSingleResult();
		Location destination = mgr.createNamedQuery("getCoordinates", Location.class).setParameter(1, details.getDestination()).getSingleResult();
		
		journey.add(source);
		journey.add(destination);
		
		return journey;
	}

	/**
	 * This method fetches all location names from location Entity
	 * @param 
	 * @return List<String> List of Location Names
	 */
	@Override
	public List<String> listOfLocations() {
		List<Location> locationsDetails = mgr.createNamedQuery("getLocations", Location.class).getResultList();
		List<String> locations = new ArrayList<String>();
		for(Location location: locationsDetails)
			locations.add(location.getLocation());
		return locations;
	}

}
