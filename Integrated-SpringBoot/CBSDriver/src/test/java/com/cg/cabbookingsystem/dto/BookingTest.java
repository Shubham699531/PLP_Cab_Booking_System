package com.cg.cabbookingsystem.dto;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class BookingTest {
	static Booking booking;
	
	@BeforeClass
	public static void setup() {
		booking = new Booking();
	}

	@Test
	public void testSetIssues() {
		booking.setIssues("No issues");
	}
	
	@Test
	public void testGetIssues() {
		assertNotNull(booking.getIssues());
	}

	@Test
	public void testSetDriverStatus() {
		booking.setDriverStatus("Free");
	}

	@Test
	public void testGetDriverStatus() {
		assertEquals("Free", booking.getDriverStatus());
	}

	@Test
	public void testSetBookingId() {
		booking.setBookingId(1);
	}

	@Test
	public void testGetBookingId() {
		booking.getBookingId();
	}

	@Test
	public void testGetSource() {
		booking.setSource(null);
	}

	@Test()
	public void testSetSource(){
		assertNull(booking.getSource());
	}
}
