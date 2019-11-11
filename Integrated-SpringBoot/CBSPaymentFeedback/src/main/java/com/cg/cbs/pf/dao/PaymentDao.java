package com.cg.cbs.pf.dao;

/**
 * This is the interface for Payments updation class.
 * @author Anchita Roy
 * @version 1.0
 */

import java.util.List;

import com.cg.cbs.pf.dto.Booking;
import com.cg.cbs.pf.dto.Customer;
import com.cg.cbs.pf.dto.Payment;
import com.cg.cbs.pf.exception.InsufficientWalletBalanceException;
import com.cg.cbs.pf.exception.InvalidDetailsException;

public interface PaymentDao{

	/**
	 * It updates the payments table for each transaction.
	 * @param booking
	 * @return
	 * @throws InsufficientWalletBalanceException
	 * @throws InvalidDetailsException
	 */
	Payment add(Booking booking) throws InsufficientWalletBalanceException, InvalidDetailsException;

	/**
	 * This method searches for the corresponding customer from the booking details received.
	 * @param id
	 * @return
	 * @throws InvalidDetailsException
	 */
	Customer findCustById(int id) throws InvalidDetailsException;

}
