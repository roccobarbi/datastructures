package com.barbinirocco.datastructures.unittests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import com.barbinirocco.datastructures.ResizingStack;
import com.barbinirocco.datastructures.exceptions.OverflowException;
import com.barbinirocco.datastructures.exceptions.UnderflowException;

class ResizingStackTest {

	@Test
	void testConstruction() {
		int size = 5;
		@SuppressWarnings("unused")
		ResizingStack<Integer> stack = null;
		try {
			stack = new ResizingStack<Integer>(size, Integer.valueOf(1));
		} catch (Exception e) {
			fail("Exception while creating an integer Stack!");
		}
	}
	
	@Test
	void testIsEmpty() {
		int size = 5;
		ResizingStack<Integer> stack =  new ResizingStack<Integer>(size, Integer.valueOf(1));
		assertTrue(stack.isEmpty(), "Stack appears not to be empty when it is!");
		try {
			stack.push(1);
		} catch (OverflowException e) {
			e.printStackTrace();
			fail("Overflow on the first element!");
		}
		assertFalse(stack.isEmpty(), "Stack appears empty when it is not!");
	}

	@Test
	void testIsFull() {
		int size = 5;
		ResizingStack<Integer> stack =  new ResizingStack<Integer>(size, Integer.valueOf(1));
		assertFalse(stack.isFull(), "Newly created stack appears full!");
		try {
			for (int i = 0; i < 50; i++)
				stack.push(1);
		} catch (OverflowException e) {
			e.printStackTrace();
			fail("Overflow, the stack should resize and never overflow!");
		}
		assertFalse(stack.isFull(), "Stack full, this should never happen due to resizing!");
	}

	@Test
	void testPush() {
		int size = 5;
		ResizingStack<Integer> stack =  new ResizingStack<Integer>(size, Integer.valueOf(1));
		try {
			for (int i = 0; i < 50; i++)
				stack.push(1);
		} catch (OverflowException e) {
			e.printStackTrace();
			fail("Overflow, the stack should resize and never overflow!");
		} catch (Exception e) {
			e.printStackTrace();
			fail("Exception while pushing!");
		}
	}

	@Test
	void testPop() {
		int size = 5, el;
		ResizingStack<Integer> stack =  new ResizingStack<Integer>(size, Integer.valueOf(1));
		try {
			for (int i = 0; i < 50; i++)
				stack.push(i);
		} catch (OverflowException e) {
			e.printStackTrace();
			fail("Overflow, the stack should resize and never overflow!");
		} catch (Exception e) {
			e.printStackTrace();
			fail("Exception while pushing!");
		}
		try {
			for (int i = 49; i > -1; i--) {
				el = stack.pop();
				assertTrue(el == i, "Wrong element popped!");
			}
		} catch (UnderflowException e) {
			e.printStackTrace();
			fail("Underflow before reaching zero!");
		} catch (Exception e) {
			e.printStackTrace();
			fail("Exception while popping!");
		}
		try {
			stack.pop();
			fail("Popping empty stack did not underflow!");
		} catch (UnderflowException e) {
			// Passed
		} catch (Exception e) {
			e.printStackTrace();
			fail("Exception while popping!");
		}
	}

}
