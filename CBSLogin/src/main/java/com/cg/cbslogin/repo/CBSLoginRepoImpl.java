package com.cg.cbslogin.repo;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.cg.cbslogin.dto.Customer;
import com.cg.cbslogin.dto.Driver;
import com.cg.cbslogin.dto.DriverSignupDetails;
import com.cg.cbslogin.dto.User;
import com.cg.cbslogin.dto.Vehicle;

@Repository
public class CBSLoginRepoImpl implements CBSLoginRepo {

	@PersistenceContext
	EntityManager mgr;

	@Override
	public Customer loginCustomer(User user) {
		Customer cust = new Customer();
		try {
			cust = mgr.createNamedQuery("fetchByEmail", Customer.class)
					.setParameter("email", user.getEmail()).getSingleResult();
			System.out.println("@@@@@@" + cust.getEmail());
			if (cust.getPassword().equalsIgnoreCase(user.getPassword()))
				return cust;
		} catch (Exception e) {
			cust = null;
		}
		cust = new Customer();
		cust.setId(-1);
		System.out.println(cust.getId() + "######");
		return cust;
	}

	@Override
	public Driver loginDriver(User user) {
		Driver driver = null;
		try {
			driver = mgr.createNamedQuery("fetchDriverByEmail", Driver.class).setParameter("email", user.getEmail())
					.getSingleResult();
		} catch (Exception e) {
			driver = null;
			e.printStackTrace();
		}
		driver = new Driver();
		driver.setId(-1);
		return driver;
	}

	@Override
	public Customer signupCustomer(Customer customer) {
		customer.setWallet(1000.0);
		try {
			//System.out.println("*****" + customer.getEmail());
			
			mgr.persist(customer);
		} catch (Exception e) {
			customer = new Customer();
			customer.setId(-1);
			e.printStackTrace();
		}
		return customer;
	}

	@Override
	public DriverSignupDetails signupDriver(DriverSignupDetails driverSignup) {

		Driver driver = driverSignup.getDriver();
		Vehicle vehicle = driverSignup.getVehicle();
		try {
			mgr.persist(driver);
			mgr.persist(vehicle);
		} catch (Exception e) {
			driver = new Driver();
			vehicle = new Vehicle();
			vehicle.setVehicleNo("");
			driver.setId(-1);
			driverSignup.setDriver(driver);
			driverSignup.setVehicle(vehicle);
			e.printStackTrace();
		}
		return driverSignup;
	}

}
