package com.cg.cab.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.cg.cab.dto.Customer;
import com.cg.cab.dto.Driver;
import com.cg.cab.dto.User;
import com.cg.cab.dto.Vehicle;
import com.cg.cab.exception.UserNotFoundException;


@Repository
public class CabDaoImpl implements ICabDao {
	
	static Logger myLogger =  Logger.getLogger(CabDaoImpl.class);

	
	@PersistenceContext
	EntityManager mgr;

	@Override
	public Driver validateLoginDriver(User user) throws UserNotFoundException {
		myLogger.info("<<Driver validation >>");
		Driver driver = null;
		try {
			 driver = mgr.createNamedQuery("validateLogin",Driver.class).setParameter("email", user.getEmail()).setParameter("password", user.getPassword()).getSingleResult();
			 
			 myLogger.info("Driver found");
		} catch (Exception e ) {
			myLogger.error("Driver not found");
			driver = new Driver();
			driver.setDriverId(-1);
			throw new UserNotFoundException("Invalid Login Credentials");
		}
		return driver;
	}

	@Override
	public Driver saveDriver(Driver driver) {
		myLogger.info("<<Sign-up of new Driver>>");

		mgr.persist(driver);
		myLogger.info("Driver Persisted");
		return driver;
	}

	@Override
	public Vehicle saveVehicle(Vehicle vehicle) {
		System.out.println(vehicle.getVehicleNo()+ vehicle.getSize()+vehicle.getStatus()+vehicle.getLocation());
//		if(vehicle.getModel().equals("mini")){
//			vehicle.setSize(1);
//		    }
//		    else if(vehicle.getModel().equals("micro")){
//		    	vehicle.setSize(2);
//		    }
//		    else if(vehicle.getModel().equals("sedan")){
//		    	vehicle.setSize(3);
//		    }
//		    else{
//		      vehicle.setSize(4);
//		    }
//		vehicle.setStatus("free");
		mgr.persist(vehicle);
		return vehicle;
	}

	@Override
	public Customer validateLoginCustomer(User user) throws UserNotFoundException {
		myLogger.info("<<Customer validation >>");
		Customer cust = new Customer();
		try {
			cust = mgr.createNamedQuery("fetchByEmail", Customer.class)
					.setParameter("email", user.getEmail()).getSingleResult();
			System.out.println("@@@@@@" + cust.getEmail());
			if (cust.getPassword().equals(user.getPassword())) {
				System.out.println("%%%%%%%%%%%" + cust.getCustomerId());
				return cust;
			}
			 myLogger.info("Customer found");
			 
		} catch (Exception e) {
			 myLogger.error("Customer not found");
			cust = null;
			throw new UserNotFoundException("Invalid Login Credentials");
		}
		cust = new Customer();
		cust.setCustomerId(-1);
		System.out.println(cust.getCustomerId() + "######");
		return cust;
	}

	@Override
	public Customer saveCustomer(Customer customer) {
		myLogger.info("<<Sign-up of new Customer dao>>");

		customer.setWallet(1000.0);
		myLogger.info("Setting wallet value as 1000");
		try {
			//System.out.println("*****" + customer.getEmail());
			
			mgr.persist(customer);
			myLogger.info("Customer Persisted");
		} catch (Exception e) {
			myLogger.error("Customer Persist Failed");
			customer = new Customer();
			customer.setCustomerId(-1);
			e.printStackTrace();
		}
		return customer;
	}

}
