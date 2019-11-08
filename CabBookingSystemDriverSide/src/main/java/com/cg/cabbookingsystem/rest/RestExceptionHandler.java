package com.cg.cabbookingsystem.rest;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.cg.cabbookingsystem.exception.NoBookingFoundException;
import com.cg.cabbookingsystem.exception.NoPastRidesFoundException;

/**
 * Rest Exception Handler for handling custom exceptions
 * @author Shubham
 * @version 1.0
 *
 */
@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
@RestController
public class RestExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(NoPastRidesFoundException.class)
	@ResponseBody
	public ResponseEntity<Object> handleNoPastRidesException(NoPastRidesFoundException exception){
		System.out.println(exception.getMessage());
		
		return new ResponseEntity<Object>(exception.getMessage(),HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(NoBookingFoundException.class)
	@ResponseBody
	public ResponseEntity<Object> handleNoBookingsException(NoBookingFoundException exception){
		System.out.println(exception.getMessage());
		
		return new ResponseEntity<Object>(exception.getMessage(),HttpStatus.NOT_FOUND);
		
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		System.out.println(ex.getMessage());
		Map<String, Object> body = new LinkedHashMap<>();
		body.put("timestamp", new Date());
		body.put("status", status.value());

		// Get all errors
		List<String> errors = ex.getBindingResult().getFieldErrors().stream().map(x -> x.getDefaultMessage())
				.collect(Collectors.toList());

		body.put("errors", errors);

		return new ResponseEntity<>(body, headers, status);

	}

}
