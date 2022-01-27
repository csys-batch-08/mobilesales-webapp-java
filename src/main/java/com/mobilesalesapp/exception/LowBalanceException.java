package com.mobilesalesapp.exception;

public class LowBalanceException extends Exception {
	
	private static final long serialVersionUID = 1L;
	private static final String MESSAGE="LowBalance.jsp";
	public String lowBal() {
		
		return MESSAGE;
	}

}
