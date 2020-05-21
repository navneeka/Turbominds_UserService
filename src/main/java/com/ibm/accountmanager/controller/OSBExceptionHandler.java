package com.ibm.accountmanager.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ibm.accountmanager.domain.Error;
import com.ibm.accountmanager.exception.UserAlreadyExistsException;
import com.ibm.accountmanager.exception.UserNotFoundException;

@ControllerAdvice
public class OSBExceptionHandler {

	@ExceptionHandler(value = UserNotFoundException.class)
	public Error handleException(UserNotFoundException ex) {
		Error error = new Error();
		error.setCode(100);
		error.setMessage(ex.getMessage());
		error.setFields("User login event");
		return error;
	}
	
	@ExceptionHandler(value = UserAlreadyExistsException.class)
	public Error handleException(UserAlreadyExistsException ex) {
		Error error = new Error();
		error.setCode(100);
		error.setMessage(ex.getMessage());
		error.setFields("User Registration event");
		return error;
	}
}
