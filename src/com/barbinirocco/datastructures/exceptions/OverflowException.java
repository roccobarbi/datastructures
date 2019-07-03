package com.barbinirocco.datastructures.exceptions;

public class OverflowException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4545637242419759445L;

	public OverflowException() {
		super("Overflow Exception!");
	}
	
	public OverflowException(String msg) {
		super(msg);
	}
}
