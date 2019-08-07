/**
 * 
 */
package com.barbinirocco.datastructures.interfaces;

/**
 * Defines the basic operations of a Stack.
 * 
 * @author rocco barbini (roccobarbi@gmail.com)
 *
 */
public interface Stack <T> {
	
	/**
	 * 
	 * @return true if the stack is empty.
	 */
	public boolean isEmpty();
	
	/**
	 * 
	 * @return true if the stack is full
	 */
	public boolean isFull();
	
	/**
	 * Enters a new element into the stack.
	 * 
	 * @param Element
	 */
	public void push(T Element);
	
	/**
	 * 
	 * @return the last element added to the stack, which is removed from it.
	 */
	public T pop();
}
