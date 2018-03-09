package com.ipds;

import static org.junit.Assert.assertFalse;

import static junit.framework.TestCase.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class TrieTest {

	private Trie trie;

	@Before
	public void setUp() {
		trie = new Trie();
	}

	@Test
	public void testInsert() {
		trie.insert( "Happy" );
		trie.insert( "Shiny" );
		trie.insert( "People" );
		assertFalse( trie.isEmpty() );
	}

	@Test
	public void testFind() {
		trie.insert( "Happy" );
		trie.insert( "Shiny" );
		trie.insert( "People" );
		assertTrue( trie.find( "Shiny" ) );
		assertTrue( trie.find( "Happy" ) );
		assertTrue( trie.find( "People" ) );
		assertFalse( trie.find( "Holding" ) );
		assertFalse( trie.find( "Hands" ) );
	}

}
