package com.cg.cabbookingsystem.dto;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.cg.cabbookingsystem.service.CabBookingService;
import com.fasterxml.jackson.databind.ObjectMapper;


	
	@Component
	public class ReportDataEntry {
		@Autowired
		private CabBookingService service;
		
		@EventListener
		public void onAppReady(ApplicationReadyEvent event) {
			if (service.getAllReport().size()==0) {
				try {
					ObjectMapper mapper = new ObjectMapper();
					
					Report[] reports = mapper.readValue(getClass().getClassLoader().getResource("reports.json"), Report[].class);
					
					for(Report report: reports) {
						service.saveReport(report);
					}
					
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
				
		
		}
		

}
