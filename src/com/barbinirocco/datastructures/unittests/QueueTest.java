package com.barbinirocco.datastructures.unittests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import com.barbinirocco.datastructures.Queue;
import com.barbinirocco.datastructures.Stack;
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
		Queue<Integer> queue = null;
		try {
			queue = new Queue<Integer>(size, Integer.valueOf(1));
		} catch (Exception e) {
			fail("Exception while creating an integer Stack.");
		}
		try {
			assertTrue(queue.getMaxSize() == size, "getMaxSize does not return the correct size!");
			assertTrue(queue.getCurrentSize() == 0, "getCurrentSize does not return the correct size!");
		} catch (Exception e) {
			fail("Exception while getting sizes!");
		}
		try {
			assertTrue(queue.isEmpty(), "Stack does not appear empty when it is!");
			assertFalse(queue.isFull(), "Stack appears full when it is not!");
		} catch (Exception e) {
			fail("Exception while checking full and empty!");
		}
	}
	
	@Test
	void testEnqueue() {
		fail("Not yet implemented");
	}
	
	@Test
	void testDeueue() {
		fail("Not yet implemented");
	}

}
