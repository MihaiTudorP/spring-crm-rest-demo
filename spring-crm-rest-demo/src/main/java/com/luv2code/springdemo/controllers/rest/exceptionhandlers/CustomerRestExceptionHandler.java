/**
 * 
 */
package com.luv2code.springdemo.controllers.rest.exceptionhandlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.luv2code.springdemo.controllers.rest.exceptionhandlers.exceptions.CustomerNotFoundException;
import com.luv2code.springdemo.controllers.rest.exceptionhandlers.responses.CustomerExceptionResponse;

/**
 * @author Mihai-Tudor Popescu
 *
 */
@ControllerAdvice
public class CustomerRestExceptionHandler {
	// Exception handler for CustomerNotFoundException
	@ExceptionHandler
	public ResponseEntity<CustomerExceptionResponse> handleException(CustomerNotFoundException exc){
		// create CustomerExceptionResponse
		CustomerExceptionResponse customerExceptionResponse = new CustomerExceptionResponse(HttpStatus.NOT_FOUND.value(), exc.getMessage(), System.currentTimeMillis());
		// return ResponseEntity
		return new ResponseEntity<> (customerExceptionResponse, HttpStatus.NOT_FOUND);
	}
	// Exception handler for any other exceptions (catch all)
	@ExceptionHandler
	public ResponseEntity<CustomerExceptionResponse> handleException(Exception exc){
		// create CustomerExceptionResponse
		CustomerExceptionResponse customerExceptionResponse = new CustomerExceptionResponse(HttpStatus.BAD_REQUEST.value(), exc.getMessage(), System.currentTimeMillis());
		// return ResponseEntity
		return new ResponseEntity<> (customerExceptionResponse, HttpStatus.BAD_REQUEST);
	}
}
