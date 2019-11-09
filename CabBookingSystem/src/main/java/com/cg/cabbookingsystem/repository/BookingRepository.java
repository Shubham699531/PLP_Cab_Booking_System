package com.cg.cabbookingsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.cabbookingsystem.dto.Booking;


/** Specifies methods used to obtain and modify Booking related information
* which is stored in the database.
* @author Vineeta
*/
public interface BookingRepository extends JpaRepository<Booking, Integer> {

}
