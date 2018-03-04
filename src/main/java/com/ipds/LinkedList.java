package com.ipds;

public class LinkedList<V> {

	private LinkedListNode<V> head;

	private int counter;

	LinkedList() {}

	private LinkedList( LinkedListNode<V> head ) {
		this.head = head;
	}

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

	public void reverse() {
		if ( head != null ) {
			Stack<LinkedListNode<V>> stack = new Stack<>();
			LinkedListNode<V> current = head;
			while ( current != null ) {
				stack.push( current );
				current = current.next;
			}
			LinkedListNode<V> newHead = stack.pop();
			LinkedListNode<V> tracker = newHead;
			while ( !stack.empty() ) {
				final LinkedListNode<V> popped = stack.pop();
				tracker.next = popped;
				tracker = popped;
			}
			head = newHead;
		}
	}

	public LinkedList<V> cloneAndReverse() {
		if ( head != null ) {
			LinkedListNode<V> current = head;
			LinkedListNode<V> newHead = null;
			while ( current != null ) {
				final LinkedListNode<V> newNode = new LinkedListNode<>( current.getItem() );
				newNode.next = newHead;
				newHead = newNode;
				current = current.next;
			}
			return new LinkedList<>( newHead );
		}
		return new LinkedList<>();
	}

	public V getItemFromEnd( int k ) {
		LinkedListNode<V> backRunner = head;
		LinkedListNode<V> tracker = head;
		for ( int i = 0; i <= k; i++ ) {
			tracker = tracker.next;
		}
		while ( tracker != null ) {
			tracker = tracker.next;
			backRunner = backRunner.next;
		}
		return backRunner.getItem();
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
