package com.cg.cbs.pf.web;

/**
 * This is the micro-service controller class for handling http requests.
 * @author Anchita Roy
 * @version 1.0
 */

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.cbs.pf.dto.Booking;
import com.cg.cbs.pf.dto.Customer;
import com.cg.cbs.pf.dto.Payment;
import com.cg.cbs.pf.dto.Report;
import com.cg.cbs.pf.exception.InsufficientWalletBalanceException;
import com.cg.cbs.pf.exception.InvalidDetailsException;
import com.cg.cbs.pf.service.PaymentFeedbackService;
import com.cg.cbs.pf.service.PaymentFeedbackServiceImpl;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/paymentsfeedback")
public class PaymentsFeedbackController {

	@Autowired
	private PaymentFeedbackService service;
	
	static Logger controllerLogger = Logger.getLogger(PaymentsFeedbackController.class);
	
	/**
	 * This controller method saves new payment records.
	 * @param booking
	 * @return
	 * @throws InsufficientWalletBalanceException
	 * @throws InvalidDetailsException
	 */
	@PostMapping(value="/payment", produces = "application/json", consumes = "application/json")
	public Payment addPayment(@RequestBody Booking booking) throws InsufficientWalletBalanceException, InvalidDetailsException {
		controllerLogger.info("To call payments updation method.");
		return service.addPayment(booking);
	}
	
	/**
	 * This controller method saves customer feedback inputs.
	 * @param booking
	 * @return
	 */
	@PostMapping(value = "/updateFeedback", produces = "application/json", consumes = "application/json")
	public Report updateReport(@RequestBody Booking booking) {
		controllerLogger.info("To call feedback updation method.");
		return service.updateReport(booking);
	}
	
	/**
	 * This controller method searches for corresponding customer from the booking details received.
	 * @param booking
	 * @return
	 * @throws InvalidDetailsException
	 */
	@PostMapping(value = "/findCustomer", produces = "application/json", consumes = "application/json")
	public Customer findCustomer(@RequestBody Booking booking) throws InvalidDetailsException {
		controllerLogger.info("To call customer fetching method.");
		return service.findCustomer(booking);
	}
	
}
