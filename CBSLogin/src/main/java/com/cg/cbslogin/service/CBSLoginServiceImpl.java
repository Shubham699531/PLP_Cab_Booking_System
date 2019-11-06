package com.cg.cbslogin.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.cbslogin.dto.Customer;
import com.cg.cbslogin.dto.Driver;
import com.cg.cbslogin.dto.DriverSignupDetails;
import com.cg.cbslogin.dto.User;
import com.cg.cbslogin.repo.CBSLoginRepo;

@Service
@Transactional
public class CBSLoginServiceImpl implements CBSLoginService {

	private CBSLoginRepo repo;
	@Autowired
	public CBSLoginServiceImpl(CBSLoginRepo repo) {
		this.repo = repo;
	}
	@Override
	public Customer loginCustomer(User user) {
		return repo.loginCustomer(user);
	}

	@Override
	public Driver loginDriver(User user) {
		return repo.loginDriver(user);
	}

	@Override
	public Customer signupCustomer(Customer customer) {
		return repo.signupCustomer(customer);
	}

	@Override
	public DriverSignupDetails signupDriver(DriverSignupDetails driver) {
		return repo.signupDriver(driver);
	}

}
