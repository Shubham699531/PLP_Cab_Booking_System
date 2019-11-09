package com.cg.cab.service;

import com.cg.cab.dto.Customer;
import com.cg.cab.dto.Driver;
import com.cg.cab.dto.User;
import com.cg.cab.dto.Vehicle;
import com.cg.cab.exception.UserNotFoundException;

public interface ICabService {

	Driver validateLoginDriver(User user) throws UserNotFoundException;

	Driver saveDriver(Driver driver);

	Vehicle saveVehicle(Vehicle vehicle);

	Customer validateLoginCustomer(User user) throws UserNotFoundException;

	Customer saveCustomer(Customer customer);

}
