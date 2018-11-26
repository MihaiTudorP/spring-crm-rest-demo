/**
 * 
 */
package com.luv2code.springdemo.controllers.rest.exceptionhandlers.exceptions;

/**
 * @author Mihai-Tudor Popescu
 *
 */
public class CustomerNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1657963451990061996L;

	/**
	 * 
	 */
	public CustomerNotFoundException() {
	}

	/**
	 * @param arg0
	 */
	public CustomerNotFoundException(String arg0) {
		super(arg0);
	}

	/**
	 * @param arg0
	 */
	public CustomerNotFoundException(Throwable arg0) {
		super(arg0);
	}

	/**
	 * @param arg0
	 * @param arg1
	 */
	public CustomerNotFoundException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	/**
	 * @param arg0
	 * @param arg1
	 * @param arg2
	 * @param arg3
	 */
	public CustomerNotFoundException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		// TODO Auto-generated constructor stub
	}

}
