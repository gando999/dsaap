package com.ipds;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class StackTest {

	@Test
	public void testPush() {
		final Stack<String> stack = new Stack<>();
		stack.push( "test1" );
		assertFalse( stack.empty() );
	}

	@Test
	public void testPeek() {
		final Stack<String> stack = new Stack<>();
		stack.push( "test1" );
		assertEquals( "test1", stack.peek() );
		stack.push( "test2" );
		assertEquals( "test2", stack.peek() );
	}

	@Test
	public void testPop() {
		final Stack<String> stack = new Stack<>();
		stack.push( "test1" );
		assertEquals( "test1", stack.peek() );
		stack.push( "test2" );
		assertEquals( "test2", stack.peek() );
		assertEquals( "test2", stack.pop() );
		assertEquals( "test1", stack.pop() );
		assertNull( stack.pop() );
	}
}
