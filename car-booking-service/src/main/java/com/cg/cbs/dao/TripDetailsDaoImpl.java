package com.cg.cbs.dao;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cg.cbs.dto.TripDetails;

@Repository
public class TripDetailsDaoImpl implements TripDetailsDao{

	@Autowired
	EntityManager mgr;
	
	@Override
	public TripDetails saveTripDetails(TripDetails details) {
		mgr.persist(details);
		return details;
	}

}
