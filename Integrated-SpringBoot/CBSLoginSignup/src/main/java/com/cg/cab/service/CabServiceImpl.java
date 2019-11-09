package com.cg.cab.service;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.cab.dao.CabDaoImpl;
import com.cg.cab.dao.ICabDao;
import com.cg.cab.dto.Customer;
import com.cg.cab.dto.Driver;
import com.cg.cab.dto.User;
import com.cg.cab.dto.Vehicle;
import com.cg.cab.exception.UserNotFoundException;


@Service
@Transactional
public class CabServiceImpl implements ICabService {
	
	static Logger myLogger =  Logger.getLogger(CabServiceImpl.class);

	
	private ICabDao dao;
	@Autowired
	public CabServiceImpl(ICabDao dao) {
		this.dao = dao;
	}

	@Override
	public Driver validateLoginDriver(User user) throws UserNotFoundException {
		myLogger.info("<<Driver validation service>>");
		return dao.validateLoginDriver(user);
	}

	@Override
	public Driver saveDriver(Driver driver) {
		myLogger.info("<<Sign-up of new Driver service>>");
		return dao.saveDriver(driver);
	}

	@Override
	public Vehicle saveVehicle(Vehicle vehicle) {
		
		return dao.saveVehicle(vehicle);
	}

	@Override
	public Customer validateLoginCustomer(User user) throws UserNotFoundException {
		myLogger.info("<<Customer validation service>>");
		return dao.validateLoginCustomer(user);
	}

	@Override
	public Customer saveCustomer(Customer customer) {
		myLogger.info("<<Sign-up of new Customer service>>");		
		return dao.saveCustomer(customer);
	}
}
