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

	@Test
	public void testCloneAndReverse() {
		final LinkedList<String> linkedList = new LinkedList<>();
		linkedList.add( "test1" );
		linkedList.add( "test2" );
		linkedList.add( "test3" );
		linkedList.add( "test4" );
		final LinkedList<String> reversed = linkedList.cloneAndReverse();
		assertEquals( "test4", reversed.get( 0 ) );
		assertEquals( "test3", reversed.get( 1 ) );
		assertEquals( "test2", reversed.get( 2 ) );
		assertEquals( "test1", reversed.get( 3 ) );
	}

	@Test
	public void testGetItemFromEnd() {
		final LinkedList<String> linkedList = new LinkedList<>();
		linkedList.add( "test1" );
		linkedList.add( "test2" );
		linkedList.add( "test3" );
		linkedList.add( "test4" );
		linkedList.add( "test5" );
		linkedList.add( "test6" );
		linkedList.add( "test7" );
		linkedList.add( "test8" );
		assertEquals( "test6", linkedList.getItemFromEnd( 2 ) );
		assertEquals( "test7", linkedList.getItemFromEnd( 1 ) );
		assertEquals( "test3", linkedList.getItemFromEnd( 5 ) );
	}
}
