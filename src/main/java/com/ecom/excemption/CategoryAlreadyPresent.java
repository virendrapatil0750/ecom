package com.ecom.excemption;

public class CategoryAlreadyPresent extends RuntimeException {
	private String message;
	
	public CategoryAlreadyPresent() {}
	
	public CategoryAlreadyPresent(String message) {
		super(message);
		this.message = message;
	}
	
	
}
