package com.cg.cabbookingsystem.exception;

import org.springframework.stereotype.Component;

@Component
public class InvalidLoginException extends Exception{
	public InvalidLoginException() {
		// TODO Auto-generated constructor stub
	}

	public InvalidLoginException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		// TODO Auto-generated constructor stub
	}

	public InvalidLoginException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public InvalidLoginException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public InvalidLoginException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	

}
