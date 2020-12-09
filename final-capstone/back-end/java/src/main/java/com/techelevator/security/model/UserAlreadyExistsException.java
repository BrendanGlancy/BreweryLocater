package com.techelevator.security.model;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus( value = HttpStatus.BAD_REQUEST, reason = "User Already Exists.")
public class UserAlreadyExistsException extends RuntimeException {
	private static final long serialVersionUID = 1L;
}
