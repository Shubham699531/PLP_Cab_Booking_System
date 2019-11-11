package com.cg.cbs.pf.exception;

/**
 * This is the exception class for handling insufficient wallet balance cases during transactions.
 * @author Anchita Roy
 * @version 1.0
 */

public class InsufficientWalletBalanceException extends Exception {

	public InsufficientWalletBalanceException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InsufficientWalletBalanceException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		// TODO Auto-generated constructor stub
	}

	public InsufficientWalletBalanceException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public InsufficientWalletBalanceException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public InsufficientWalletBalanceException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

}
