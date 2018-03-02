package com.ipds;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class TestHashTable {

	@Test
	public void testAddSingle() {
		final HashTable<String, String> hashTable = new HashTable<>( 10 );
		hashTable.add( "test", "object" );
		final String value = hashTable.get( "test" );
		assertEquals( "object", value );
	}

	@Test
	public void testAddMultiple() {
		final HashTable<String, String> hashTable = new HashTable<>( 10 );
		hashTable.add( "test1", "value1" );
		hashTable.add( "test2", "value2" );
		hashTable.add( "test3", "value3" );
		hashTable.add( "test4", "value4" );
		assertEquals( "value1", hashTable.get( "test1" ) );
		assertEquals( "value2", hashTable.get( "test2" ) );
		assertEquals( "value3", hashTable.get( "test3" ) );
		assertEquals( "value4", hashTable.get( "test4" ) );
	}

	@Test
	public void testCollision() {
		final HashTable<String, String> hashTable = new HashTable<>( 10 );
		hashTable.add( "test1", "value1" );
		hashTable.add( "test1", "value2" );
		assertEquals( "value2", hashTable.get( "test1" ) );
	}

	@Test
	public void testRemove() {
		final HashTable<String, String> hashTable = new HashTable<>( 10 );
		hashTable.add( "test1", "value1" );
		assertEquals( "value1", hashTable.get( "test1" ) );
		assertEquals( "value1", hashTable.remove( "test1" ) );
		assertNull( hashTable.get( "test1" ) );
	}

}
