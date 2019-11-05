package com.cg.cabbookingsystem.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Price {

	@Id
	private int vehicleSize;
	private double ratePerKM;
	private double waitingChargePerMin;
	
	public int getVehicleSize() {
		return vehicleSize;
	}
	public void setVehicleSize(int vehicleSize) {
		this.vehicleSize = vehicleSize;
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
	
	
}
