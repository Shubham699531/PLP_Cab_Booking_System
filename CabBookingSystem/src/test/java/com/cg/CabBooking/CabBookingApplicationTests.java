package com.cg.CabBooking;

/**
 * Test cases for CabBooking Application
 * @author Group 5
 * @version 1.0
 *
 */
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.cabbookingsystem.CabBookingSystemApplication;
import com.cg.cabbookingsystem.dto.Booking;
import com.cg.cabbookingsystem.dto.Driver;
import com.cg.cabbookingsystem.dto.Report;
import com.cg.cabbookingsystem.exception.DriverNotFoundException;
import com.cg.cabbookingsystem.service.CabBookingService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CabBookingSystemApplication.class)
class CabBookingApplicationTests {
	
	@Autowired
	private CabBookingService service;
	

	@Test
	public void testSaveReport() {
		Report report= new Report();
		report.setBookingId(1001);
		report.setCustomerId(1010);
		report.setDriverId(1002);
		report.setIssues("Payment Issue");
		List<Report> report1 = new ArrayList<Report>();
		report1.add(report);
		System.out.println(service.saveReport(report));
		
	}
	@Test
	public void testSaveDriver() {
		Driver driver= new Driver();
		driver.setName("Ram"); 
		driver.setAddress("Delhi");
		driver.setContactNo("9898989898");
		driver.setDrivingLicense("DL3429846578013");
		driver.setEmail("ram@gmail.com");
		driver.setDob(new Date(96, 8, 12));
		driver.setGender("Male");
		driver.setNumberOfTrips(5);
		driver.setPassword("password");
		driver.setVehicleNo("MH43BA8192");
		driver.setDriverStatus("Not Verified");
		driver.setRating(8.0);
		List<Driver> driver1 = new ArrayList<Driver>();
		driver1.add(driver);
		System.out.println(service.saveDriver(driver));
	}
	
	@Test
	public void testSaveBooking() {
		Booking book = new Booking();
	
		book.setCustomerId(1011);
		book.setDestination("Ghatkopar");
		book.setDriverId(1011);
		book.setDriverStatus("Free");
		book.setEstimatedFare(250.0);
		book.setEstimatedTime(35);
		book.setFinalFare(300.0);
		book.setFinalTime(36);
		book.setRating(3);
		book.setTripStatus("Over");
		book.setSource("Andheri");

		                                
		List<Booking> book1 = new ArrayList<Booking>();
		book1.add(book);
		System.out.println(service.saveBooking(book));		
	}
	@Test
	public void testUpdateDriver() {
		Driver driver= new Driver();
		driver.setDriverId(1002);
		driver.setName("Ram");
		driver.setAddress("Delhi");
		driver.setContactNo("9898989898");
		driver.setDrivingLicense("DL3429846578013");
		driver.setEmail("ram@gmail.com");
		driver.setDob(new Date(96, 8, 12));
		driver.setGender("Male");
		driver.setNumberOfTrips(5);
		driver.setPassword("password");
		driver.setVehicleNo("MH 43 BA 8192");
		driver.setDriverStatus("Not Verified");
		driver.setRating(8.0);
		List<Driver> driver1 = new ArrayList<Driver>();
		driver1.add(driver);
		System.out.println(service.updateDriver(driver));
	}
	 
	@Test
	public void testDeleteDriver() throws DriverNotFoundException {
		assertTrue(service.deleteDriver(1282));
	}
	
	@Test
	public void testGetAllDriverTest() {
		assertFalse(service.getAllDriver()==null);
	}

	@Test
	public void testGetAllReportTest() {
		assertFalse(service.getAllReport()==null);
	}
	@Test
	public void testGetAllBookingTest() {
		assertFalse(service.getBookingDetails()==null);
	}
	
	@Test
	public void testFetchById() throws DriverNotFoundException {
		assertEquals("Ravi", service.findDriver(1062).getName());
	}

}
