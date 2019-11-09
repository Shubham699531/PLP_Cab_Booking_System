package com.cg.cbs.pf.service;

import com.cg.cbs.pf.dto.Booking;
import com.cg.cbs.pf.dto.Customer;
import com.cg.cbs.pf.dto.Payment;
import com.cg.cbs.pf.dto.Report;
import com.cg.cbs.pf.exception.InsufficientWalletBalanceException;
import com.cg.cbs.pf.exception.InvalidDetailsException;

public interface PaymentFeedbackService {

	Payment addPayment (Booking booking) throws InsufficientWalletBalanceException, InvalidDetailsException;
	
	Report updateReport(Booking booking);
	
	Customer updateCustomer(Booking booking) throws InvalidDetailsException, InsufficientWalletBalanceException;
	
	Customer findCustomer(Booking booking) throws InvalidDetailsException;
	
}
