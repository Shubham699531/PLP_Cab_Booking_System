package com.cg.cbsui.exception;

@SuppressWarnings("serial")
public class InvalidBookingException extends Exception {

	public InvalidBookingException() {
	}

	public InvalidBookingException(String message) {
		super(message);
	}

	public InvalidBookingException(Throwable cause) {
		super(cause);
	}

	public InvalidBookingException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidBookingException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
