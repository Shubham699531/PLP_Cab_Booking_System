package com.cg.cbs.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "pricing")
@NamedQuery(name = "getPrice", query = "FROM Pricing WHERE modelType=?1")
public class Pricing {
	
	@Id
	@Column(name = "model_id")
	private int modelId;
	
	@Column(name = "model_type")
	private String modelType;
	
	@Column(name = "base_price")
	private double basePrice;
	
	@Column(name = "rate_per_km")
	private double ratePerKm;

	public Pricing() {
	}

	public Pricing(int modelId, String modelType, double basePrice, double ratePerKm) {
		super();
		this.modelId = modelId;
		this.modelType = modelType;
		this.basePrice = basePrice;
		this.ratePerKm = ratePerKm;
	}

	public int getModelId() {
		return modelId;
	}

	public void setModelId(int modelId) {
		this.modelId = modelId;
	}

	public String getModelType() {
		return modelType;
	}

	public void setModelType(String modelType) {
		this.modelType = modelType;
	}

	public double getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(double basePrice) {
		this.basePrice = basePrice;
	}

	public double getRatePerKm() {
		return ratePerKm;
	}

	public void setRatePerKm(double ratePerKm) {
		this.ratePerKm = ratePerKm;
	}
	
}
