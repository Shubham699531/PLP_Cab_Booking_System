package com.cg.cabbookingsystem.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Data transfer object class for customer request object.
 *
 * @author Aman Dungarwal
 * @version 1.0
 */
@Entity
public class CustomerRequest {

	/** The request id. */
	@Id
	private int requestId;

	/** The customer id. */
	private int customerId;

	/** The source. */
	private String source;

	/** The destination. */
	private String destination;

	/** The vehicle size. */
	private int vehicleSize;

	/** The model. */
	private String model;

	/**
	 * Gets the request id.
	 *
	 * @return the request id
	 */
	public int getRequestId() {
		return requestId;
	}

	/**
	 * Sets the request id.
	 *
	 * @param requestId the new request id
	 */
	public void setRequestId(int requestId) {
		this.requestId = requestId;
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
	 * Gets the customer id.
	 *
	 * @return the customer id
	 */
	public int getCustomerId() {
		return customerId;
	}

	/**
	 * Sets the customer id.
	 *
	 * @param customerId the new customer id
	 */
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	/**
	 * Gets the source.
	 *
	 * @return the source
	 */
	public String getSource() {
		return source;
	}

	/**
	 * Sets the source.
	 *
	 * @param source the new source
	 */
	public void setSource(String source) {
		this.source = source;
	}

	/**
	 * Gets the destination.
	 *
	 * @return the destination
	 */
	public String getDestination() {
		return destination;
	}

	/**
	 * Sets the destination.
	 *
	 * @param destination the new destination
	 */
	public void setDestination(String destination) {
		this.destination = destination;
	}

	/**
	 * Gets the vehicle size.
	 *
	 * @return the vehicle size
	 */
	public int getVehicleSize() {
		return vehicleSize;
	}

	/**
	 * Sets the vehicle size.
	 *
	 * @param vehicleSize the new vehicle size
	 */
	public void setVehicleSize(int vehicleSize) {
		this.vehicleSize = vehicleSize;
	}

}
