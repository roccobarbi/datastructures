/**
 * 
 */
package com.barbinirocco.datastructures.interfaces;

/**
 * Defines the basic operations of a linked list for storing key-value pairs.
 * Each item has a key and can hold satellite data, the two can be of different types and
 * the satellite data can be null (but a type must be defined).
 * 
 * @author rocco barbini (roccobarbi@gmail.com)
 *
 */
public interface LinkedList<K, V> {
	
	/**
	 * 
	 * @return true if the list is empty
	 */
	public boolean isEmpty();
	
	/**
	 * Inserts a key-value pair into the list
	 * 
	 * @param key the key to which the item will be associated
	 * @param value the satellite data, or null if the key is the data
	 */
	public void insert(K key, V value);
	
	/**
	 * Searches the list for the first value associated to a key, without removing it from the list.
	 * 
	 * @param key the key to be searched
	 * @return a pointer to the value
	 */
	public V search(K key);
	
	/**
	 * Searches the list for the first value associated to a key and removes it from the list.
	 * 
	 * @param key the key to be deleted
	 * @return a pointer to the value that was removed from the list
	 */
	public V delete(K key);
	

}
