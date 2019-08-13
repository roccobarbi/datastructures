/**
 * 
 */
package com.barbinirocco.datastructures.interfaces;

import com.barbinirocco.datastructures.exceptions.NullKeyException;

/**
 * Defines the basic operations for a hash table of key-value pairs.
 * 
 * @author rocco barbini (roccobarbi@gmail.com)
 *
 */
public interface HashTable <K, V> {
	
	/**
	 * Inserts a key-value pair into the hash table.
	 * 
	 * @param key
	 * @param value
	 */
	public void insert(K key, V value) throws NullKeyException;
	
	/**
	 * Searches for a key-value pair in the hash table.
	 * 
	 * @param key
	 * @return a pointer to the value, or null
	 */
	public V search(K key);
	
	/**
	 * Deletes a pair from the hash table.
	 * 
	 * @param key
	 * @return a pointer to the deleted value, or null if none was found.
	 */
	public V delete(K key);
}
