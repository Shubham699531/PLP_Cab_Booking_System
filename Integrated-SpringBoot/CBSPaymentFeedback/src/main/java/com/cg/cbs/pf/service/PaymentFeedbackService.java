package com.cg.cbs.pf.service;

import com.cg.cbs.pf.dto.Booking;
import com.cg.cbs.pf.dto.Customer;
import com.cg.cbs.pf.dto.Payment;
import com.cg.cbs.pf.dto.Report;
import com.cg.cbs.pf.exception.InsufficientWalletBalanceException;
import com.cg.cbs.pf.exception.InvalidDetailsException;

/**
 * This is the service interface for payments and feedback updation.
 * @author Anchita Roy
 * @version 1.0
 *
 */

public interface PaymentFeedbackService {

	/**
	 * This method delegates the call to dao layer for payments record updation.
	 * @param booking
	 * @return
	 * @throws InsufficientWalletBalanceException
	 * @throws InvalidDetailsException
	 */
	Payment addPayment (Booking booking) throws InsufficientWalletBalanceException, InvalidDetailsException;
	
	/**
	 * This method delegates the call to dao layer for feedback-issues updation.
	 * @param booking
	 * @return
	 */
	Report updateReport(Booking booking);
	
	/**
	 * This method delegates the call to dao layer for customer wallet updation.
	 * @param booking
	 * @return
	 * @throws InvalidDetailsException
	 * @throws InsufficientWalletBalanceException
	 */
	Customer updateCustomer(Booking booking) throws InvalidDetailsException, InsufficientWalletBalanceException;
	
	/**
	 * Thsi method delegates the call to dao layer for fetching appropriate customer details.
	 * @param booking
	 * @return
	 * @throws InvalidDetailsException
	 */
	Customer findCustomer(Booking booking) throws InvalidDetailsException;
	
}
