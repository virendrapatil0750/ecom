package com.ecom.excemption;

public class UserAlreadyExist extends RuntimeException {
	private String message;

	public UserAlreadyExist() {}
	public UserAlreadyExist(String message) {
		super(message);
		this.message = message;
	}
	
	
}
