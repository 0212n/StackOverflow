package com.demo.stackOverflow.domain.repo.util;

public class UserNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserNotFoundException(String userID) {
		super("User with user id : " + userID + " is not found");
		// TODO Auto-generated constructor stub
	}
	
	

}
