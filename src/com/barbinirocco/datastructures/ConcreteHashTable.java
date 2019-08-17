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
	private int currentSize, currentPrime, maxLoad;

	public ConcreteHashTable(K keySample, V valueSample) {
		this(keySample, valueSample, primeSizes[0]);
	}
	
	@SuppressWarnings("unchecked")
	public ConcreteHashTable(K keySample, V valueSample, int minSize) {
		this.currentPrime = 0;
		while (primeSizes[this.currentPrime] < minSize && this.currentPrime < (primeSizes.length - 1))
			this.currentPrime++;
		this.currentSize = 0;
		this.table = new ConcreteHashTable.Pair[primeSizes[this.currentPrime]];
		this.maxLoad = (int) (0.9 * currentPrime);
	}
	
	private Pair findKey(K key) {
		Pair output = null;
		if (key != null) {
			int position = Math.abs(key.hashCode() % primeSizes[currentPrime]);
			output = table[position];
			while (output != null && !output.getKey().equals(key)) {
				output = output.getNext();
			}
		}
		return output;
	}
	
	private void resize(int primeIndex) {
		//
	};

	@Override
	public void insert(K key, V value) throws NullKeyException {
		if (key == null)
			throw new NullKeyException();
		Pair pair, existingInstance = findKey(key);
		pair = new Pair(key, value);
		int position = Math.abs(key.hashCode() % primeSizes[currentPrime]);
		if (existingInstance == null) {
			if (table[position] != null) {
				pair.setNext(table[position]);
				table[position].setPrev(pair);
			}
			table[position] = pair;
			currentSize++;
		} else {
			existingInstance.setValue(value);
		}
		if (currentSize > maxLoad && currentPrime < (primeSizes.length - 1)) {
			resize(currentPrime + 1);
		}
	}

	@Override
	public V search(K key) {
		V output = null;
		Pair pair = findKey(key);
		if (pair != null)
			output = pair.getValue();
		return output;
	}

	@Override
	public V delete(K key) {
		Pair pair = findKey(key);
		V output = null;
		if (pair != null) {
			int position = Math.abs(key.hashCode() % primeSizes[currentPrime]);
			output = pair.getValue();
			if (pair.getPrev() == null)
				table[position] = pair.getNext();
			if (pair.getNext() != null)
				pair.getNext().setPrev(pair.getPrev());
		}
		return output;
	}

	private class Pair {
		private K key;
		private V value;
		private Pair prev, next;

		public Pair(K key, V value) {
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
		 * @param value the value to set
		 */
		public void setValue(V value) {
			this.value = value;
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
