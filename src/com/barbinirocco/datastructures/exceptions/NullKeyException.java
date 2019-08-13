/**
 * 
 */
package com.barbinirocco.datastructures.exceptions;

/**
 * @author rocco barbini (roccobarbi@gmail.com)
 *
 */
public class NullKeyException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3824640738345239077L;

	public NullKeyException() {
		super("Null Key Exception!");
	}
	
	public NullKeyException(String msg) {
		super(msg);
	}

}
