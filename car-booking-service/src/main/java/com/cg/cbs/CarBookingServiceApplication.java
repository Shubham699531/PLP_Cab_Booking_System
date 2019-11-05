package com.cg.cbs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CarBookingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarBookingServiceApplication.class, args);
	}

}
