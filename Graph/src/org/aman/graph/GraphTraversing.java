package org.aman.graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class GraphTraversing<T> {


	//BFS of a graph(Visit all the levels one by one ,visiting all the elements in each level

	public void BFS(Graph<T> g1){
		Set<Long> visited=new HashSet<Long>();
		Queue<Vertex<T>> q =new LinkedList<Vertex<T>>();
		//System.out.println("In function");
		for (Vertex<T> vertex:g1.getAllVertex()){
			if (!visited.contains(vertex.getId())){
				q.add(vertex);
				visited.add(vertex.getId());
				while (q.size()!=0){
					Vertex<T> vq=q.poll();
					System.out.print(vq.getId()+ " ");
					for(Vertex<T> v1 : vq.getAdjacentVertex()){
						if (!visited.contains(v1.getId())){
							q.add(v1);
							visited.add(v1.getId());
						}
					}
				}
			}
		}

	}	

	public void DFS(Graph<T> g1){
		Set<Long> visited=new HashSet<Long>();
		for (Vertex<T> v:g1.getAllVertex()){
			if(!visited.contains(v.getId())){
				DFSUtil(v,visited);
			}
		}
	}

	public void DFSUtil(Vertex<T> v,Set<Long> visited){
		visited.add(v.getId());
		System.out.print(v.getId()+" ");
		for (Vertex<T> v1: v.getAdjacentVertex()){
			if(!visited.contains(v1.getId())){
				DFSUtil(v1,visited);
			}
		}
	}



	public static void main(String[] args) {
		Graph<Integer> g1=new Graph<Integer>(true);
		g1.addEdge(1, 2);
		g1.addEdge(1, 3);
		g1.addEdge(2, 4);
		g1.addEdge(3, 4);
		g1.addEdge(4, 6);
		g1.addEdge(6, 5);
		g1.addEdge(5, 3);

		System.out.println(g1.getAllVertex());
		for (Vertex<Integer> v:g1.getAllVertex()){
			System.out.println(v.getAdjacentVertex());	
		}

		GraphTraversing<Integer> gtraverse =new GraphTraversing<Integer>();
		gtraverse.BFS(g1);
		System.out.println();
		gtraverse.DFS(g1);
	}

}
