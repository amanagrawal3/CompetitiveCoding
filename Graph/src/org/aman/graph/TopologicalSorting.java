package org.aman.graph;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class TopologicalSorting<T> {


	public void topologicalSort(Graph<T> g1){
		Deque<Vertex<T>> dq=new ArrayDeque<Vertex<T>>();
		Set<Long> visited=new HashSet<Long>();

		for (Vertex<T> v:g1.getAllVertex()){
			if (!visited.contains(v.getId()))
				//System.out.println(v.getId());
				topSortUtil(v,visited,dq);
		}
		
		for (Vertex<T> v:dq){
			System.out.print(v.getId()+" ");
		}
	}

	void topSortUtil(Vertex<T> v,Set<Long> visited,Deque<Vertex<T>> dq){
		visited.add(v.getId());
		//System.out.println(v.getAdjacentVertex());
		for(Vertex<T> v1:v.getAdjacentVertex()){
			if (!visited.contains(v1.getId()))
			//	System.out.println(v.getId());
				topSortUtil(v1,visited,dq);
		}
		dq.offerFirst(v);

	}
	public static void main(String[] args) {
		Graph<Integer> graph = new Graph<Integer>(true);
        graph.addEdge(1, 3);
        graph.addEdge(1, 2);
        graph.addEdge(3, 4);
        graph.addEdge(5, 6);
        graph.addEdge(6, 3);
        graph.addEdge(3, 8);
        graph.addEdge(8, 11);
        
        TopologicalSorting<Integer> t1=new TopologicalSorting<Integer>();
        t1.topologicalSort(graph);

	}

}
