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

	private static final int[] primeSizes = { 31, 61, 127, 257, 547, 1031, 2053,
			4093, 8191, 16411, 32707, 65579, 131071, 262147, 524287, 1048583, 2097169,
			4194713, 8388617, 16777259, 33554467, 67108879, 134217757, 268435459, 536870923,
			1073748019, 2147438987 }; // To be used for resizing the table
	private Pair[] table;
	private int currentSize, currentPrime, maxLoad, minLoad;

	/**
	 * Constructor with samples for the types of the key and the value, but with no indication of the desired minimum
	 * size for the table. The lowest prime defined in the class for this purpose will be used instead. The samples are
	 * not saved into the table, they are only needed to set up the instance correctly.
	 *
	 * @param keySample a sample for the type of the key
	 * @param valueSample a sample for the type of the value
	 */
	public ConcreteHashTable(K keySample, V valueSample) {
		this(keySample, valueSample, primeSizes[0]);
	}

	/**
	 * Full constructor with samples for the types of the key and the value and an integer with the minimum size that the
	 * table mush have. The samples are not saved into the table, they are only needed to set up the instance correctly.
	 * The integer does not represent the actual size of the table: the size is always prime, but the prime used will be
	 * equal to or greater than the supplied int.
	 *
	 * @param keySample a sample for the type of the key
	 * @param valueSample a sample for the type of the value
	 * @param minSize the minimum size for the instance (smallest larger prime from the class will be used)
	 */
	@SuppressWarnings("unchecked")
	public ConcreteHashTable(K keySample, V valueSample, int minSize) {
		this.currentPrime = 0;
		while (primeSizes[this.currentPrime] < minSize && this.currentPrime < (primeSizes.length - 1))
			this.currentPrime++;
		this.currentSize = 0;
		this.table = new ConcreteHashTable.Pair[primeSizes[this.currentPrime]];
		this.maxLoad = (int) (0.9 * primeSizes[this.currentPrime]);
		this.minLoad = (int) (0.5 * primeSizes[this.currentPrime]);
	}
	
	private Pair findKey(K key, Pair[] table) {
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
	
	@SuppressWarnings("unchecked")
	private void resize(int primeIndex) {
		Pair[] table = new ConcreteHashTable.Pair[primeSizes[primeIndex]];
		for (Pair p: this.table) {
			while (p != null) {
				innerInsert(p.getKey(), p.getValue(), table, primeIndex);
				p = p.getNext();
			}
		}
		this.currentPrime = primeIndex;
		this.maxLoad = (int) (0.9 * primeSizes[this.currentPrime]);
		this.minLoad = (int) (0.5 * primeSizes[this.currentPrime]);
		this.table = table;
	}
	
	/**
	 * 
	 * @param key the key to be inserted
	 * @param value the value to be inserted
	 * @param table the table into which the key-value pair should be inserted
	 * @param primeIndex the index of the prime number associated to the current size
	 * @return the amount by which the current size changes
	 */
	private int innerInsert(K key, V value, Pair[] table, int primeIndex) {
		Pair pair, existingInstance = findKey(key, table);
		int sizeChange = 0;
		pair = new Pair(key, value);
		int position = Math.abs(key.hashCode() % primeSizes[primeIndex]);
		if (existingInstance == null) {
			if (table[position] != null) {
				pair.setNext(table[position]);
				table[position].setPrev(pair);
			}
			table[position] = pair;
			sizeChange++;
		} else {
			existingInstance.setValue(value);
		}
		return sizeChange;
	}

	@Override
	public void insert(K key, V value) throws NullKeyException {
		if (key == null)
			throw new NullKeyException();
		currentSize += innerInsert(key, value, table, currentPrime);
		if (currentSize > maxLoad && currentPrime < (primeSizes.length - 1)) {
			resize(currentPrime + 1);
		}
	}

	@Override
	public V search(K key) {
		V output = null;
		Pair pair = findKey(key, table);
		if (pair != null)
			output = pair.getValue();
		return output;
	}

	@Override
	public V delete(K key) {
		Pair pair = findKey(key, table);
		V output = null;
		if (pair != null) {
			int position = Math.abs(key.hashCode() % primeSizes[currentPrime]);
			output = pair.getValue();
			if (pair.getPrev() == null)
				table[position] = pair.getNext();
			if (pair.getNext() != null)
				pair.getNext().setPrev(pair.getPrev());
		}
		if (currentPrime > 0 && currentSize < minLoad) {
			resize(currentPrime - 1);
		}
		return output;
	}

	private class Pair {
		private K key;
		private V value;
		private Pair prev, next;

		Pair(K key, V value) {
			this.key = key;
			this.value = value;
			this.prev = null;
			this.next = null;
		}

		@Override
		public int hashCode() {
			return key.hashCode();
		}

		K getKey() {
			return key;
		}

		V getValue() {
			return value;
		}

		void setValue(V value) {
			this.value = value;
		}

		Pair getPrev() {
			return prev;
		}

		void setPrev(Pair prev) {
			this.prev = prev;
		}

		Pair getNext() {
			return next;
		}

		void setNext(Pair next) {
			this.next = next;
		}

	}

}
