package com.cg.cabbookingapplication.rest;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.cg.cabbookingapplication.exception.InvalidLoginDetails;



@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
@RestController
public class RestExceptionHandler extends ResponseEntityExceptionHandler{
	@ExceptionHandler(InvalidLoginDetails.class)
	@ResponseBody
	public ResponseEntity<Object> handleInvalidLogin(InvalidLoginDetails User) {

		System.out.println("Exception: " + User.getMessage());

		return new ResponseEntity<>(User.getMessage(), HttpStatus.NOT_FOUND);

	}

}
