package com.cg.cbs.pf.dao;

import javax.persistence.EntityManager;

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

	@Override
	public Payment add(Booking booking) throws InsufficientWalletBalanceException, InvalidDetailsException {
		Payment payment = new Payment();
//		TripDetails tripDetails = new TripDetails();
		
		int pCustId = booking.getCustomerId();
		int pDriverId = booking.getDriverId();
		int pBookingId = booking.getBookingId();
		double pFinalFare = booking.getFinalFare();
	
		payment.setCustomerId(pCustId);
		payment.setDriverId(pDriverId);
		payment.setBookingId(pBookingId);
		payment.setFinalFare(pFinalFare);
		
//		tripDetails.setCustomerId(pCustId);
//		tripDetails.setDriverId(pDriverId);
//		tripDetails.setBookingId(pBookingId);
//		tripDetails.setFinalFare(pFinalFare);
//		mgr.persist(tripDetails);
		
		mgr.persist(payment);
		return payment;
	}

	@Override
	public Customer findCustById(int id) throws InvalidDetailsException {
		Customer customer = (Customer) mgr.find(Customer.class, id);
		if (customer == null)
			throw new InvalidDetailsException("Invalid customer ID passed: " + id);
		return customer;
	}
	
}
