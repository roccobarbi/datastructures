/**
 * 
 */
package com.barbinirocco.datastructures;

import com.barbinirocco.datastructures.exceptions.NullKeyException;
import com.barbinirocco.datastructures.interfaces.HashTable;

/**
 * @author rocco barbini (roccobarbi@gmail.com)
 * @param <K> the type for the key
 * @param <V> the type for the value
 *
 */
public class ConcreteHashTable<K, V> implements HashTable<K, V> {

	private static final int primeSizes[] = { 31, 61, 127, 257, 547, 1031, 2053,
			4093, 8191, 16411, 32707, 65579, 131071, 262147, 524287, 1048583, 2097169,
			4194713, 8388617, 16777259, 33554467, 67108879, 134217757, 268435459, 536870923,
			1073748019, 2147438987 }; // To be used for resizing the table
	private Pair[] table;
	private int currentSize, currentPrime;

	public ConcreteHashTable(K keySample, V valueSample) {
		this.currentPrime = 0;
		this.currentSize = 0;
		this.table = new ConcreteHashTable.Pair[primeSizes[0]];
	}

	@Override
	public void insert(K key, V value) throws NullKeyException {
		Pair pair;
		try {
			pair = new Pair(key, value);
		} catch (NullKeyException e) {
			throw new NullKeyException(e.getMessage());
		}
		int position = key.hashCode() % primeSizes[currentPrime];
	}

	@Override
	public V search(K key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public V delete(K key) {
		// TODO Auto-generated method stub
		return null;
	}

	private class Pair {
		private K key;
		private V value;
		private Pair prev, next;

		public Pair(K key, V value) throws NullKeyException {
			if (key == null)
				throw new NullKeyException();
			this.key = key;
			this.value = value;
			this.prev = null;
			this.next = null;
		}

		@Override
		public int hashCode() {
			return key.hashCode();
		}

		/**
		 * @return the key
		 */
		public K getKey() {
			return key;
		}

		/**
		 * @return the value
		 */
		public V getValue() {
			return value;
		}

		/**
		 * @return the prev
		 */
		public Pair getPrev() {
			return prev;
		}

		/**
		 * @param prev the prev to set
		 */
		public void setPrev(Pair prev) {
			this.prev = prev;
		}

		/**
		 * @return the next
		 */
		public Pair getNext() {
			return next;
		}

		/**
		 * @param next the next to set
		 */
		public void setNext(Pair next) {
			this.next = next;
		}

	}

}
