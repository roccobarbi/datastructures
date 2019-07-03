/**
 * 
 */
package com.barbinirocco.datastructures.unittests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import com.barbinirocco.datastructures.Stack;
import com.barbinirocco.datastructures.exceptions.OverflowException;
import com.barbinirocco.datastructures.exceptions.UnderflowException;

/**
 * @author rocco barbini (roccobarbi@gmail.com)
 *
 */
class StackTest {

	@Test
	void testConstruction() {
		int size = 20;
		Stack<Integer> stack = null;
		try {
			stack = new Stack<Integer>(size, Integer.valueOf(1));
		} catch (Exception e) {
			fail("Exception while creating an integer Stack.");
		}
		try {
			assertTrue(stack.getMaxSize() == size, "getMaxSize does not return the correct size!");
			assertTrue(stack.getCurrentSize() == 0, "getCurrentSize does not return the correct size!");
		} catch (Exception e) {
			fail("Exception while getting sizes!");
		}
		try {
			assertTrue(stack.isEmpty(), "Stack does not appear empty when it is!");
			assertFalse(stack.isFull(), "Stack appears full when it is not!");
		} catch (Exception e) {
			fail("Exception while checking full and empty!");
		}
	}
	
	@Test
	void testPushing() {
		int size = 20;
		Stack<Integer> stack = new Stack<Integer>(size, Integer.valueOf(1));
		try {
			stack.push(1);
			stack.push(2);
			stack.push(3);
		} catch (Exception e) {
			fail("Exception while pushing integers to the stack!");
		}
		try {
			assertTrue(stack.getMaxSize() == size, "getMaxSize does not return the correct size!");
			assertTrue(stack.getCurrentSize() == 3, "getCurrentSize does not return the correct size!");
		} catch (Exception e) {
			fail("Exception while getting sizes!");
		}
		try {
			assertFalse(stack.isEmpty(), "Stack appears empty when it is not!");
			assertFalse(stack.isFull(), "Stack appears full when it is not!");
		} catch (Exception e) {
			fail("Exception while checking full and empty!");
		}
	}
	
	@Test
	void testPopping() {
		int size = 20;
		Stack<Integer> stack = new Stack<Integer>(size, Integer.valueOf(1));
		try {
		stack.push(1);
		stack.push(2);
		stack.push(3);
		} catch (Exception e) {
			fail("Exception while pushing!");
		}
		try {
			assertTrue(stack.pop() == Integer.valueOf(3), "Popped the wrong element!");
			assertTrue(stack.pop() == Integer.valueOf(2), "Popped the wrong element!");
			assertTrue(stack.pop() == Integer.valueOf(1), "Popped the wrong element!");
		} catch (Exception e) {
			fail("Exception while popping integers from the stack!");
		}
		try {
			assertTrue(stack.isEmpty(), "Stack does not appear empty when it is!");
			assertFalse(stack.isFull(), "Stack appears full when it is not!");
		} catch (Exception e) {
			fail("Exception while checking full and empty!");
		}
		// TODO: check also exceptions are thrown on overflow and underflow
	}
	
	@Test
	void testExceptions() {
		int size = 20;
		Stack<Integer> stack = new Stack<Integer>(size, Integer.valueOf(1));
		try {
			for (int i = 0; i < 21; i++) stack.push(i);
			fail("Did not throw OverflowException when currentSize reached maxSize!");
		} catch (OverflowException e) {
			// ok
		} catch (Exception e) {
			fail("Exception (different from the expected OverflowException) while pushing!");
		}
		stack = new Stack<Integer>(size, Integer.valueOf(1));
		try {
			stack.pop();
			fail("Did not throw OverflowException when currentSize reached maxSize!");
		} catch (UnderflowException e) {
			// ok
		} catch (Exception e) {
			fail("Exception (different from the expected UnderflowException) while popping!");
		}
	}

}
