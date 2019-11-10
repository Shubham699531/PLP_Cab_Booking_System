package com.cg.cabbookingsystem.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

/**
 * Data transfer object class for Vehicle object.
 *
 * @author Aman Dungarwal
 * @version 1.0
 */
@Entity
@NamedQuery(name = "fetchBySize", query = "FROM Vehicle WHERE category=:size AND status='free'")
@NamedQuery(name = "fetchAll", query = "FROM Vehicle")
public class Vehicle {

	/** The vehicle no. */
	@Id
	private String vehicleNo;

	/** The category id. */
	private int categoryId;

	/** The model. */
	@Column(length = 50)
	private String model;

	/** The status. */
	@Column(length = 50)
	private String status;

	/** The location. */
	@Column(length = 50)
	private String location;

	/**
	 * Gets the vehicle no.
	 *
	 * @return the vehicle no
	 */
	public String getVehicleNo() {
		return vehicleNo;
	}

	/**
	 * Sets the vehicle no.
	 *
	 * @param vehicleNo the new vehicle no
	 */
	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}

	/**
	 * Gets the category id.
	 *
	 * @return the category id
	 */
	public int getCategoryId() {
		return categoryId;
	}

	/**
	 * Sets the category id.
	 *
	 * @param size the new category id
	 */
	public void setCategoryId(int size) {
		this.categoryId = size;
	}

	/**
	 * Gets the model.
	 *
	 * @return the model
	 */
	public String getModel() {
		return model;
	}

	/**
	 * Sets the model.
	 *
	 * @param model the new model
	 */
	public void setModel(String model) {
		this.model = model;
	}

	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Sets the status.
	 *
	 * @param status the new status
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * Gets the location.
	 *
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * Sets the location.
	 *
	 * @param location the new location
	 */
	public void setLocation(String location) {
		this.location = location;
	}

}
