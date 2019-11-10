package com.cg.cabbookingsystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.cabbookingsystem.dto.Customer;

/**
 * JPA Customer Repository
 * 
 * @author Aman Dungarwal
 * @version 1.0
 */
@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer> {

}
