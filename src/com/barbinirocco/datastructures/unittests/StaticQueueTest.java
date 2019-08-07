package com.barbinirocco.datastructures.unittests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import com.barbinirocco.datastructures.StaticQueue;
import com.barbinirocco.datastructures.exceptions.OverflowException;
import com.barbinirocco.datastructures.exceptions.UnderflowException;

/**
 * @author rocco barbini (roccobarbi@gmail.com)
 *
 */
class QueueTest {

	@Test
	void testConstruction() {
		int size = 20;
		StaticQueue<Integer> queue = null;
		try {
			queue = new StaticQueue<Integer>(size, Integer.valueOf(1));
		} catch (Exception e) {
			fail("Exception while creating an integer Queue.");
		}
		try {
			assertTrue(queue.getMaxSize() == size, "getMaxSize does not return the correct size!");
			assertTrue(queue.getCurrentSize() == 0, "getCurrentSize does not return the correct size!");
		} catch (Exception e) {
			fail("Exception while getting sizes!");
		}
		try {
			assertTrue(queue.isEmpty(), "Queue does not appear empty when it is!");
			assertFalse(queue.isFull(), "Queue appears full when it is not!");
		} catch (Exception e) {
			fail("Exception while checking full and empty!");
		}
	}
	
	@Test
	void testEnqueue() {
		int size = 5;
		StaticQueue<Integer> queue = new StaticQueue<Integer>(size, Integer.valueOf(1));
		try {
			for(int i = 0; i < size; i++) {
				queue.enqueue(i);
			}
			assertTrue(queue.getCurrentSize() == queue.getMaxSize(), "Queue size not equal to max after filling to capacity!");
		} catch (Exception e) {
			fail("Exception while enqueuing to capacity!");
		}
		try {
			queue.enqueue(5);
			fail("Queue can be filled beyond capacity!");
		} catch (OverflowException e) {
			; // passed
		} catch (Exception e) {
			fail("Wrong Exception while enqueuing beyond capacity!");
		}
	}
	
	@Test
	void testDeueue() {
		int size = 5;
		int el;
		StaticQueue<Integer> queue = new StaticQueue<Integer>(size, Integer.valueOf(1));
		try {
			for(int i = 0; i < size; i++) {
				queue.enqueue(i);
			}
		} catch (Exception e) {
			;
		}
		try {
			for(int i = 0; i < size; i++) {
				el = queue.dequeue();
				assertTrue(el == i, "Dequeued wrong value!");
			}
			assertTrue(queue.getCurrentSize() == 0, "Size is not zero after emptying queue!");
		} catch (UnderflowException e) {
			fail("UnderflowException while dequeueuing to zero!");
		} catch (Exception e) {
			fail("Exception while dequeuing to zero!");
		}
		try {
			el = queue.dequeue();
			fail("Did not underflow after dequeueing empty queue!");
		} catch (UnderflowException e) {
			; // passed
		} catch (Exception e) {
			fail("Wrong Exception while dequeueing beyond capacity!");
		}
	}
	
	@Test
	void testEnqDeqEnq() {
		int size = 5;
		int[] values = {0, 1, 2, 3, 4, 5, 6};
		int currentElement = 0, dequeued = -1, el;
		StaticQueue<Integer> queue = new StaticQueue<Integer>(size, Integer.valueOf(1));
		try {
			for(int i = 0; i < size; i++) {
				queue.enqueue(values[currentElement++]);
			}
			queue.dequeue();
			dequeued++;
			queue.dequeue();
			dequeued++;
		} catch (Exception e) {
			;
		}
		try {
			queue.enqueue(values[currentElement++]);
			queue.enqueue(values[currentElement++]);
			assertTrue(queue.getCurrentSize() == queue.getMaxSize(), "Queue size not equal to max after filling to capacity again!");
		} catch (Exception e) {
			fail("Exception while filling up again!");
		}
		try {
			el = queue.dequeue();
			dequeued++;
			assertTrue(el == values[dequeued], "Dequeued wrong element at second pass!");
			el = queue.dequeue();
			dequeued++;
			assertTrue(el == values[dequeued], "Dequeued wrong element at second pass!");
		} catch (Exception e) {
			fail("Exception while dequeueing again!");
		}
	}

}
