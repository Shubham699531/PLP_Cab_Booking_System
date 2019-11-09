package com.cg.cabbookingsystem.dto;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.cg.cabbookingsystem.service.CabBookingService;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class BookingDataEntry {
	@Autowired
	private CabBookingService service;
	
	@EventListener
	public void onAppReady(ApplicationReadyEvent event) {
		if (service.getBookingDetails().size()==0) {
			try {
				ObjectMapper mapper = new ObjectMapper();
				
				Booking[] bookings = mapper.readValue(getClass().getClassLoader().getResource("bookings.json"), Booking[].class);
				
				for(Booking booking: bookings) {
					service.saveBooking(booking);
					
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}	
	
	}
	