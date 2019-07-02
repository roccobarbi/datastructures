/**
 * 
 */
package com.barbinirocco.datastructures;

/**
 * Implements a non-resizable stack.
 * 
 * @author rocco barbini (roccobarbi@gmail.com)
 *
 */
public class Stack <T> {
	
	private T[] stack;
	private int maxSize;
	private int currentSize;
	
	/**
	 * Constructs a stack of the specified size and type. The sample element is only used to
	 * define the type for the stack: it is not pushed to it.
	 * 
	 * @param size The maximum size allowed for the stack.
	 * @param sample An instance of the type that will be stored in the class.
	 */
	@SuppressWarnings("unchecked")
	public Stack (int size, T sample) {
		this.maxSize = size;
		this.currentSize = 0;
		stack = (T[]) (new Object[size]);
	}

}
