package com.ipds;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class GraphTest {

	private Graph graph;

	@Before
	public void setUp() {
		graph = new Graph( 5 );
		graph.addEdge( 0, 1 );
		graph.addEdge( 0, 4 );
		graph.addEdge( 1, 2 );
		graph.addEdge( 1, 3 );
		graph.addEdge( 1, 4 );
		graph.addEdge( 2, 3 );
		graph.addEdge( 3, 4 );
	}

	@Test
	public void testPrintGraph() {
		graph.print();
	}

	@Test
	public void testDepthFirstTraverse() {
		final Graph g = new Graph( 4, true );
		g.addEdge( 0, 1 );
		g.addEdge( 0, 2 );
		g.addEdge( 1, 2 );
		g.addEdge( 2, 0 );
		g.addEdge( 2, 3 );
		g.addEdge( 3, 3 );
		List<Integer> results = new ArrayList<>();
		g.depthFirstSearch( Graph.createNode( 2 ), results );
		assertEquals( Arrays.asList( 2, 0, 1, 3 ), results );
	}

	@Test
	public void testBreadthFirstTraverse() {
		final Graph g = new Graph( 4, true );
		g.addEdge( 0, 1 );
		g.addEdge( 0, 2 );
		g.addEdge( 1, 2 );
		g.addEdge( 2, 0 );
		g.addEdge( 2, 3 );
		g.addEdge( 3, 3 );
		List<Integer> results = new ArrayList<>();
		g.breadthFirstSearch( Graph.createNode( 2 ), results );
		assertEquals( Arrays.asList( 2, 0, 3, 1 ), results );
	}

}
