package com.cg.cbs.pf.dao;

import java.util.List;

import com.cg.cbs.pf.dto.Booking;
import com.cg.cbs.pf.dto.Customer;
import com.cg.cbs.pf.dto.Payment;
import com.cg.cbs.pf.exception.InsufficientWalletBalanceException;
import com.cg.cbs.pf.exception.InvalidDetailsException;

public interface PaymentDao{

	Payment add(Booking booking) throws InsufficientWalletBalanceException, InvalidDetailsException;

	Customer findCustById(int id) throws InvalidDetailsException;
	
//	Customer addWalletBalance(int balance)
	
//	Customer update(Customer customer);
}
