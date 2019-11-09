package com.cg.cabbookingsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.cabbookingsystem.dto.Report;


/** Specifies methods used to obtain and modify Report related information
* which is stored in the database.
* @author Vineeta
*/

public interface ReportRepository extends JpaRepository<Report, Integer> {

}
