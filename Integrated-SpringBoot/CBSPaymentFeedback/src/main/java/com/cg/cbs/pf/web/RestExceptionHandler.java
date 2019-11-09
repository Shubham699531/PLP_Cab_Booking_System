package com.cg.cbs.pf.web;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.cg.cbs.pf.exception.InsufficientWalletBalanceException;
import com.cg.cbs.pf.exception.InvalidDetailsException;


@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
@RestController
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler({InvalidDetailsException.class, InsufficientWalletBalanceException.class})
	@ResponseBody
	public ResponseEntity<Object> handleInvalidCustomer(Exception stat){
		System.out.println("Exception: "+stat.getMessage());
		return new ResponseEntity<>(stat.getMessage(), HttpStatus.NOT_FOUND);
	}
	
}
