package com.cg.cabbookingsystem.repo;

import java.util.List;

import com.cg.cabbookingsystem.dto.Booking;
import com.cg.cabbookingsystem.dto.Customer;
import com.cg.cabbookingsystem.dto.CustomerRequest;
import com.cg.cabbookingsystem.dto.Vehicle;

public interface CustomerRepo {

	List<Vehicle> getVehicles(CustomerRequest req);
	Booking bookACab(Booking booking);
	List<Vehicle> getAllVehicles();
	List<Booking> pastTrips(Customer customer);
}
