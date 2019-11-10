package com.cg.cabbookingsystem.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Data transfer object class for pricing object.
 *
 * @author Aman Dungarwal
 * @version 1.0
 */
@Entity
public class Pricing {

	/** The category id. */
	@Id
	private int categoryId;

	/** The model type. */
	@Column(length = 50)
	private String modelType;

	/** The base price. */
	private double basePrice;

	/** The rate per KM. */
	private double ratePerKM;

	/** The waiting charge per min. */
	private double waitingChargePerMin;

	/**
	 * Instantiates a new pricing.
	 */
	public Pricing() {
	}

	/**
	 * Instantiates a new pricing.
	 *
	 * @param vehicleSize         the vehicle size
	 * @param ratePerKM           the rate per KM
	 * @param waitingChargePerMin the waiting charge per min
	 */
	public Pricing(int vehicleSize, double ratePerKM, double waitingChargePerMin) {
		this.categoryId = vehicleSize;
		this.ratePerKM = ratePerKM;
		this.waitingChargePerMin = waitingChargePerMin;
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
	 * @param categoryId the new category id
	 */
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	/**
	 * Gets the rate per KM.
	 *
	 * @return the rate per KM
	 */
	public double getRatePerKM() {
		return ratePerKM;
	}

	/**
	 * Sets the rate per KM.
	 *
	 * @param ratePerKM the new rate per KM
	 */
	public void setRatePerKM(double ratePerKM) {
		this.ratePerKM = ratePerKM;
	}

	/**
	 * Gets the waiting charge per min.
	 *
	 * @return the waiting charge per min
	 */
	public double getWaitingChargePerMin() {
		return waitingChargePerMin;
	}

	/**
	 * Sets the waiting charge per min.
	 *
	 * @param waitingChargePerMin the new waiting charge per min
	 */
	public void setWaitingChargePerMin(double waitingChargePerMin) {
		this.waitingChargePerMin = waitingChargePerMin;
	}

	/**
	 * Gets the base price.
	 *
	 * @return the base price
	 */
	public double getBasePrice() {
		return basePrice;
	}

	/**
	 * Sets the base price.
	 *
	 * @param basePrice the new base price
	 */
	public void setBasePrice(double basePrice) {
		this.basePrice = basePrice;
	}

}