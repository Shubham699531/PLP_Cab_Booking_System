package com.cg.cbs.pf.dao;

/**
 * This is the dao layer implementation class for payments updation.
 * @author Anchita Roy
 * @version 1.0
 */

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cg.cbs.pf.dto.Booking;
import com.cg.cbs.pf.dto.Customer;
import com.cg.cbs.pf.dto.Payment;
import com.cg.cbs.pf.exception.InsufficientWalletBalanceException;
import com.cg.cbs.pf.exception.InvalidDetailsException;

@Repository
public class PaymentDaoImpl implements PaymentDao {

	@Autowired
	private EntityManager mgr;
	
	static Logger daoLogger = Logger.getLogger(PaymentDaoImpl.class);

	@Override
	public Payment add(Booking booking) throws InsufficientWalletBalanceException, InvalidDetailsException {
		Payment payment = new Payment();

		int pCustId = booking.getCustomerId();
		int pDriverId = booking.getDriverId();
		int pBookingId = booking.getBookingId();
		double pFinalFare = booking.getFinalFare();
	
		payment.setCustomerId(pCustId);
		payment.setDriverId(pDriverId);
		payment.setBookingId(pBookingId);
		payment.setFinalFare(pFinalFare);
		
		mgr.persist(payment);
		daoLogger.info("Transaction successfully updated to Payments.");
		return payment;
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
