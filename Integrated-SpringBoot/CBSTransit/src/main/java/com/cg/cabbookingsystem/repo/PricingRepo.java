package com.cg.cabbookingsystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.cabbookingsystem.dto.Pricing;

@Repository
public interface PricingRepo extends JpaRepository<Pricing, Integer> {

}
