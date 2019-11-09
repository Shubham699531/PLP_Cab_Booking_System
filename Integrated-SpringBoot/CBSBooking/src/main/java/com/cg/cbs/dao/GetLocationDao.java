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

	public List<Location> getLocationDetails(CustomerRequest details);
	List<String> listOfLocations();
}
