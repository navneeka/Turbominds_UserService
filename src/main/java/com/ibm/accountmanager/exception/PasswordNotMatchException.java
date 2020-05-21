package com.ibm.accountmanager.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.UNAUTHORIZED,reason = "Given Password Not Matched for this User")
public class PasswordNotMatchException extends Exception {
	private static final long serialVersionUID = 1L;

}