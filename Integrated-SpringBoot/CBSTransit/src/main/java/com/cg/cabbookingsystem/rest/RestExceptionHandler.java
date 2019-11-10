package com.cg.cabbookingsystem.rest;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.cg.cabbookingsystem.exception.InvalidBookingException;

/**
 * Exception handler for rest components
 * 
 * @author Aman Dungarwal
 * @version 1.0
 */
@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
@RestController
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	/**
	 * Handle invalid booking.
	 *
	 * @param exception the exception
	 * @return the response entity
	 */
	@ExceptionHandler(InvalidBookingException.class)
	@ResponseBody
	public ResponseEntity<Object> handleInvalidBooking(InvalidBookingException exception) {

		return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
	}
}
