package com.ipds;

import java.util.Queue;
import java.util.List;
import java.util.LinkedList;
import java.util.stream.IntStream;

public class Graph {

	private int vertexSize;

	private boolean isDirected;

	private List<GraphNode> adjacencyArray[];

	Graph( final int vertexSize, boolean isDirected ) {
		this.vertexSize = vertexSize;
		this.isDirected = isDirected;
		this.adjacencyArray = new LinkedList[vertexSize];

		IntStream.range( 0, vertexSize ).forEach( i -> {
			this.adjacencyArray[i] = new LinkedList<>();
		} );
	}

	Graph( final int vertexSize ) {
		this( vertexSize, false );
	}

	public static GraphNode createNode( final int identifier, final String name ) {
		return new GraphNode( identifier, name );
	}

	public static GraphNode createNode( final int identifier ) {
		return new GraphNode( identifier, "" );
	}

	public void addEdge( final GraphNode src, final GraphNode dest ) {
		adjacencyArray[src.getIdentifier()].add( dest );
		if ( !isDirected ) {
			adjacencyArray[dest.getIdentifier()].add( src );
		}
	}

	public void addEdge( final int src, final int dest ) {
		addEdge( createNode( src ), createNode( dest ) );
	}

	public void print() {
		IntStream.range( 0, vertexSize ).forEach( i -> {
			System.out.println( " Vertex [" + i + "]" );
			System.out.println( " Head " );
			for ( GraphNode p : adjacencyArray[i] ) {
				System.out.println( "-> " + p );
			}
			System.out.println( "" );
		} );
	}

	private void depthFirstSearchRecurse( GraphNode current, boolean[] visited,
			List<Integer> results ) {
		if ( current == null ) {
			return;
		}
		results.add( current.getIdentifier() );
		visited[current.getIdentifier()] = true;
		for ( GraphNode node : adjacencyArray[current.getIdentifier()] ) {
			if ( !visited[node.getIdentifier()] ) {
				depthFirstSearchRecurse( node, visited, results );
			}
		}
	}

	public void depthFirstSearch( GraphNode root, List<Integer> results ) {
		boolean visited[] = new boolean[vertexSize];
		depthFirstSearchRecurse( root, visited, results );
	}

	public void breadthFirstSearch( GraphNode root, List<Integer> results ) {
		boolean visited[] = new boolean[vertexSize];
		Queue<GraphNode> queue = new LinkedList<>();
		visited[root.getIdentifier()] = true;
		queue.add( root );

		while ( !queue.isEmpty() ) {
			GraphNode node = queue.poll();
			results.add( node.getIdentifier() );
			for ( GraphNode inner : adjacencyArray[node.getIdentifier()] ) {
				if ( !visited[inner.getIdentifier()] ) {
					visited[inner.getIdentifier()] = true;
					queue.add( inner );
				}
			}
		}
	}

	private static class GraphNode {

		private final int identifier;
		private final String name;

		GraphNode( int identifier, String name ) {
			this.identifier = identifier;
			this.name = name;
		}

		int getIdentifier() {
			return identifier;
		}

		public String getName() {
			return name;
		}

		public String toString() {
			if ( name.equals( "" ) ) {
				return "id : [" + identifier + "]";
			} else {
				return "id : [" + identifier + "] name: [" + name + "]";
			}
		}
	}
}
