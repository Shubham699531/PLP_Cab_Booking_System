package com.cg.cbs.dao;

import com.cg.cbs.dto.Pricing;
import com.cg.cbs.dto.CustomerRequest;
/**
 * Dao Inteface abstract methods for fetching pricing details for specified
 * Trip Details.
 * @author Akash
 *
 */
public interface EstimatePriceDao {
	
	public Pricing estimatePrice(CustomerRequest details);

}
