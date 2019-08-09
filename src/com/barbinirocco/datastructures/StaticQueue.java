/**
 * 
 */
package com.barbinirocco.datastructures;

import com.barbinirocco.datastructures.exceptions.OverflowException;
import com.barbinirocco.datastructures.exceptions.UnderflowException;
import com.barbinirocco.datastructures.interfaces.Queue;

/**
 * Implements a queue.
 * 
 * @author rocco barbini (roccobarbi@gmail.com)
 *
 */
public class StaticQueue <T> implements Queue<T> {
	
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
	public void enqueue(T element) throws OverflowException {
		if(getCurrentSize() >= getMaxSize()) throw new OverflowException("Queue already filled to capacity!");
		if(tail == getMaxSize()) tail = 0;
		queue[tail++] = element;
		currentSize++;
	}
	
	@Override
	public T dequeue() throws UnderflowException {
		if (getCurrentSize() < 1) throw new UnderflowException("Queue already empty!");
		currentSize--;
		if(head == getMaxSize()) head = 0;
		T output = queue[head++];
		queue[head - 1] = null;
		return output;
	}

}
