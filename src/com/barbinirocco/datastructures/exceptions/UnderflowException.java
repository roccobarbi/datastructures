package com.barbinirocco.datastructures.exceptions;

public class UnderflowException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2403002901596392455L;

	/**
	 * 
	 */

	public UnderflowException() {
		super("Underflow Exception!");
	}
	
	public UnderflowException(String msg) {
		super(msg);
	}
}
