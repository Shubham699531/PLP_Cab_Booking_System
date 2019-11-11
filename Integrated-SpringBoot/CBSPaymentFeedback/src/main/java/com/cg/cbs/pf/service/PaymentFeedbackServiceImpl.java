package com.cg.cbs.pf.service;

import java.util.List;

import org.apache.log4j.Logger;
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

/**
 * This is the service layer implementation class for delegating the various method calls to dao layer.
 * @author Anchita Roy
 * @version 1.0
 *
 */

@Service
@Transactional(rollbackFor = {InvalidDetailsException.class, InsufficientWalletBalanceException.class})
public class PaymentFeedbackServiceImpl implements PaymentFeedbackService {

	@Autowired
	private PaymentDao pdao;
	@Autowired
	private FeedbackDao fdao;
	@Autowired
	private CustomerWalletDao cdao;
	
	static Logger serviceLogger = Logger.getLogger(PaymentFeedbackServiceImpl.class);
	 
	@Override
	public Payment addPayment(Booking booking) throws InsufficientWalletBalanceException, InvalidDetailsException {
   		serviceLogger.info("To initiate a new payment transaction from service.");
		updateCustomer(booking);
		return pdao.add(booking);
	}
	
	@Override
	public Report updateReport(Booking booking) {
		serviceLogger.info("To initiate a new feedback updation from service.");
		return fdao.update(booking);
	}

	@Override
	public Customer updateCustomer(Booking booking) throws InvalidDetailsException, InsufficientWalletBalanceException {
		serviceLogger.info("To start customer wallet updation from service.");
		return cdao.updateCustWallet(booking);
	}

	@Override
	public Customer findCustomer(Booking booking) throws InvalidDetailsException {
		serviceLogger.info("To initiate a search for corresponding customer from service.");
		int id = booking.getCustomerId();
		return pdao.findCustById(id);
	}

}
