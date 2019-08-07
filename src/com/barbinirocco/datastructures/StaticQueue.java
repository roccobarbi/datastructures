/**
 * 
 */
package com.barbinirocco.datastructures;

import com.barbinirocco.datastructures.exceptions.OverflowException;
import com.barbinirocco.datastructures.exceptions.UnderflowException;

/**
 * Implements a queue.
 * 
 * @author rocco barbini (roccobarbi@gmail.com)
 *
 */
public class StaticQueue <T> {
	
	private T[] queue;
	private int head, tail,  maxSize, currentSize;
	
	/**
	 * Constructs a queue of the specified size and type. The sample element is only used to
	 * define the type for the queue: it is not pushed to it.
	 * 
	 * @param size The maximum size allowed for the queue.
	 * @param sample An instance of the type that will be stored in the queue.
	 */
	@SuppressWarnings("unchecked")
	public StaticQueue (int size, T sample) {
		this.maxSize = size;
		this.currentSize = 0;
		this.head = 0;
		this.tail = 0;
		queue = (T[]) (new Object[size]);
	}
	
	public int getMaxSize() {
		return maxSize;
	}
	
	public int getCurrentSize() {
		return currentSize;
	}
	
	public boolean isEmpty() {
		return getCurrentSize() == 0; 
	}
	
	public boolean isFull() {
		return getCurrentSize() == getMaxSize();
	}
	
	public void enqueue(T element) throws OverflowException {
		if(getCurrentSize() >= getMaxSize()) throw new OverflowException("Queue already filled to capacity!");
		if(tail == getMaxSize()) tail = 0;
		queue[tail++] = element;
		currentSize++;
	}
	
	public T dequeue() throws UnderflowException {
		if (getCurrentSize() < 1) throw new UnderflowException("Queue already empty!");
		currentSize--;
		if(head == getMaxSize()) head = 0;
		return queue[head++];
	}

}
