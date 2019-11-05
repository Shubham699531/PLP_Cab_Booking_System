package com.cg.cbs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cg.cbs.dao.EstimateDistanceDao;
import com.cg.cbs.dto.TripDetails;

public interface TripService {
	
	TripDetails saveTripDetails(TripDetails details);
	double estimatePrice(TripDetails details);
	List<String> getLocations();

}
