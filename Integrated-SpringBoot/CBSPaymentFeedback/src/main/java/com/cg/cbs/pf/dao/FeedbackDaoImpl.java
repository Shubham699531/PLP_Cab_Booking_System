package com.cg.cbs.pf.dao;

/**
 * This is the dao layer implementation class for feedback updation.
 * @author Anchita Roy
 * @version 1.0
 */

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cg.cbs.pf.dto.Booking;
import com.cg.cbs.pf.dto.Report;

@Repository
public class FeedbackDaoImpl implements FeedbackDao {

	@Autowired
	private EntityManager mgr;
	
	Report report = new Report(); 
	
	static Logger daoLogger = Logger.getLogger(FeedbackDaoImpl.class);
	
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
		daoLogger.info("Feedback successfully updated to reports.");
		return mergedReport;
	}
}
