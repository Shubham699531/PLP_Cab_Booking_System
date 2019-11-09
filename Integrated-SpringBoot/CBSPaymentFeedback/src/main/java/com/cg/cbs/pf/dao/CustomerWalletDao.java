package com.cg.cbs.pf.dao;

import com.cg.cbs.pf.dto.Booking;
import com.cg.cbs.pf.dto.Customer;
import com.cg.cbs.pf.exception.InsufficientWalletBalanceException;
import com.cg.cbs.pf.exception.InvalidDetailsException;

public interface CustomerWalletDao {

	Customer updateCustWallet(Booking booking) throws InvalidDetailsException, InsufficientWalletBalanceException;
	
	Customer findCustById(int id) throws InvalidDetailsException;
	
}