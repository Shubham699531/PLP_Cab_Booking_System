package com.cg.cbs.pf.dao;

/**
 * This is the dao layer implementation class for customer wallet updation.
 * @author Anchita Roy
 * @version 1.0
 */

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cg.cbs.pf.dto.Booking;
import com.cg.cbs.pf.dto.Customer;
import com.cg.cbs.pf.exception.InsufficientWalletBalanceException;
import com.cg.cbs.pf.exception.InvalidDetailsException;
import com.cg.cbs.pf.service.PaymentFeedbackServiceImpl;

@Repository
public class CustomerWalletDaoImpl implements CustomerWalletDao {

	@Autowired
	private EntityManager mgr;

	Customer customer = new Customer();
	
	static Logger daoLogger = Logger.getLogger(CustomerWalletDaoImpl.class);

	@Override
	public Customer updateCustWallet(Booking booking) throws InvalidDetailsException, InsufficientWalletBalanceException {
		customer = findCustById(booking.getCustomerId());

		double wallet = customer.getWallet();
		double finalFare = booking.getFinalFare();
		double newWallet = wallet - finalFare;
		if (newWallet >= 0) {
			daoLogger.info("Customer wallet balance successfully updated.");
			customer.setWallet(newWallet);
		}
		else {
			daoLogger.error("Insufficient wallet balance... add and proceed to pay.");
			throw new InsufficientWalletBalanceException("Insufficient wallet balance for customer: " + booking.getCustomerId());
		}
		mgr.merge(customer);
		return customer;
	}

	@Override
	public Customer findCustById(int id) throws InvalidDetailsException {
		Customer customer = (Customer) mgr.find(Customer.class, id);
		if (customer == null) {
			daoLogger.error("Customer not found with these booking details.");
			throw new InvalidDetailsException("Invalid customer ID passed: " + id);
		}
		daoLogger.info("Customer successfully found.");
		return customer;
	}

}
