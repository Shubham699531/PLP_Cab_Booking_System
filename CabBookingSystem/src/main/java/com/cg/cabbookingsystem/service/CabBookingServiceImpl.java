package com.cg.cabbookingsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.cabbookingsystem.dto.Booking;
import com.cg.cabbookingsystem.dto.Driver;
import com.cg.cabbookingsystem.dto.Report;
import com.cg.cabbookingsystem.exception.DriverNotFoundException;
import com.cg.cabbookingsystem.repository.BookingRepository;
import com.cg.cabbookingsystem.repository.DriverRepository;
import com.cg.cabbookingsystem.repository.ReportRepository;
/**
 * This implementation of the CabBookingService interface communicates with
 * the database by using a Spring Data JPA repository.
 * @author Vineeta
 * @version 1.0
 *
 */

@Service
@Transactional
public class CabBookingServiceImpl implements CabBookingService {

	@Autowired
	private ReportRepository reportRepository;
	@Autowired
	private BookingRepository bookingRepository;

	@Autowired
	private DriverRepository driverRepository;
	

	 /**
     * Save the Driver details in database by providing all details.
     * @param driver
     *        providing driver details to store in database 
     * @return  driver  
     *         store driver details in database
     */
	@Override
	public Driver saveDriver(Driver driver) {

		return driverRepository.save(driver);
	}
	
	/**
	 * Shows a list of booking details of all bookings
	 * @return booking
	 *        list all the booking details in table 
	 */
	@Override
	public List<Booking> getBookingDetails() {

		return bookingRepository.findAll();
	}

	/**
     * Save the booking details in database.
     * @param booking
     *        providing booking details to store in database 
     * @return  driver  
     *         store booking details in database
     */
	@Override
	public Booking saveBooking(Booking booking) {

		return bookingRepository.save(booking);
	}

	/**
	 * Shows a list of driver details stored in database
	 * @return driver
	 *        list all the driver details in table 
	 */
	@Override
	public List<Driver> getAllDriver() {
		return driverRepository.findAll();
	}

	 /**
     * Delete Driver details by using the Id as a search criteria.
     * @param id 
     *         It will delete Driver details which id is an exact match with the given id.
     * @return  boolean 
     *          If no Driver is found, this method will throw an exception.
     */
	@Override
	public boolean deleteDriver(int id) throws DriverNotFoundException {
		try {
			driverRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			throw new DriverNotFoundException("Driver is not found with this id " + id);
		}
	}

	/**
     * Update the Driver details in database if id exists and save if id is different.
     * @param driver
     *        providing driver details to update in database 
     * @return  driver  
     *         store driver details in database
     */
	@Override
	public Driver updateDriver(Driver driver) {
		return driverRepository.save(driver);
	}

	 /**
     * Finds Driver details by using the Id as a search criteria.
     * @param id 
     * @return  A list of Driver which id is an exact match with the given id.
     *          If no Driver is found, this method will throw an exception.
     */
	@Override
	public Driver findDriver(int id) throws DriverNotFoundException {

		Optional<Driver> op = driverRepository.findById(id);
		if (op.isPresent())
			return op.get();
		throw new DriverNotFoundException("Driver Not Found With this id " + id);

	}

	/**
	 * Shows a list of issues raised by customer stored in database 
	 * @return report
	 *        list all the report details in table 
	 */
	@Override
	public List<Report> getAllReport() {

		return reportRepository.findAll();
	}

	/**
     * Save the Customer Issues details in database.
     * @param report
     *        enter the customer issue to store in database 
     * @return  report  
     *         store customer issues details in database
     */
	@Override
	public Report saveReport(Report report) {

		return reportRepository.save(report);
	}

}
