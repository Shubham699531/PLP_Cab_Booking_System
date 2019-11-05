package com.cg.cabbookingapplication.service;

import java.util.List;

import com.cg.cabbookingapplication.dto.Customer;
import com.cg.cabbookingapplication.dto.Driver;
import com.cg.cabbookingapplication.exception.InvalidLoginDetails;

public interface CabBookingService {

	Customer addCustomer(Customer customer);

	Driver addDriver(Driver driver);

	Customer findCustomer(String email, String password);

	Driver findDriver(String email, String password);

}
