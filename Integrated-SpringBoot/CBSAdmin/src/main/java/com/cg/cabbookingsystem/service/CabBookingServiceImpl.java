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
	

	@Override
	public Driver saveDriver(Driver driver) {

		return driverRepository.save(driver);
	}
	
	@Override
	public List<Booking> getBookingDetails() {

		return bookingRepository.findAll();
	}

	
	@Override
	public Booking saveBooking(Booking booking) {

		return bookingRepository.save(booking);
	}

	

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
			Optional<Driver> driver = driverRepository.findById(id);			
			driver.get().setDriverStatus("deleted");
			return true;
		} catch (Exception e) {
			throw new DriverNotFoundException("Driver is not found with this id " + id);
		}
	}

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

	@Override
	public List<Report> getAllReport() {

		return reportRepository.findAll();
	}

	@Override
	public Report saveReport(Report report) {

		return reportRepository.save(report);
	}

}
