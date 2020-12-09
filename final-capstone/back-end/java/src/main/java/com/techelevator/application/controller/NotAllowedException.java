package com.techelevator.application.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/****************************************
 * When the user is not authorized, send back 401 
 *
 ***/

@ResponseStatus(code=HttpStatus.UNAUTHORIZED)
public class NotAllowedException extends Exception {
	
	
}
