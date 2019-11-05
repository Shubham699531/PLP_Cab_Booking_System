package com.cg.cbs.dao;

import java.util.List;

import com.cg.cbs.dto.Location;
import com.cg.cbs.dto.TripDetails;

public interface EstimateDistanceDao {

	public List<Location> estimateDistance(TripDetails details);
	List<String> listOfLocations();
}
