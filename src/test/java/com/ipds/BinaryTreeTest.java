package com.ipds;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

//@formatter:off
/**
 *          6
 *     4	      8
 * 3	  5   7       9
 *
 */
//@formatter:on

public class BinaryTreeTest {

	private BinaryTree binaryTree;

	@Before
	public void setUp() {
		binaryTree = new BinaryTree();
		binaryTree.add( 6 );
		binaryTree.add( 4 );
		binaryTree.add( 8 );
		binaryTree.add( 3 );
		binaryTree.add( 5 );
		binaryTree.add( 7 );
		binaryTree.add( 9 );
	}

	@Test
	public void testInOrderTraverse() {
		List<Integer> results = new ArrayList<>();
		binaryTree.traverseInOrder( binaryTree.getRoot(), results );
		assertEquals( Arrays.asList( 3, 4, 5, 6, 7, 8, 9 ), results );
	}

	@Test
	public void testPreOrderTraverse() {
		List<Integer> results = new ArrayList<>();
		binaryTree.traversePreOrder( binaryTree.getRoot(), results );
		assertEquals( Arrays.asList( 6, 4, 3, 5, 8, 7, 9 ), results );
	}

	@Test
	public void testPostOrderTraverse() {
		List<Integer> results = new ArrayList<>();
		binaryTree.traversePostOrder( binaryTree.getRoot(), results );
		assertEquals( Arrays.asList( 3, 5, 4, 7, 9, 8, 6 ), results );
	}

	@Test
	public void testLevelOrderTraverse() {
		List<Integer> results = new ArrayList<>();
		binaryTree.traverseLevelOrder( binaryTree.getRoot(), results );
		assertEquals( Arrays.asList( 6, 4, 8, 3, 5, 7, 9 ), results );
	}

	@Test
	public void testContainsNode() {
		assertTrue( binaryTree.containsNode( 5 ) );
		assertFalse( binaryTree.containsNode( 15 ) );
	}

	@Test
	public void testDeleteLeafNode() {
		assertTrue( binaryTree.containsNode( 5 ) );
		binaryTree.delete( 5 );
		assertFalse( binaryTree.containsNode( 5 ) );
	}

	@Test
	public void testDeleteNode_OneChild() {
		binaryTree.add( 10 );
		assertTrue( binaryTree.containsNode( 10 ) );
		binaryTree.delete( 10 );
		assertFalse( binaryTree.containsNode( 10 ) );
	}

	@Test
	public void testDeleteNode_TwoChild() {
		assertTrue( binaryTree.containsNode( 4 ) );
		binaryTree.delete( 4 );
		assertFalse( binaryTree.containsNode( 4 ) );
	}

}
