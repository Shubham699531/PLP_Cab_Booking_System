package com.cg.cbs.dao;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cg.cbs.dto.CustomerRequest;
/**
 * Dao class implementing methods for persisting trip details in Trip Details Entity
 * @author Akash
 *
 */
@Repository
public class TripDetailsDaoImpl implements TripDetailsDao{

	@Autowired
	EntityManager mgr;
	
	@Override
	public CustomerRequest saveTripDetails(CustomerRequest details) {
		mgr.persist(details);
		return details;
	}

}
