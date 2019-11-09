package com.cg.cbs.pf.dao;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cg.cbs.pf.dto.Booking;
import com.cg.cbs.pf.dto.Report;

@Repository
public class FeedbackDaoImpl implements FeedbackDao {

	@Autowired
	private EntityManager mgr;
	
	Report report = new Report(); 
	
	@Override
	public Report update(Booking booking) {
		int fBookingId = booking.getBookingId();
		int fCustomerId = booking.getCustomerId();
		int fDriverId = booking.getDriverId();
		String fIssues = booking.getIssues();
		report.setBookingId(fBookingId);
		report.setCustomerId(fCustomerId);
		report.setDriverId(fDriverId);
		report.setIssues(fIssues);
		Report mergedReport = mgr.merge(report);
		mgr.flush();
		return mergedReport;
	}
}
