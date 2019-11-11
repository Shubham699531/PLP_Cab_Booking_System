package com.cg.cbs.pf.exception;

/**
 * This is the exception class for handling scenarios when invalid details are passed.
 * @author Anchita Roy
 * @version 1.0
 */

public class InvalidDetailsException extends Exception {

	public InvalidDetailsException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InvalidDetailsException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		// TODO Auto-generated constructor stub
	}

	public InvalidDetailsException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public InvalidDetailsException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public InvalidDetailsException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

}
