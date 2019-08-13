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
	
	private class Pair<K,V> {
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
