package com.cg.cbs;

import org.apache.log4j.PropertyConfigurator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CarBookingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarBookingServiceApplication.class, args);
		PropertyConfigurator.configure("src/main/java/log4j.properties");
	}

}
