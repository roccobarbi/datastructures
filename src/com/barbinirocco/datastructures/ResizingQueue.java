/**
 * 
 */
package com.barbinirocco.datastructures;

import com.barbinirocco.datastructures.exceptions.OverflowException;
import com.barbinirocco.datastructures.exceptions.UnderflowException;
import com.barbinirocco.datastructures.interfaces.Queue;

/**
 * @author rocco barbini (roccobarbi@gmail.com)
 * @param <T> the type contained in the queue
 *
 */
public class ResizingQueue<T> implements Queue<T> {
	
	private T[] queue;
	private int head, tail,  maxSize, currentSize, upperBound, lowerBound;
	private static final int minSize = 10;
	
	public ResizingQueue(int size, T sample) {
		this.maxSize = size >= minSize ? size : minSize;
		this.currentSize = 0;
		this.head = 0;
		this.tail = 0;
		this.queue = (T[]) (new Object[maxSize]);
		calculateBounds();
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
	public void enqueue(T element) throws OverflowException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T dequeue() throws UnderflowException {
		// TODO Auto-generated method stub
		return null;
	}

}
