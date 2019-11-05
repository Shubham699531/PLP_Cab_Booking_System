package com.cg.cabbookingapplication.dao;



import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

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



	@Override
	public Driver findDriver(String email, String password){
		Driver driver = null;
		try {
			driver = mgr.createNamedQuery("byCredential",Driver.class).setParameter("email", email)
					.setParameter("password", password).getSingleResult();
		} catch (NoResultException e) {
			System.out.println("Invalid Login Credentials");
		}
			return driver;
	}

	@Override
	public Customer findCustomer(String email, String password){
		Customer customer = null;

		try {
			customer = (Customer) mgr.createNamedQuery("byCustomerCredential",Customer.class).setParameter("email", email)
					.setParameter("password", password).getSingleResult();
		} catch (NoResultException e) {
			System.out.println("Invalid Login Credentials");
		}
		
			return customer;
	}

	/*
	 * @Override public Login find(String userId) throws InvalidLoginDetails { Login
	 * login = mgr.find(Login.class, userId); if (login == null) throw new
	 * InvalidLoginDetails("Invalid login details provided"); else return login; }
	 */

}
