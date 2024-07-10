package com.management.school.security.exception;

public class StudentAlreadyExistException extends RuntimeException {

	public StudentAlreadyExistException(String msg) {
		super(msg);
	}
	
}
