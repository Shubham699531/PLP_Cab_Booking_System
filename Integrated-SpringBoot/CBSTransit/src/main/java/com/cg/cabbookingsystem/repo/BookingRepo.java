package com.cg.cabbookingsystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.cabbookingsystem.dto.Booking;

@Repository
public interface BookingRepo extends JpaRepository<Booking, Integer> {

}
