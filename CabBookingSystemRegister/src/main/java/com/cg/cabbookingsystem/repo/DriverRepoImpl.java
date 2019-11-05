package com.cg.cabbookingsystem.repo;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cg.cabbookingsystem.dto.DriverModel;

@Repository
public class DriverRepoImpl implements DriverRepo{
	
	@Autowired
	EntityManager mgr;

	@Override
	public DriverModel save(DriverModel driver) {
		mgr.persist(driver);
		return driver;
	}

	@Override
	public DriverModel fetchByEmail(String email) {
		return mgr.createNamedQuery("fetchByEmail", DriverModel.class).setParameter("email", email).getSingleResult();
	}

}
