package com.cg.cbs.pf.dao;

/**
 * This the interface for customer wallet updation class.
 * @author Anchita Roy
 * @version 1.0
 */

import com.cg.cbs.pf.dto.Booking;
import com.cg.cbs.pf.dto.Customer;
import com.cg.cbs.pf.exception.InsufficientWalletBalanceException;
import com.cg.cbs.pf.exception.InvalidDetailsException;

public interface CustomerWalletDao {

	/**
	 * This method checks the customer's wallet balance, if insufficient amount is present then it adds required amount and proceeds for payment completion.
	 * @param booking
	 * @return
	 * @throws InvalidDetailsException
	 * @throws InsufficientWalletBalanceException
	 */
	Customer updateCustWallet(Booking booking) throws InvalidDetailsException, InsufficientWalletBalanceException;
	
	/**
	 * This method searches for the corresponding customer from the booking details received.
	 * @param id
	 * @return
	 * @throws InvalidDetailsException
	 */
	Customer findCustById(int id) throws InvalidDetailsException;
	
}