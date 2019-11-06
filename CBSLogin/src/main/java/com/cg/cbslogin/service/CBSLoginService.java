package com.cg.cbslogin.service;

import org.springframework.stereotype.Service;

import com.cg.cbslogin.dto.Customer;
import com.cg.cbslogin.dto.Driver;
import com.cg.cbslogin.dto.DriverSignupDetails;
import com.cg.cbslogin.dto.User;


public interface CBSLoginService {

	Customer loginCustomer(User user);
	Driver loginDriver(User user);
	Customer signupCustomer(Customer customer);
	DriverSignupDetails signupDriver(DriverSignupDetails driver);
}
