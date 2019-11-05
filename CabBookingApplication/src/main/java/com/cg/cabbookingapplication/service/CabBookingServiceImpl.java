package com.cg.cabbookingapplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.cabbookingapplication.dao.CabBookingDao;
import com.cg.cabbookingapplication.dto.Customer;
import com.cg.cabbookingapplication.dto.Driver;
import com.cg.cabbookingapplication.exception.InvalidLoginDetails;

@Service
@Transactional(rollbackFor = InvalidLoginDetails.class)
public class CabBookingServiceImpl implements CabBookingService {

	@Autowired
	private CabBookingDao dao;

	@Override
	public Customer addCustomer(Customer customer) {

		return dao.add(customer);
	}

	@Override
	public Driver addDriver(Driver driver) {

		return dao.add(driver);
	}

	@Override
	public List<Customer> findCustomer(String email, String password) throws InvalidLoginDetails {

		return dao.findCustomer(email, password);
	}

	@Override
	public List<Driver> findDriver(String email, String password) throws InvalidLoginDetails {

		return dao.findDriver(email, password);
	}

}
