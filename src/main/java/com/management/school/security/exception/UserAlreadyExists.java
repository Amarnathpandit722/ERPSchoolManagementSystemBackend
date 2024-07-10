package com.management.school.security.exception;

public class UserAlreadyExists extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8494990288814972842L;

	public UserAlreadyExists(String msg)
	{
		super(msg);
	}
}
