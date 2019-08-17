/**
 * 
 */
package com.barbinirocco.datastructures.unittests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import com.barbinirocco.datastructures.ConcreteHashTable;
import com.barbinirocco.datastructures.exceptions.NullKeyException;
import com.barbinirocco.datastructures.interfaces.HashTable;

/**
 * @author rocco barbini (roccobarbi@gmail.com)
 *
 */
class ConcreteHashTableTest {

	/**
	 * Test method for {@link com.barbinirocco.datastructures.ConcreteHashTable#ConcreteHashTable(K, V)}.
	 */
	@Test
	void testConstructor() {
		try {
			@SuppressWarnings("unused")
			HashTable<String, Integer> table = new ConcreteHashTable<String, Integer>("", Integer.valueOf(1));
		} catch (Exception e) {
			e.printStackTrace();
			fail("Exception during construction without minSize!");
		}
		try {
			@SuppressWarnings("unused")
			HashTable<String, Integer> table = new ConcreteHashTable<String, Integer>("", Integer.valueOf(1), 64);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Exception during construction with minSize!");
		}
	}
	
	/**
	 * Test method for {@link com.barbinirocco.datastructures.ConcreteHashTable#insert(K, V)}.
	 */
	@Test
	void testInsert() {
		HashTable<String, Integer> table = new ConcreteHashTable<String, Integer>("", Integer.valueOf(1));
		try {
			table.insert("ciccio", 0);
		} catch (NullKeyException e) {
			e.printStackTrace();
			fail("NullKeyException while inserting valid key and valid value!");
		} catch (Exception e) {
			e.printStackTrace();
			fail("Exception while inserting valid key and valid value!");
		}
		assertTrue(table.search("ciccio") == 0, "Inserting a key-value pair did not store it!");
		try {
			table.insert("pasticcio", null);
		} catch (NullKeyException e) {
			e.printStackTrace();
			fail("NullKeyException while inserting valid key and null value!");
		} catch (Exception e) {
			e.printStackTrace();
			fail("Exception while inserting valid key and null value!");
		}
		assertTrue(table.search("ciccio") == 0, "Inserting a new key-value pair deleted other key-value pairs!");
		try {
			table.insert("ciccio", 0);
		} catch (NullKeyException e) {
			e.printStackTrace();
			fail("NullKeyException while inserting valid key a second time with same value!");
		} catch (Exception e) {
			e.printStackTrace();
			fail("Exception while inserting valid key a second time with same value!");
		}
		try {
			table.insert("ciccio", 1);
		} catch (NullKeyException e) {
			e.printStackTrace();
			fail("NullKeyException while inserting valid key a third time with different value!");
		} catch (Exception e) {
			e.printStackTrace();
			fail("Exception while inserting valid key a third time with different value!");
		}
		assertTrue(table.search("ciccio") == 1, "The last insert did not overwrite the value for the key!");
		try {
			table.insert(null, 0);
			fail("NullKeyException not thrown when inserting null key!");
		} catch (NullKeyException e) {
			// pass
		} catch (Exception e) {
			e.printStackTrace();
			fail("Wrong exception thrown when inserting null key!!");
		}
		for (int i = 0; i < 1024; i++) {
			try {
				table.insert(Integer.toString(i), i);
			} catch (NullKeyException e) {
				e.printStackTrace();
				fail("NullKeyException while inserting valid key during resize testing!");
			} catch (Exception e) {
				e.printStackTrace();
				fail("Exception while inserting valid key during resize testing!");
			}
		}
	}

	/**
	 * Test method for {@link com.barbinirocco.datastructures.ConcreteHashTable#search(K)}.
	 */
	@Test
	void testSearch() {
		HashTable<String, Integer> table = new ConcreteHashTable<String, Integer>("", Integer.valueOf(1));
		try {
			table.insert("ciccio", 0);
		} catch (NullKeyException e) {
			e.printStackTrace();
		}
		try {
			assertTrue(table.search("ciccio") == 0, "Existing key not found!");
		} catch (Exception e) {
			fail("Exception while searching!");
		}
		try {
			table.insert("ciccio", 1);
		} catch (NullKeyException e) {
			e.printStackTrace();
		}
		try {
			assertTrue(table.search("ciccio") == 1, "Existing key not found!");
		} catch (Exception e) {
			fail("Exception while searching!");
		}
		try {
			assertTrue(table.search(null) == null, "Searching for a null key did not return a null value!");
		} catch (Exception e) {
			e.printStackTrace();
			fail("Exception while searching for a null key!");
		}
	}

	/**
	 * Test method for {@link com.barbinirocco.datastructures.ConcreteHashTable#delete(K)}.
	 */
	@Test
	void testDelete() {
		HashTable<String, Integer> table = new ConcreteHashTable<String, Integer>("", Integer.valueOf(1));
		try {
			table.insert("ciccio", 0);
		} catch (NullKeyException e) {
			e.printStackTrace();
		}
		try {
			table.insert("ciccio", 1);
		} catch (NullKeyException e) {
			e.printStackTrace();
		}
		try {
			assertTrue(table.delete("ciccio") == 1, "Existing key not found!");
		} catch (Exception e) {
			e.printStackTrace();
			fail("Exception while deleting!");
		}
		assertTrue(table.search("ciccio") == null, "Deleted key found again by search!");
		try {
			assertTrue(table.delete("ciccio") == null, "Deleted key found again by delete!");
		} catch (Exception e) {
			e.printStackTrace();
			fail("Exception while deleting the second time!");
		}
		try {
			table.insert("ciccio", 0);
		} catch (NullKeyException e) {
			e.printStackTrace();
		}
		try {
			assertTrue(table.delete(null) == null, "Trying to delete a null key did not return a null value!");
		} catch (Exception e) {
			e.printStackTrace();
			fail("Exception while deleting a null key!");
		}
		for (int i = 0; i < 1024; i++) {
			try {
				table.insert(Integer.toString(i), i);
			} catch (NullKeyException e) {
				e.printStackTrace();
			}
		}
		for (int i = 1023; i >= 0; i--) {
			try {
				assertTrue(table.delete(Integer.toString(i)) == i, "Existing key not found during resize test!");
			} catch (Exception e) {
				e.printStackTrace();
				fail("Exception while deleting during resize test!");
			}
		}
	}

}
