package com.cg.cbs.dao;

import com.cg.cbs.dto.Pricing;
import com.cg.cbs.dto.TripDetails;

public interface EstimatePriceDao {
	
	public Pricing estimatePrice(TripDetails details);

}
