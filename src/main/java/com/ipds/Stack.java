package com.ipds;

public class Stack<T> {

	private StackNode<T> head;

	Stack() {}

	public T peek() {
		if ( head != null ) {
			return head.getItem();
		}
		return null;
	}

	public T pop() {
		if ( head != null ) {
			final StackNode<T> currentHead = head;
			head = head.next;
			return currentHead.getItem();
		}
		return null;
	}

	public void push( T item ) {
		if ( head == null ) {
			head = new StackNode<>( item );
		} else {
			final StackNode<T> newHead = new StackNode<>( item );
			newHead.next = head;
			head = newHead;
		}
	}

	public boolean empty() {
		return head == null;
	}

	private static class StackNode<T> {
		StackNode<T> next;
		T item;

		StackNode( T item ) {
			this.item = item;
		}

		T getItem() {
			return item;
		}
	}

}
