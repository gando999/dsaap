package com.ipds;

public class LinkedList<V> {

	private LinkedListNode<V> head;

	private int counter;

	LinkedList() {}

	public int size() {
		return counter;
	}

	public void add( V item ) {
		if ( head == null ) {
			head = new LinkedListNode<>( item );
		} else {
			LinkedListNode<V> current = head;
			while ( current.next != null ) {
				current = current.next;
			}
			current.next = new LinkedListNode<>( item );
		}
		counter++;
	}

	public V get( int index ) {
		if ( index == 0 ) {
			return head != null ? head.getItem() : null;
		}
		LinkedListNode<V> current = head;
		if ( current != null ) {
			for ( int i = 1; i <= index; i++ ) {
				if ( current.next != null ) {
					current = current.next;
				}
			}
			return current.getItem();
		}
		return null;
	}

	public V getFirst() {
		return head != null ? head.getItem() : null;
	}

	public V getLast() {
		LinkedListNode<V> current = head;
		if ( current == null ) {
			return null;
		}
		while ( current.next != null ) {
			current = current.next;
		}
		return current.getItem();
	}

	public V remove( int index ) {
		if ( index == 0 ) {
			LinkedListNode<V> currentHead = head;
			head = head.next;
			counter--;
			return currentHead.getItem();
		} else {
			LinkedListNode<V> current = head;
			for ( int i = 1; i < index; i++ ) {
				current = current.next;
			}
			LinkedListNode<V> itemToRemove = current.next;
			current.next = itemToRemove.next;
			counter--;
			return itemToRemove.getItem();
		}
	}

	private static class LinkedListNode<V> {

		private LinkedListNode<V> next;

		private V item;

		LinkedListNode( V item ) {
			this.item = item;
		}

		V getItem() {
			return item;
		}
	}

}
