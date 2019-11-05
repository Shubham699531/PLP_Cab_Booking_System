package com.cg.cabbookingsystem.repo;

import com.cg.cabbookingsystem.dto.DriverModel;

public interface DriverRepo{
	
	DriverModel save(DriverModel driver);
	
	DriverModel fetchByEmail(String email);

}
