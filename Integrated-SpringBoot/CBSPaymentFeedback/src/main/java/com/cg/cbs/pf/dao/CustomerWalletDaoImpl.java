package com.cg.cbs.pf.dao;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cg.cbs.pf.dto.Booking;
import com.cg.cbs.pf.dto.Customer;
import com.cg.cbs.pf.exception.InsufficientWalletBalanceException;
import com.cg.cbs.pf.exception.InvalidDetailsException;

@Repository
public class CustomerWalletDaoImpl implements CustomerWalletDao {

	@Autowired
	private EntityManager mgr;

	Customer customer = new Customer();

	@Override
	public Customer updateCustWallet(Booking booking) throws InvalidDetailsException, InsufficientWalletBalanceException {
		customer = findCustById(booking.getCustomerId());

		double wallet = customer.getWallet();
		double finalFare = booking.getFinalFare();
		double newWallet = wallet - finalFare;
		if (newWallet >= 0)
			customer.setWallet(newWallet);
		else
			throw new InsufficientWalletBalanceException("Insufficient wallet balance for customer: " + booking.getCustomerId());
		mgr.merge(customer);
		return customer;
	}

	@Override
	public Customer findCustById(int id) throws InvalidDetailsException {
		Customer customer = (Customer) mgr.find(Customer.class, id);
		if (customer == null)
			throw new InvalidDetailsException("Invalid customer ID passed: " + id);
		return customer;
	}

}
