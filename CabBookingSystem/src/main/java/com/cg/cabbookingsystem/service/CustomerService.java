package com.cg.cabbookingsystem.service;

import java.util.List;

import com.cg.cabbookingsystem.dto.Vehicle;

public interface CustomerService {

	List<Vehicle> getNearByVehicles();
}
