package com.cg.cabbookingsystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.cabbookingsystem.dto.Location;

/**
 * JPA Location Repository
 * 
 * @author Aman Dungarwal
 * @version 1.0
 */
@Repository
public interface LocationRepo extends JpaRepository<Location, Integer> {

}
