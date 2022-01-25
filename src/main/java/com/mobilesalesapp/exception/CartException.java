package com.mobilesalesapp.exception;

public class CartException extends Exception {

	private static final long serialVersionUID = 1L;
	private static final String MESSAGE="Already Item is Cart";
	public String cartSame() {
		
		return MESSAGE;
	}
}
