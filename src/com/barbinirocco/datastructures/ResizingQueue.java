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

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		return false;
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
