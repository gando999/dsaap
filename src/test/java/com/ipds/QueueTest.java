package com.ipds;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import static junit.framework.TestCase.assertTrue;

import org.junit.Test;

public class QueueTest {

	@Test
	public void testAdd() {
		final Queue<String> queue = new Queue<>();
		assertTrue( queue.add( "test1" ) );
		assertTrue( queue.add( "test2" ) );
		assertTrue( queue.add( "test3" ) );
		assertEquals( "test1", queue.peek() );
	}

	@Test
	public void testRemove() {
		final Queue<String> queue = new Queue<>();
		assertTrue( queue.add( "test1" ) );
		assertTrue( queue.add( "test2" ) );
		assertTrue( queue.add( "test3" ) );
		assertEquals( "test1", queue.remove() );
		assertEquals( "test2", queue.remove() );
		assertEquals( "test3", queue.remove() );
		assertNull( queue.remove() );
	}

}
