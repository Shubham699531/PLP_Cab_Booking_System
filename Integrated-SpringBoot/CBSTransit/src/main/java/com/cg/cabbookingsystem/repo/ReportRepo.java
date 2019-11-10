package com.cg.cabbookingsystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.cabbookingsystem.dto.Report;

/**
 * JPA Report Repository
 * 
 * @author Aman Dungarwal
 * @version 1.0
 */
@Repository
public interface ReportRepo extends JpaRepository<Report, Integer> {

}
