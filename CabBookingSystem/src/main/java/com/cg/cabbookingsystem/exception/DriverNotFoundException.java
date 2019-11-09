package com.cg.cabbookingsystem.exception;

/**
 * This is a custom exception which is to be thrown when no Driver details have been 
 * added to the database.
 * @author Vineeta
 * @version 1.0
 */
public class DriverNotFoundException extends Exception {

	public DriverNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DriverNotFoundException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		// TODO Auto-generated constructor stub
	}

	public DriverNotFoundException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public DriverNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public DriverNotFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
	

}
