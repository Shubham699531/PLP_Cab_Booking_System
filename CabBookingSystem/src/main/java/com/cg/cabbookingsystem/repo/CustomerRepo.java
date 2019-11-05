package com.cg.cabbookingsystem.repo;

import java.util.List;

import com.cg.cabbookingsystem.dto.Booking;
import com.cg.cabbookingsystem.dto.CustomerRequirement;
import com.cg.cabbookingsystem.dto.Vehicle;

public interface CustomerRepo {

	List<Vehicle> getVehicles(CustomerRequirement req);
	Booking bookACab(Booking booking);
	List<Vehicle> getAllVehicles();
}
