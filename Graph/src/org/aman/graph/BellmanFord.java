package org.aman.graph;

import java.util.HashMap;
import java.util.Map;

/**  
 * 
 * single source	shortest	paths,Handling	negative weight	cycles,Directed	acyclic	graphs
 * Runtime is : O(VE)
 * Space is: O(V)
 * 
 * Based on relaxation algorithm
 *  1. problems is infinite loop in case of negative weight cycles
 *  2. A  poor choice of relaxations can lead to exponential relaxations 
 * 	 
 * 
 * Applications:
 * 	1. Distance vector routing	protocol
 * 	2. Routing	Information	Protocol	(RIP)
 *  3. Interior	Gateway	Routing	Protocol	(IGRP)
 * @author AMANA
 *
 * 
 */

public class BellmanFord<T> {

	
	public void getShortestPath(Graph<T> graph){
		
		Map<Vertex<T>,Integer> distance=new HashMap<Vertex<T>,Integer>();
		Map<Vertex<T>,Vertex<T>> parent=new HashMap<Vertex<T>,Vertex<T>>();
		

		Vertex<T> startvertex=graph.getAllVertex().iterator().next();
		int infinity=100000000;
		
		int count=graph.getAllVertex().size()-1;
		
		for (Vertex<T> vertex:graph.getAllVertex()){
			distance.put(vertex, infinity);
			parent.put(vertex, null);
		}
		
		distance.put(startvertex, 0);
		
		for (int i=0;i<count;i++){
			for (Edge<T> edge:graph.getAllEdges()){
				Vertex<T> v1=edge.getVertex1();
				Vertex<T> v2=edge.getVertex2();
				
				if (distance.get(v1)+edge.getWeight()<distance.get(v2)){
					distance.put(v2, distance.get(v1)+edge.getWeight());
					parent.put(v2, v1);
				}
			}
		}
		
		
		for (Edge<T> edge:graph.getAllEdges()){
			Vertex<T> v1=edge.getVertex1();
			Vertex<T> v2=edge.getVertex2();
			
			if (distance.get(v1)+edge.getWeight()<distance.get(v2)){
				throw new IllegalArgumentException("Graph contain cycles");
			}
		}
		
		System.out.println(distance);
		
		
	}
	
	public static void main(String[] args) {
		
		
		Graph<Integer> graph = new Graph<Integer>(false);
        graph.addEdge(0, 3, 8);
        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 5);
        graph.addEdge(1, 2, -3);
        graph.addEdge(2, 4, 4);
        graph.addEdge(3, 4, 2);
        graph.addEdge(4, 3, 1);
        
        BellmanFord<Integer> b1=new BellmanFord<Integer>();
        b1.getShortestPath(graph);
        

	}

}
