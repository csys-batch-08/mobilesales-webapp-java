package com.mobilesalesapp.exception;

public class CartException extends Exception {
	
	public String cartSame() {
		
		return "Already Item is Cart";
	}
}
