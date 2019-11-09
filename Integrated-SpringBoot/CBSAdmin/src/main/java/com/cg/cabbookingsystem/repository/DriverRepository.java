package com.cg.cabbookingsystem.repository;


/** Specifies methods used to obtain and modify Driver related information
* which is stored in the database.
* @author Vineeta
*/
import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.cabbookingsystem.dto.Driver;

public interface DriverRepository extends JpaRepository<Driver, Integer> {

}
