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

	private static final int minSize = 31;
	private static final int primeSizes[] = { 31, 61, 127, 257, 547, 1031, 2053,
			4093, 8191, 16411, 32707, 65579, 131071, 262147, 524287, 1048583, 2097169,
			4194713, 8388617, 16777259, 33554467, 67108879, 134217757, 268435459, 536870923,
			1073748019, 2147438987 };
	private Pair[] table;

	public ConcreteHashTable(K keySample, V valueSample) {
		this.table = new Pair[minSize];
	}

	@Override
	public void insert(K key, V value) throws NullKeyException {
		// TODO Auto-generated method stub

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

	private class Pair<K, V> {
		private K key;
		private V value;

		public Pair(K key, V value) throws NullKeyException {
			if (key == null)
				throw new NullKeyException();
			this.key = key;
			this.value = value;
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

	}

}
