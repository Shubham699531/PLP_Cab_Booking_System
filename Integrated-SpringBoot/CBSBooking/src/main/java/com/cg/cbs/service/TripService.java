package com.cg.cbs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cg.cbs.dao.GetLocationDao;
import com.cg.cbs.dto.CustomerRequest;
/**
 * Service Interface defining methods for saving trip details,
 * fetching locations and calculating fare.
 * @author Akash
 *
 */
public interface TripService {
	
	/**
	 * This method delegates call to Dao class for persisting the specified Trip Details
	 * @param TripDetails. 
	 * @return TripDetails. It returns the persisted trip details 
	 */
	CustomerRequest saveCustomerRequest(CustomerRequest details);
	
	/**
	 * This method delegates call to  LocationDao class for fetching the Location
	 * details of source and destination (for calculating distance between them).
	 * It also delegates call to EstimatePrice Dao class for fetching pricing details 
	 * 
	 * @param Trip Details.
	 * @return Double (fare) It returns an estimated fare for the specified trip.
	 */
	double estimatePrice(CustomerRequest details);
	
	/**
	 * This method delegates call to dao class for fetching all locations.
	 * @return List<String>   List of all locations
	 */
	List<String> getLocations();

}
