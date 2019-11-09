package com.cg.cbs.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.cbs.dto.Location;
import com.cg.cbs.dto.Pricing;
import com.cg.cbs.dao.GetLocationDao;
import com.cg.cbs.dao.EstimatePriceDao;
import com.cg.cbs.dao.TripDetailsDao;
import com.cg.cbs.dto.CustomerRequest;
/**
 * Service Implementation for fetching location details 
 * and calculating fare.
 * @author Akash
 *
 */
@Service
@Transactional
public class TripServiceImpl implements TripService{

	@Autowired
	TripDetailsDao tripDao;
	
	@Autowired
	GetLocationDao locationDao;
	
	@Autowired
	EstimatePriceDao priceDao;
	
	/**
	 * This method delegates call to Dao class for persisting the specified Trip Details
	 * @param TripDetails. 
	 * @return TripDetails. It returns the persisted trip details 
	 */
	@Override
	public CustomerRequest saveCustomerRequest(CustomerRequest details) {
		return tripDao.saveTripDetails(details);
	}

	/**
	 * This method delegates call to  LocationDao classe for fetchig the Location
	 * details of source and destination (for calculating distance between them).
	 * It also delegates call to EstimatePrice Dao class for fetching pricing details 
	 * 
	 * @param Trip Details.
	 * @return Double (fare) It returns an estimated fare for the specified trip.
	 */
	@Override
	public double estimatePrice(CustomerRequest details) {
		double fare=0.0;
		double distance = 0;
		
		//Getting Locations Details of Source and Destination
		List<Location> journey = locationDao.getLocationDetails(details);
		Location source = journey.get(0);
		Location destination = journey.get(1);
		
		//Getting pricing details of given car model
		Pricing pricing = priceDao.estimatePrice(details);
		
		//Distance Calculation Logic
		distance = Math.sqrt(Math.pow(source.getxCoordinate()- destination.getxCoordinate(),2)+Math.pow(source.getyCoordinate()- destination.getyCoordinate(),2));
		
		//Fare Calculation Logic
		fare = pricing.getBasePrice() + (distance-1.5)*pricing.getRatePerKM();
		
		String fareString = String.format("%.2f", fare);
		fare = Double.parseDouble(fareString);
		return fare;
		
	}
	
	/**
	 * This method delegates call to dao class for fetching all locations.
	 * @return List<String>   List of all locations
	 */
	@Override
	public List<String> getLocations() {
		return locationDao.listOfLocations();
	}
	
	

}
