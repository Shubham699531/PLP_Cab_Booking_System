package com.cg.cbs.pf.dao;

import com.cg.cbs.pf.dto.Booking;
import com.cg.cbs.pf.dto.Report;

public interface FeedbackDao {

	Report update(Booking booking);
}
