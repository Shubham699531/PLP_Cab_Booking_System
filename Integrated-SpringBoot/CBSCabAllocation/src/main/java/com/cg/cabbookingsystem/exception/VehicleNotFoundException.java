package com.cg.cabbookingsystem.exception;

public class VehicleNotFoundException extends Exception {

	public VehicleNotFoundException() {
		super();
	}

	public VehicleNotFoundException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public VehicleNotFoundException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public VehicleNotFoundException(String arg0) {
		super(arg0);
	}

	public VehicleNotFoundException(Throwable arg0) {
		super(arg0);
	}

	
}
