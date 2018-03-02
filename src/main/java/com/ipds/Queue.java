package com.ipds;

public class Queue<T> {

	private QueueNode<T> head;

	Queue() {}

	public boolean add( T item ) {
		if ( head == null ) {
			head = new QueueNode<>( item );
		} else {
			QueueNode<T> current = head;
			while ( current.next != null ) {
				current = current.next;
			}
			current.next = new QueueNode<>( item );
		}
		return true;
	}

	public T peek() {
		if ( head != null ) {
			return head.getItem();
		}
		return null;
	}

	public T remove() {
		if ( head != null ) {
			QueueNode<T> currentHead = head;
			head = head.next;
			return currentHead.getItem();
		}
		return null;
	}

	private static class QueueNode<T> {
		QueueNode<T> next;
		T item;

		QueueNode( T item ) {
			this.item = item;
		}

		T getItem() {
			return item;
		}
	}

}
