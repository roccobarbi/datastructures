package com.barbinirocco.datastructures.unittests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.barbinirocco.datastructures.ResizingQueue;
import com.barbinirocco.datastructures.exceptions.OverflowException;
import com.barbinirocco.datastructures.exceptions.UnderflowException;

class ResizingQueueTest {

	@Test
	void testConstruction() {
		int size = 5;
		@SuppressWarnings("unused")
		ResizingQueue<Integer> queue = null;
		try {
			queue = new ResizingQueue<Integer>(size, Integer.valueOf(1));
		} catch (Exception e) {
			fail("Exception while creating an integer Queue!");
		}
	}

	@Test
	void testIsEmpty() {
		int size = 5;
		ResizingQueue<Integer> queue =  new ResizingQueue<Integer>(size, Integer.valueOf(1));
		assertTrue(queue.isEmpty(), "Queue appears not to be empty when it is!");
		try {
			queue.enqueue(1);
		} catch (OverflowException e) {
			e.printStackTrace();
			fail("Overflow on the first element!");
		}
		assertFalse(queue.isEmpty(), "Queue appears empty when it is not!");
	}

	@Test
	void testIsFull() {
		int size = 10;
		ResizingQueue<Integer> queue =  new ResizingQueue<Integer>(size, Integer.valueOf(1));
		assertFalse(queue.isFull(), "Newly created queue appears full!");
		try {
			for (int i = 0; i < 10; i++)
				queue.enqueue(i);
		} catch (OverflowException e) {
			e.printStackTrace();
			fail("Overflow, the queue should resize and never overflow!");
		}
		assertFalse(queue.isFull(), "Queue full, this should never happen due to resizing!");
	}

	@Test
	void testEnqueue() {
		int size = 5;
		ResizingQueue<Integer> queue =  new ResizingQueue<Integer>(size, Integer.valueOf(1));
		try {
			for (int i = 0; i < 50; i++)
				queue.enqueue(1);
		} catch (OverflowException e) {
			e.printStackTrace();
			fail("Overflow, the queue should resize and never overflow!");
		} catch (Exception e) {
			e.printStackTrace();
			fail("Exception while enqueueing!");
		}
	}

	@Test
	void testDequeue() {
		int size = 10, el;
		ResizingQueue<Integer> queue =  new ResizingQueue<Integer>(size, Integer.valueOf(1));
		try {
			for (int i = 0; i < 50; i++)
				queue.enqueue(i);
		} catch (OverflowException e) {
			e.printStackTrace();
			fail("Overflow, the queue should resize and never overflow!");
		} catch (Exception e) {
			e.printStackTrace();
			fail("Exception while enqueueing!");
		}
		try {
			for (int i = 0; i < 50; i++) {
				el = queue.dequeue();
				assertTrue(el == i, "Wrong element dequeued!");
			}
		} catch (UnderflowException e) {
			e.printStackTrace();
			fail("Underflow before reaching zero!");
		} catch (Exception e) {
			e.printStackTrace();
			fail("Exception while dequeueing!");
		}
		try {
			queue.dequeue();
			fail("Dequeueing empty queue did not underflow!");
		} catch (UnderflowException e) {
			// Passed
		} catch (Exception e) {
			e.printStackTrace();
			fail("Exception while dequeueing!");
		}
	}

}
