package com.cg.cab.service;

import static org.junit.Assert.*;

import java.sql.Time;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.cab.dto.Customer;
import com.cg.cab.dto.Driver;
import com.cg.cab.dto.User;
import com.cg.cab.exception.UserNotFoundException;




@RunWith(SpringRunner.class)
@SpringBootTest
public class CabServiceImplTest {
	@Autowired
	private ICabService service;
	
	private Customer customer;
	
	private Driver driver;
	
	private User user;
	
	@Before
	public void initCustomer() {
		customer = new Customer();
		customer.setName("Ayan Sinha");
		customer.setGender("Male");
		customer.setContactNo("9851268713");
		customer.setEmail("ABC@mail.com");
		customer.setPassword("ayan@123");
		customer.setAddress("Kolkata");
		customer.setDob(new Time(0));
	}
	
	@Before
	public void initDriver() {
		driver = new Driver();
		driver.setName("XYZ");
		driver.setPassword("xyz123");
		driver.setGender("Male");
		driver.setContactNo("9876135276");
		driver.setEmail("syz@mail.com");
		driver.setAddress("Kolkata");
		driver.setDriverStatus("Free");
		driver.setVehicleNo("WB 12 8756");
		driver.setDrivingLicense("wb1254");
		driver.setNumberOfTrips(0);
		driver.setRating(0);
			
	}
	
	
	

	@Test
	public void testSaveCustomer() {
		Customer customer1 = service.saveCustomer(customer);
		assertTrue(customer1.getName().equals("Ayan Sinha"));

	}

	@Test
	public void testSaveDriver() {
		Driver driver1 = service.saveDriver(driver);
		assertTrue(driver1.getName().equals("XYZ"));	
	}

	@Test()
	public void testValidateLoginCustomer() throws UserNotFoundException{
		User user = new User();
		user.setEmail("ABC@mail.com");
		user.setPassword("ayan@123");
		assertTrue(service.validateLoginCustomer(user).getName().equals("Ayan Sinha"));
	}
	
	

	
	@Test
	public void testValidateLoginDriver() throws UserNotFoundException {
		User user = new User();
		user.setEmail("syz@mail.com");
		user.setPassword("xyz123");
		assertTrue(service.validateLoginDriver(user).getName().equals("XYZ"));
	}

	

	@Test(expected = UserNotFoundException.class)
	public void testLoginDriverFailed() throws UserNotFoundException{
		
		User user = new User();
		user.setEmail("xxx@mail.com");
		user.setPassword("1234");
		assertFalse(service.validateLoginDriver(user).getName().equals("xyz"));
		//assertTrue(service.validateLoginDriver(user).getName().equals("XYZ"));
		
	}
	
	@Test(expected = UserNotFoundException.class)
	public void testLoginCustomerFailed() throws UserNotFoundException{
		
		User user = new User();
		user.setEmail("xxx@mail.com");
		user.setPassword("1234");
		assertFalse(service.validateLoginDriver(user).getName().equals("xyz"));
		//assertTrue(service.validateLoginDriver(user).getName().equals("XYZ"));
		
	}

}
