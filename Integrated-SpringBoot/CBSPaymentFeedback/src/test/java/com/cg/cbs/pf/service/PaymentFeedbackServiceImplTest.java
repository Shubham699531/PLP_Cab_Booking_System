package com.cg.cbs.pf.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.cbs.pf.dto.Booking;
import com.cg.cbs.pf.exception.InsufficientWalletBalanceException;
import com.cg.cbs.pf.exception.InvalidDetailsException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PaymentFeedbackServiceImplTest {
	
	@Autowired
	private PaymentFeedbackService service;

	@Test
	public void testAddPayment() throws InsufficientWalletBalanceException, InvalidDetailsException {
		Booking book = new Booking();
		book.setBookingId(1);
		book.setSource("Andheri");
		book.setDriverId(111);
		book.setDestination("Ghatkopar");;
		book.setFinalFare(350.0);
		book.setDriverStatus("Free");
		book.setEstimatedFare(250.0);
		book.setEstimatedTime(35);
		book.setFinalTime(40);
		book.setIssues("---");
		book.setFinalFare(300.0);
		book.setRating(3);
		book.setTripStatus("Over");
		List<Booking> tr = new ArrayList<Booking>();
		tr.add(book);
		System.out.println(service.addPayment(book));
	}

	@Test
	public void testUpdateReport() {
		Booking book = new Booking();
		book.setBookingId(1);
		book.setSource("Andheri");
		book.setDriverId(111);
		book.setDestination("Ghatkopar");;
		book.setFinalFare(350.0);
		book.setDriverStatus("Free");
		book.setEstimatedFare(250.0);
		book.setEstimatedTime(35);
		book.setFinalTime(40);
		book.setIssues("---");
		book.setFinalFare(300.0);
		book.setRating(3);
		book.setTripStatus("Over");
		List<Booking> tr = new ArrayList<Booking>();
		tr.add(book);
		System.out.println(service.updateReport(book));
	}

	@Test
	public void testUpdateCustomer() throws InvalidDetailsException, InsufficientWalletBalanceException {
		Booking book = new Booking();
		book.setBookingId(1);
		book.setSource("Andheri");
		book.setDriverId(111);
		book.setDestination("Ghatkopar");;
		book.setFinalFare(350.0);
		book.setDriverStatus("Free");
		book.setEstimatedFare(250.0);
		book.setEstimatedTime(35);
		book.setFinalTime(40);
		book.setIssues("---");
		book.setFinalFare(300.0);
		book.setRating(3);
		book.setTripStatus("Over");
		List<Booking> tr = new ArrayList<Booking>();
		tr.add(book);
		System.out.println(service.updateCustomer(book));
	}

}
