package com.cg.cbs.dao;

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cg.cbs.dto.Location;
import com.cg.cbs.dto.Pricing;
import com.cg.cbs.dto.CustomerRequest;
/**
 * Dao class for fetching pricing details from the Pricing Entity.
 * @author Akash
 *
 */
@Repository
public class EstimatePriceDaoImpl implements EstimatePriceDao{
	
	static Logger log = Logger.getLogger(EstimatePriceDaoImpl.class);
			
	@Autowired
	EntityManager mgr;
	
	@Override
	public Pricing estimatePrice(CustomerRequest details) {
		Pricing pricing = mgr.createNamedQuery("getPrice", Pricing.class).setParameter("model", details.getModel()).getSingleResult();
		log.info("pricing details of passed customer request");
		return pricing;
	}
	
	
}
