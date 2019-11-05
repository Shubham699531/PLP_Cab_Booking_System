package com.cg.cbs.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.cbs.dto.Location;
import com.cg.cbs.dto.Pricing;
import com.cg.cbs.dao.EstimateDistanceDao;
import com.cg.cbs.dao.EstimatePriceDao;
import com.cg.cbs.dao.TripDetailsDao;
import com.cg.cbs.dto.TripDetails;

@Service
@Transactional
public class TripServiceImpl implements TripService{

	@Autowired
	TripDetailsDao tripDao;
	
	@Autowired
	EstimateDistanceDao distanceDao;
	
	@Autowired
	EstimatePriceDao priceDao;
	
	
	@Override
	public TripDetails saveTripDetails(TripDetails details) {
		return tripDao.saveTripDetails(details);
	}

	@Override
	public double estimatePrice(TripDetails details) {
		double fare=0.0;
		double distance = 0;
		
		List<Location> journey = distanceDao.estimateDistance(details);
		Location source = journey.get(0);
		Location destination = journey.get(1);
		
		Pricing pricing = priceDao.estimatePrice(details);
		
		distance = Math.sqrt(Math.pow(source.getxCoordinate()- destination.getxCoordinate(),2)+Math.pow(source.getyCoordinate()- destination.getyCoordinate(),2));
		fare = pricing.getBasePrice() + (distance-1.5)*pricing.getRatePerKm();
		return fare;
		
	}

	@Override
	public List<String> getLocations() {
		return distanceDao.listOfLocations();
	}
	
	

}
