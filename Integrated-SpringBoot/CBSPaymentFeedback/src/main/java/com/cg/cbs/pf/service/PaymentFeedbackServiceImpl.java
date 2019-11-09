package com.cg.cbs.pf.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.cbs.pf.dao.CustomerWalletDao;
import com.cg.cbs.pf.dao.FeedbackDao;
import com.cg.cbs.pf.dao.PaymentDao;
import com.cg.cbs.pf.dto.Booking;
import com.cg.cbs.pf.dto.Customer;
import com.cg.cbs.pf.dto.Payment;
import com.cg.cbs.pf.dto.Report;
import com.cg.cbs.pf.exception.InsufficientWalletBalanceException;
import com.cg.cbs.pf.exception.InvalidDetailsException;

@Service
@Transactional(rollbackFor = {InvalidDetailsException.class, InsufficientWalletBalanceException.class})
public class PaymentFeedbackServiceImpl implements PaymentFeedbackService {

	@Autowired
	private PaymentDao pdao;
	@Autowired
	private FeedbackDao fdao;
	@Autowired
	private CustomerWalletDao cdao;
	 
	@Override
	public Payment addPayment(Booking booking) throws InsufficientWalletBalanceException, InvalidDetailsException {
   		updateCustomer(booking);
		return pdao.add(booking);
	}
	
	@Override
	public Report updateReport(Booking booking) {
		return fdao.update(booking);
	}

	@Override
	public Customer updateCustomer(Booking booking) throws InvalidDetailsException, InsufficientWalletBalanceException {
		return cdao.updateCustWallet(booking);
	}

	@Override
	public Customer findCustomer(Booking booking) throws InvalidDetailsException {
		int id = booking.getCustomerId();
		return pdao.findCustById(id);
	}

}
