package com.cg.cabbookingsystem.repo;

import java.util.List;

import com.cg.cabbookingsystem.dto.Vehicle;

public interface CustomerRepo {

	List<Vehicle> getVehicleNumbers(String source, String cabSize, int size);
	
	double calculateDistance(String source, String destination);
	
}
