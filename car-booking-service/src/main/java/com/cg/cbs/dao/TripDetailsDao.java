package com.cg.cbs.dao;

import com.cg.cbs.dto.CustomerRequest;
/**
 * Dao Interface containing abstract method for saving trip details
 * @author Akash
 *
 */
public interface TripDetailsDao {
	
	CustomerRequest saveTripDetails(CustomerRequest details);


}
