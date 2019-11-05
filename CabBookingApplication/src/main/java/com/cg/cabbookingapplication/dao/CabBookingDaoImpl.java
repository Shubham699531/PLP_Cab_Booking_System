package com.cg.cabbookingapplication.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cg.cabbookingapplication.dto.Customer;
import com.cg.cabbookingapplication.dto.Driver;
import com.cg.cabbookingapplication.exception.InvalidLoginDetails;

@Repository
public class CabBookingDaoImpl implements CabBookingDao {

	@Autowired
	private EntityManager mgr;

	@Override
	public Customer add(Customer customer) {
		mgr.persist(customer);

		return customer;
	}

	@Override
	public Driver add(Driver driver) {
		mgr.persist(driver);
		return driver;
	}

	/*
	 * @Override public Customer findCustomer(String email) throws
	 * InvalidLoginDetails {
	 * 
	 * Customer customer = mgr.find(Customer.class, email); if (customer == null)
	 * throw new InvalidLoginDetails("Invalid login details provided"); else return
	 * customer;
	 * 
	 * 
	 * }
	 */

//	@Override
//	public Driver findDriver(String email) throws InvalidLoginDetails {
//		
//		Driver driver = mgr.find(Driver.class,email);
//		if (driver == null) 
//			throw new InvalidLoginDetails("Invalid login details provided");
//		else
//			return driver;
//			
//	}

	@Override
	public List<Driver> findDriver(String email, String password) throws InvalidLoginDetails {
		List<Driver> driver = mgr.createNamedQuery("byCredential").setParameter("email", email)
				.setParameter("password", password).getResultList();
		if (driver == null)
			throw new InvalidLoginDetails("Invalid login details provided");
		else
			return driver;
	}

	@Override
	public List<Customer> findCustomer(String email, String password) throws InvalidLoginDetails {

		List<Customer> customer = mgr.createNamedQuery("byCustomerCredential").setParameter("email", email)
				.setParameter("password", password).getResultList();
		if (customer == null)
			throw new InvalidLoginDetails("Invalid login details provided");
		else
			return customer;
	}

	/*
	 * @Override public Login find(String userId) throws InvalidLoginDetails { Login
	 * login = mgr.find(Login.class, userId); if (login == null) throw new
	 * InvalidLoginDetails("Invalid login details provided"); else return login; }
	 */

}
