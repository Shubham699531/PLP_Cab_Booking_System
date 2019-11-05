package com.cg.cabbookingsystem.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.cabbookingsystem.dto.DriverModel;
import com.cg.cabbookingsystem.repo.DriverRepo;

@Transactional
@RestController
@RequestMapping(value = "/register")
public class DriverController {
	
	@Autowired
	private DriverRepo repo;
	
	@PostMapping(consumes = "application/json")
	public DriverModel saveDriver(@RequestBody DriverModel driver) {
		return repo.save(driver);
	}
	
	@GetMapping(value = "/fetch")
	public DriverModel fetchDriver(@RequestParam String email) {
		return repo.fetchByEmail(email);
	}

}
