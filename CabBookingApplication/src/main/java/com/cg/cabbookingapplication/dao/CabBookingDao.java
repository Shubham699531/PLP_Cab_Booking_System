package com.cg.cabbookingapplication.dao;

import java.util.List;

import com.cg.cabbookingapplication.dto.Customer;
import com.cg.cabbookingapplication.dto.Driver;
import com.cg.cabbookingapplication.exception.InvalidLoginDetails;

public interface CabBookingDao {

	Customer add(Customer customer);

	Driver add(Driver driver);

	List<Customer> findCustomer(String email, String password) throws InvalidLoginDetails;

	List<Driver> findDriver(String email, String password) throws InvalidLoginDetails;

}
