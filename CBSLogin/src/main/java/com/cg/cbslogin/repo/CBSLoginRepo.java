package com.cg.cbslogin.repo;

import com.cg.cbslogin.dto.Customer;
import com.cg.cbslogin.dto.Driver;
import com.cg.cbslogin.dto.DriverSignupDetails;
import com.cg.cbslogin.dto.User;

public interface CBSLoginRepo {

	Customer loginCustomer(User user);
	Driver loginDriver(User user);
	Customer signupCustomer(Customer customer);
	DriverSignupDetails signupDriver(DriverSignupDetails driver);
}
