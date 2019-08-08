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
	
	@SuppressWarnings("unchecked")
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
	
	private T staticDequeue() throws UnderflowException {
		if (currentSize < 1) throw new UnderflowException("Queue already empty!");
		currentSize--;
		if(head == maxSize) head = 0;
		return queue[head++];
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
		if(currentSize >= maxSize) throw new OverflowException("Queue already filled to capacity!");
		if(tail == maxSize) tail = 0;
		queue[tail++] = element;
		currentSize++;
		
	}

	@Override
	public T dequeue() throws UnderflowException {
		if (currentSize < 1) throw new UnderflowException("Queue already empty!");
		currentSize--;
		if(head == maxSize) head = 0;
		return queue[head++];
	}

}
