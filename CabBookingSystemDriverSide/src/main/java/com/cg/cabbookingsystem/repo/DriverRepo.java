package com.cg.cabbookingsystem.repo;

import java.util.List;

import com.cg.cabbookingsystem.dto.Booking;
import com.cg.cabbookingsystem.dto.Driver;
import com.cg.cabbookingsystem.dto.User;
import com.cg.cabbookingsystem.dto.Vehicle;
import com.cg.cabbookingsystem.exception.InvalidLoginException;

public interface DriverRepo {

	Driver getListOfDrivers(List<Vehicle> vehicles);
	
	Booking showBookingDetails(Booking booking) ;
	
	List<Booking> getAllTripsOfADriver(int userId);
	
	Driver validateLogin(User user);

}
