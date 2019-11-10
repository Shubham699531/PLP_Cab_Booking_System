package com.cg.cbs.dao;

import java.util.List;

import com.cg.cbs.dto.Location;
import com.cg.cbs.dto.CustomerRequest;
/**
 * Dao Interface containing abstract methods for getting location details 
 * and list of location names.
 * @author Akash
 *
 */
public interface GetLocationDao {
	
	/**
	 * Method to fetch location details of source and destination
	 * of passed CustomerRequest Details 
	 * @param CustomerRequest
	 * @return
	 */
	public List<Location> getLocationDetails(CustomerRequest details);
	
	/**
	 * Method to list names of locations
	 * @return
	 */
	List<String> listOfLocations();
}
