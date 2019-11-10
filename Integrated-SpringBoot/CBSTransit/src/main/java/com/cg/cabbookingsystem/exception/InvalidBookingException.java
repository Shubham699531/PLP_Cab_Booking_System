package com.cg.cabbookingsystem.exception;

/**
 * Custom Exception Class InvalidBookingException.
 *
 * @author Aman Dungarwal
 * @version 1.0
 */
@SuppressWarnings("serial")
public class InvalidBookingException extends Exception {

	/**
	 * Instantiates a new invalid booking exception.
	 */
	public InvalidBookingException() {
	}

	/**
	 * Instantiates a new invalid booking exception.
	 *
	 * @param message the message
	 */
	public InvalidBookingException(String message) {
		super(message);
	}

	/**
	 * Instantiates a new invalid booking exception.
	 *
	 * @param cause the cause
	 */
	public InvalidBookingException(Throwable cause) {
		super(cause);
	}

	/**
	 * Instantiates a new invalid booking exception.
	 *
	 * @param message the message
	 * @param cause   the cause
	 */
	public InvalidBookingException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Instantiates a new invalid booking exception.
	 *
	 * @param message            the message
	 * @param cause              the cause
	 * @param enableSuppression  the enable suppression
	 * @param writableStackTrace the writable stack trace
	 */
	public InvalidBookingException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
