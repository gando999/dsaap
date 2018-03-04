package com.ipds;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestLinkedList {

	@Test
	public void testAdd() {
		final LinkedList<String> linkedList = new LinkedList<>();
		linkedList.add( "test" );
		assertEquals( 1, linkedList.size() );
	}

	@Test
	public void testGet() {
		final LinkedList<String> linkedList = new LinkedList<>();
		linkedList.add( "test1" );
		linkedList.add( "test2" );
		linkedList.add( "test3" );
		linkedList.add( "test4" );
		assertEquals( "test1", linkedList.get( 0 ) );
		assertEquals( "test2", linkedList.get( 1 ) );
		assertEquals( "test3", linkedList.get( 2 ) );
		assertEquals( "test4", linkedList.get( 3 ) );
	}

	@Test
	public void testFirst() {
		final LinkedList<String> linkedList = new LinkedList<>();
		linkedList.add( "test1" );
		linkedList.add( "test2" );
		linkedList.add( "test3" );
		linkedList.add( "test4" );
		assertEquals( "test1", linkedList.getFirst() );
	}

	@Test
	public void testLast() {
		final LinkedList<String> linkedList = new LinkedList<>();
		linkedList.add( "test1" );
		linkedList.add( "test2" );
		linkedList.add( "test3" );
		linkedList.add( "test4" );
		assertEquals( "test4", linkedList.getLast() );
	}

	@Test
	public void testRemove() {
		final LinkedList<String> linkedList = new LinkedList<>();
		linkedList.add( "test1" );
		linkedList.add( "test2" );
		linkedList.add( "test3" );
		linkedList.add( "test4" );
		assertEquals( "test1", linkedList.remove( 0 ) );
		assertEquals( 3, linkedList.size() );
		assertEquals( "test3", linkedList.remove( 1 ) );
		assertEquals( 2, linkedList.size() );
	}

	@Test
	public void testReverse() {
		final LinkedList<String> linkedList = new LinkedList<>();
		linkedList.add( "test1" );
		linkedList.add( "test2" );
		linkedList.add( "test3" );
		linkedList.add( "test4" );
		linkedList.reverse();
		assertEquals( "test4", linkedList.get( 0 ) );
		assertEquals( "test3", linkedList.get( 1 ) );
		assertEquals( "test2", linkedList.get( 2 ) );
		assertEquals( "test1", linkedList.get( 3 ) );
	}
}
