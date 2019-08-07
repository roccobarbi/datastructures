package com.barbinirocco.datastructures.interfaces;

import com.barbinirocco.datastructures.exceptions.OverflowException;
import com.barbinirocco.datastructures.exceptions.UnderflowException;

/**
 * Defines the basic operations of a Queue.
 * 
 * @author rocco barbini (roccobarbi@gmail.com)
 *
 */
public interface Queue<T> {

	boolean isEmpty();

	boolean isFull();

	void enqueue(T element) throws OverflowException;

	T dequeue() throws UnderflowException;

}