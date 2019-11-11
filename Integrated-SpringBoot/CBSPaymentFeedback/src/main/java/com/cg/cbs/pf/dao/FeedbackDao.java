package com.cg.cbs.pf.dao;

/**
 * This the the interface for Feedback updation class.
 * @author Anchita Roy
 * @version 1.0
 */

import com.cg.cbs.pf.dto.Booking;
import com.cg.cbs.pf.dto.Report;

public interface FeedbackDao {

	/**
	 * It will update the Reports database after feedback submission.
	 * @param booking
	 * @return
	 */
	Report update(Booking booking);
}
