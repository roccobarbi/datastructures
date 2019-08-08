/**
 * 
 */
package com.barbinirocco.datastructures;

import com.barbinirocco.datastructures.exceptions.OverflowException;
import com.barbinirocco.datastructures.exceptions.UnderflowException;
import com.barbinirocco.datastructures.interfaces.Stack;

/**
 * Implements a resizable Stack
 * 
 * @author rocco barbini (roccobarbi@gmail.com)
 * @param <T> the type contained in the stack
 *
 */
public class ResizingStack<T> implements Stack<T> {
	
	private T[] stack;
	private int lowerBound, upperBound, currentSize, maxSize;
	private static final int minSize = 10;
	
	@SuppressWarnings("unchecked")
	public ResizingStack (int size, T sample) {
		this.maxSize = size >= minSize ? size : minSize;
		this.currentSize = 0;
		this.stack = (T[]) (new Object[size]);
		calculateBounds();
	}
	
	private void checkResize() {
		if (currentSize >= upperBound) {
			resizeStack(maxSize * 2);
		} else if (currentSize <= lowerBound) {
			resizeStack((maxSize * 2) / 3);
		}
	}
	
	private void resizeStack(int size) {
		this.maxSize = size >= minSize ? size : minSize;
		@SuppressWarnings("unchecked")
		T[] resizedStack = (T[]) (new Object[this.maxSize]);
		for (int i = 0; i < currentSize; i++) {
			resizedStack[i] = stack[i];
		}
		stack = resizedStack;
	}
	
	private void calculateBounds() {
		lowerBound = maxSize >= minSize * 2 ? this.maxSize / 2 : -1;
		upperBound = (this.maxSize * 9) / 10;
	}

	@Override
	public boolean isEmpty() {
		return currentSize == 0;
	}

	@Override
	public boolean isFull() {
		return currentSize == maxSize;
	}

	@Override
	public void push(T element) throws OverflowException {
		stack[currentSize++] = element;
		checkResize();
	}

	@Override
	public T pop() throws UnderflowException {
		if (isEmpty()) throw new UnderflowException("Tried popping an empty stack!");
		T output = stack[--currentSize];
		checkResize();
		return output;
	}

}
