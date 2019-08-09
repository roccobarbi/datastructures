/**
 * 
 */
package com.barbinirocco.datastructures;

import com.barbinirocco.datastructures.interfaces.LinkedList;

/**
 * Implements the LinkedList interface using a doubly linked list with sentinels.
 * 
 * @author rocco barbini (roccobarbi@gmail.com)
 * @param <K> the type for keys
 * @param <V> the type for values
 *
 */
public class DoublyLinkedList<K, V> implements LinkedList<K, V> {
	
	private Node nil; // sentinel value that represent both the head and the tail
	
	public DoublyLinkedList(K keySample, V valueSample) {
		nil = new Node(null, null);
		nil.prev = nil.next = nil;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void insert(K key, V value) {
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
	
	private class Node<K, V> {
		private Node prev, next;
		private K key;
		private V value;
		
		public Node(K key, V value) {
			this.key = key;
			this.value = value;
		}
	}

}
