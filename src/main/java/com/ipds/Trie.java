package com.ipds;

import java.util.HashMap;
import java.util.Map;

public class Trie {

	private TrieNode root;

	Trie() {
		this.root = new TrieNode();
	}

	public void insert( final String word ) {
		TrieNode current = root;
		for ( int i = 0; i < word.length(); i++ ) {
			current = current.children.computeIfAbsent( word.charAt( i ), c -> new TrieNode() );
		}
		current.isCompleteWord = true;
	}

	public boolean delete( final String word ) {
		return delete( root, word, 0 );
	}

	private boolean delete( final TrieNode current, final String word, final int index ) {
		if ( index == word.length() ) {
			if (!current.isCompleteWord ) {
				return false;
			}
			current.isCompleteWord = false;
			return current.children.isEmpty();
		}
		char ch = word.charAt( index );
		TrieNode node = current.children.get( ch );
		if ( node == null ) {
			return false;
		}
		boolean shouldDeleteNode = delete( node, word, index + 1 );
		if ( shouldDeleteNode ) {
			current.children.remove( ch );
			return current.children.isEmpty();
		}
		return false;
	}

	public boolean find( final String word ) {
		TrieNode current = root;
		for ( int i = 0; i < word.length(); i++ ) {
			char ch = word.charAt( i );
			final TrieNode node = current.children.get( ch );
			if ( node == null ) {
				return false;
			}
			current = node;
		}
		return current.isCompleteWord;
	}

	public boolean isEmpty() {
		return root == null;
	}

	private static class TrieNode {
		private Map<Character, TrieNode> children;
		private boolean isCompleteWord;

		TrieNode() {
			children = new HashMap<>();
		}
	}

}
