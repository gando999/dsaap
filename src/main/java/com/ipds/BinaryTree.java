package com.ipds;

import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

public class BinaryTree {

	private TreeNode root;

	BinaryTree() {

	}

	public TreeNode getRoot() {
		return root;
	}

	private boolean containsNodeRecursive( TreeNode current, int item ) {
		if ( current == null ) {
			return false;
		}
		if ( item == current.getValue() ) {
			return true;
		}
		if ( item < current.getValue() ) {
			return containsNodeRecursive( current.left, item );
		}
		return containsNodeRecursive( current.right, item );
	}

	public boolean containsNode( int item ) {
		return containsNodeRecursive( root, item );
	}

	private TreeNode recursiveAdd( TreeNode current, int item ) {
		if ( current == null ) {
			return new TreeNode( item );
		}
		if ( item < current.getValue() ) {
			current.left = recursiveAdd( current.left, item );
		} else if ( item > current.getValue() ) {
			current.right = recursiveAdd( current.right, item );
		} else {
			return current;
		}

		return current;
	}

	public void add( int item ) {
		this.root = recursiveAdd( root, item );
	}

	private int findSmallestValue( TreeNode current ) {
		if ( current.left == null ) {
			return current.getValue();
		}
		return findSmallestValue( current.left );
	}

	private TreeNode deleteRecursive( TreeNode current, int item ) {
		if ( current == null ) {
			return null;
		}
		if ( item == current.getValue() ) {
			//leaf node
			if ( current.left == null && current.right == null ) {
				return null;
			}
			//one child
			if ( current.left == null ) {
				return current.right;
			}
			if ( current.right == null ) {
				return current.left;
			}
			//two children
			final int smallestValue = findSmallestValue( current.right );
			current.item = smallestValue;
			current.right = deleteRecursive( current.right, smallestValue );
		}
		if ( item < current.getValue() ) {
			current.left = deleteRecursive( current.left, item );
			return current;
		}

		current.right = deleteRecursive( current.right, item );
		return current;
	}

	public void delete( int item ) {
		deleteRecursive( root, item );
	}

	public void traverseInOrder( TreeNode node, List<Integer> results ) {
		if ( node != null ) {
			traverseInOrder( node.left, results );
			results.add( node.getValue() );
			traverseInOrder( node.right, results );
		}
	}

	public void traversePreOrder( TreeNode node, List<Integer> results ) {
		if ( node != null ) {
			results.add( node.getValue() );
			traversePreOrder( node.left, results );
			traversePreOrder( node.right, results );
		}
	}

	public void traversePostOrder( TreeNode node, List<Integer> results ) {
		if ( node != null ) {
			traversePostOrder( node.left, results );
			traversePostOrder( node.right, results );
			results.add( node.getValue() );
		}
	}

	public void traverseLevelOrder( TreeNode node, List<Integer> results ) { //BFS
		if ( node == null ) {
			return;
		}
		Queue<TreeNode> nodes = new LinkedList<>();
		nodes.add( root );
		while ( !nodes.isEmpty() ) {
			final TreeNode current = nodes.remove();
			results.add( current.getValue() );
			if ( current.left != null ) {
				nodes.add( current.left );
			}
			if ( current.right != null ) {
				nodes.add( current.right );
			}
		}
	}

	private static class TreeNode {

		private TreeNode left;

		private TreeNode right;

		private int item;

		TreeNode( int item ) {
			this.item = item;
		}

		int getValue() {
			return item;
		}
	}

}
