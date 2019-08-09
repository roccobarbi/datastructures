/**
 * 
 */
package com.barbinirocco.datastructures;

import com.barbinirocco.datastructures.interfaces.LinkedList;

/**
 * Implements the LinkedList interface using a doubly linked list with sentinels.
 * 
 * @author rocco barbini (roccobarbi@gmail.com)
 * @param <K> the type for keys, the actual value is not saved
 * @param <V> the type for values, the actual value is not saved
 *
 */
public class DoublyLinkedList<K, V> implements LinkedList<K, V> {
	
	private Node<K, V> nil; // sentinel value that represent both the head and the tail
	
	public DoublyLinkedList(K keySample, V valueSample) {
		nil = new Node<K, V>(null, null);
		nil.setPrev(nil.setNext(nil));
	}

	@Override
	public boolean isEmpty() {
		return nil.getNext() == nil;
	}

	@Override
	public void insert(K key, V value) {
		Node<K, V> node = new Node<K, V>(key, value);
		node.setPrev(nil.getPrev());
		node.setNext(nil);
		nil.setPrev(node);
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
	
	@SuppressWarnings("hiding")
	private class Node<K, V> {
		private Node<K, V> prev, next;
		private K key;
		private V value;
		
		public Node(K key, V value) {
			this.setKey(key);
			this.setValue(value);
		}

		public Node<K, V> getPrev() {
			return prev;
		}

		public void setPrev(Node<K, V> prev) {
			this.prev = prev;
		}

		public Node<K, V> getNext() {
			return next;
		}

		public Node<K, V> setNext(Node<K, V> next) {
			this.next = next;
			return next;
		}

		public K getKey() {
			return key;
		}

		public void setKey(K key) {
			this.key = key;
		}

		public V getValue() {
			return value;
		}

		public void setValue(V value) {
			this.value = value;
		}
	}

}
