package com.cg.cabbookingsystem.dto;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.cg.cabbookingsystem.service.CabBookingService;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class DriverDataEntry {
	@Autowired
	private CabBookingService service;
	
	@EventListener
	public void onAppReady(ApplicationReadyEvent event) {
		if (service.getAllDriver().size() == 0 ) {
			try {
				ObjectMapper mapper = new ObjectMapper();
				
				Driver[] drivers = mapper.readValue(getClass().getClassLoader().getResource("drivers.json"), Driver[].class);
				for(Driver driver: drivers) {
					service.saveDriver(driver);
				}
				
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
			
	}
	
	

}
