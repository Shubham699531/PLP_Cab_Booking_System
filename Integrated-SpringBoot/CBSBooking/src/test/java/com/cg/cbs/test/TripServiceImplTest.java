package com.cg.cbs.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.cbs.dto.CustomerRequest;
import com.cg.cbs.service.TripService;
import com.cg.cbs.service.TripServiceImpl;


@SpringBootTest
class TripServiceImplTest {

	@Autowired
	TripService service;
	
	@Before
	void setup() {
		service = new TripServiceImpl();
	}
	
	@After
	void tearDown() {
		service = null;
	}
	
	
	@Test
	void testSaveTripDetails() {
		CustomerRequest details = new CustomerRequest(5236,1123,"Powai", "IIT Bombay",4,"suv");
		assertNotNull(service.saveCustomerRequest(details));
		
	}

	@Test
	void testEstimatePrice() {
		CustomerRequest details = new CustomerRequest(1,1123,"Powai", "IIT Bombay",4,"suv");
		
		// True Assertion
		assertEquals(89.48, service.estimatePrice(details));
		
		//False Assertion
		assertNotEquals(50, service.estimatePrice(details));
	}

	@Test
	void testGetLocations() {
		assertNotNull(service.getLocations());
	}

}
