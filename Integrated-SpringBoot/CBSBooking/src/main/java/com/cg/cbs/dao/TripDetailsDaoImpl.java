package com.cg.cbs.dao;

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;
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

	//logger
	static Logger log = Logger.getLogger(TripDetailsDaoImpl.class);
			
	@Autowired
	EntityManager mgr;
	
	/**
	 * Dao Implementaion for persisting CustomerRequest entity 
	 * @param CustomerRequest
	 * @return CustomerRequest
	 */
	@Override
	public CustomerRequest saveTripDetails(CustomerRequest details) {
		log.info("persisting Customer Request object in sql database");
		mgr.persist(details);
		return details;
	}

}
