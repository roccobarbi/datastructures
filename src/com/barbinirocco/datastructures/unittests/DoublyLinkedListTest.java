package com.barbinirocco.datastructures.unittests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import com.barbinirocco.datastructures.DoublyLinkedList;

class DoublyLinkedListTest {

	@Test
	void testConstruction() {
		@SuppressWarnings("unused")
		DoublyLinkedList<Integer, String> list = null;
		try {
			list = new DoublyLinkedList<Integer, String>(Integer.valueOf(1), "");
		} catch (Exception e) {
			fail("Exception while creating an integer, String List!");
		}
	}

	@Test
	void testIsEmpty() {
		DoublyLinkedList<Integer, String> list = new DoublyLinkedList<Integer, String>(Integer.valueOf(1), "");
		assertTrue(list.isEmpty(), "Newly created list is not empty");
		list.insert(0, "Test");
		assertFalse(list.isEmpty(), "List appears empty after inserting a key-value pair");
	}

	@Test
	void testInsert() {
		DoublyLinkedList<Integer, String> list = new DoublyLinkedList<Integer, String>(Integer.valueOf(1), "");
		try {
			for (int i = 0; i < 50; i++) {
				list.insert(i, String.valueOf(i));
			}
		} catch (Exception e) {
			e.printStackTrace();
			fail("Exception while inserting!");
		}
	}

	@Test
	void testSearch() {
		String value = null;
		int key;
		DoublyLinkedList<Integer, String> list = new DoublyLinkedList<Integer, String>(Integer.valueOf(1), "");
		for (int i = 0; i < 50; i++) {
			list.insert(i, String.valueOf(i));
		}
		try {
			key = (int) (Math.random() * 50);
			value = list.search(key);
			assertTrue(String.valueOf(key).equals(value),
					"Wrong value found, expected " + String.valueOf(key) + " but found " + value + " instead!");
			assertTrue(value.equals(list.search(key)), "Searching the same thing twice did non yield equal results!");
		} catch (Exception e) {
			e.printStackTrace();
			fail("Exception while searching!");
		}
	}

	@Test
	void testDelete() {
		String value = null;
		int key;
		DoublyLinkedList<Integer, String> list = new DoublyLinkedList<Integer, String>(Integer.valueOf(1), "");
		for (int i = 0; i < 50; i++) {
			list.insert(i, String.valueOf(i));
		}
		try {
			System.out.println("Testing random deletion.");
			key = (int) (Math.random() * 50);
			value = list.delete(key);
			assertTrue(String.valueOf(key).equals(value),
					"Wrong value found, expected " + String.valueOf(key) + " but found " + value + " instead!");
			assertTrue(list.delete(key) == null, "Could delete the same element twice, though only one was present.");
			assertTrue(list.search(key) == null, "Could find the same element again, though only one was present.");
		} catch (Exception e) {
			e.printStackTrace();
			fail("Exception while deleting!");
		}
		try {
			System.out.println("Testing multiple deletion.");
			list = new DoublyLinkedList<Integer, String>(Integer.valueOf(1), "");
			list.insert(1, "1");
			list.insert(2, "2");
			list.insert(3, "3");
			list.insert(1, "1");
			list.insert(2, "2");
			value = list.delete(1);
			assertTrue(value.equals("1"), "Wrong value found, expected 1 but found " + value + " instead!");
			assertTrue(list.search(1).equals(value), "Could not find the same element after deleting, though it was present twice.");
			assertTrue(list.delete(1).equals(value), "Could not delete the same element twice, though it was present twice.");
		} catch (Exception e) {
			e.printStackTrace();
			fail("Exception while deleting!");
		}
	}

}
