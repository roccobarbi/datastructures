/**
 * 
 */
package com.barbinirocco.datastructures;

import com.barbinirocco.datastructures.exceptions.OverflowException;
import com.barbinirocco.datastructures.exceptions.UnderflowException;
import com.barbinirocco.datastructures.interfaces.Stack;

/**
 * Implements a non-resizable stack.
 * 
 * @author rocco barbini (roccobarbi@gmail.com)
 *
 */
public class StaticStack <T> implements Stack<T> {
	
	private T[] stack;
	private int maxSize;
	private int currentSize;
	
	/**
	 * Constructs a stack of the specified size and type. The sample element is only used to
	 * define the type for the stack: it is not pushed to it.
	 * 
	 * @param size The maximum size allowed for the stack.
	 * @param sample An instance of the type that will be stored in the stack.
	 */
	@SuppressWarnings("unchecked")
	public StaticStack (int size, T sample) {
		this.maxSize = size;
		this.currentSize = 0;
		stack = (T[]) (new Object[size]);
	}
	
	private int getMaxSize() {
		return maxSize;
	}
	
	private int getCurrentSize() {
		return currentSize;
	}
	
	@Override
	public boolean isEmpty() {
		return getCurrentSize() == 0; 
	}
	
	@Override
	public boolean isFull() {
		return getCurrentSize() == getMaxSize();
	}
	
	@Override
	public void push(T element) throws OverflowException {
		if (isFull()) throw new OverflowException("Tried pushing a full stack!");
		stack[currentSize++] = element;
	}
	
	@Override
	public T pop() throws UnderflowException {
		if (isEmpty()) throw new UnderflowException("Tried popping an empty stack!");
		return stack[--currentSize];
	}

}
