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
	
	CustomerRequest saveCustomerRequest(CustomerRequest details);
	double estimatePrice(CustomerRequest details);
	List<String> getLocations();

}
