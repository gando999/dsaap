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
		current.isWord = true;
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
		return current.isWord;
	}

	public boolean isEmpty() {
		return root == null;
	}

	private static class TrieNode {
		private Map<Character, TrieNode> children;
		private String content;
		private boolean isWord;

		TrieNode() {
			children = new HashMap<>();
		}
	}

}
