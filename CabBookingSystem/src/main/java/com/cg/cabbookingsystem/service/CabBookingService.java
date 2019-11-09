package com.cg.cabbookingsystem.service;

import java.util.List;

import com.cg.cabbookingsystem.dto.Booking;
import com.cg.cabbookingsystem.dto.Driver;
import com.cg.cabbookingsystem.dto.Report;
import com.cg.cabbookingsystem.exception.DriverNotFoundException;
/**
 * Declares methods used to obtain and modify CabBooking Application information.
 * @author Vineeta
 */
public interface CabBookingService {

	Driver saveDriver(Driver driver);

	boolean deleteDriver(int id) throws DriverNotFoundException;

	Driver updateDriver(Driver driver);

	Driver findDriver(int id) throws DriverNotFoundException;

	List<Report> getAllReport();
	
	List<Driver> getAllDriver();

	Report saveReport(Report report);

	List<Booking> getBookingDetails();

	Booking saveBooking(Booking booking);

}
