package com.cg.cabbookingsystem.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Data transfer object class for User object
 * 
 * @author Aman Dungarwal
 * @version 1.0
 */
@Entity(name = "users")
public class Users {

	@Id
	private String email;

	private String password;
	private String role;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
