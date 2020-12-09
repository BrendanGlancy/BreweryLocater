package com.techelevator.application.controller;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/****************************************
 * When the is no content
 *
 ***/

@ResponseStatus(code=HttpStatus.NOT_FOUND)
public class NotFoundException extends Exception {

}
