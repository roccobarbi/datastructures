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
			fail("Exception during construction!");
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
		try {
			table.insert("pasticcio", null);
		} catch (NullKeyException e) {
			e.printStackTrace();
			fail("NullKeyException while inserting valid key and null value!");
		} catch (Exception e) {
			e.printStackTrace();
			fail("Exception while inserting valid key and null value!");
		}
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
		try {
			table.insert(null, 0);
			fail("NullKeyException not thrown when inserting null key!");
		} catch (NullKeyException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
			fail("Wrong exception thrown when inserting null key!!");
		}
	}

	/**
	 * Test method for {@link com.barbinirocco.datastructures.ConcreteHashTable#search(K)}.
	 */
	@Test
	void testSearch() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link com.barbinirocco.datastructures.ConcreteHashTable#delete(K)}.
	 */
	@Test
	void testDelete() {
		fail("Not yet implemented"); // TODO
	}

}
