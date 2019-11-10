package com.cg.cabbookingsystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.cabbookingsystem.dto.Pricing;

/**
 * JPA Pricing Repository
 * 
 * @author Aman Dungarwal
 * @version 1.0
 */
@Repository
public interface PricingRepo extends JpaRepository<Pricing, Integer> {

}
