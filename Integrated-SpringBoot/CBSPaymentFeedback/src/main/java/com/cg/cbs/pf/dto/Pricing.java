package com.cg.cbs.pf.dto;

/**
 * This is the bean class for Pricing entity.
 * @author Anchita Roy
 * @version 1.0
 */

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Pricing {

	@Id
	private int categoryId;
	@Column(length = 50)
	private String modelType;
	private double basePrice;
	private double ratePerKM;
	private double waitingChargePerMin;
	
	public Pricing() {
	}

	public Pricing(int vehicleSize, double ratePerKM, double waitingChargePerMin) {
		this.categoryId = vehicleSize;
		this.ratePerKM = ratePerKM;
		this.waitingChargePerMin = waitingChargePerMin;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public double getRatePerKM() {
		return ratePerKM;
	}

	public void setRatePerKM(double ratePerKM) {
		this.ratePerKM = ratePerKM;
	}

	public double getWaitingChargePerMin() {
		return waitingChargePerMin;
	}

	public void setWaitingChargePerMin(double waitingChargePerMin) {
		this.waitingChargePerMin = waitingChargePerMin;
	}

	public double getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(double basePrice) {
		this.basePrice = basePrice;
	}

}