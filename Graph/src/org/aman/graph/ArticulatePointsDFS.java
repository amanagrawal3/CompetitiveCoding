package org.aman.graph;

import java.util.HashMap;
import java.util.HashSet;

public class ArticulatePointsDFS<T> {

	private int time;
	public void articulatePoints(Graph<T> graph){
		time=0;
		HashSet<Vertex<T>> result=new HashSet<Vertex<T>>();
		HashSet<Vertex<T>> visited=new HashSet<Vertex<T>>();
		HashMap<Vertex<T>,Vertex<T>> parent =new HashMap<Vertex<T>,Vertex<T>>();
		HashMap<Vertex<T>,Integer> visitedTime =new HashMap<Vertex<T>,Integer>();
		HashMap<Vertex<T>,Integer> lowTime =new HashMap<Vertex<T>,Integer>();
		Vertex<T> startVertex=graph.getAllVertex().iterator().next();
		DFS(visited,result,parent,visitedTime,lowTime,startVertex);
	}
	



	private void DFS(HashSet<Vertex<T>> visited, HashSet<Vertex<T>> result,
			HashMap<Vertex<T>, Vertex<T>> parent,
			HashMap<Vertex<T>, Integer> visitedTime,
			HashMap<Vertex<T>, Integer> lowTime, Vertex<T> startVertex) {
		
		visited.add(startVertex);
		visitedTime.put(startVertex, time);
		lowTime.put(startVertex, time);
		time++;
		
		int childcount=0;
		boolean isArticulatedPoint=false;
		
		for (Vertex<T> vertex:startVertex.getAdjacentVertex()){
			if(vertex.equals(parent.get(vertex)))
				continue;
			
			if(!visited.contains(vertex)){
				parent.put(vertex, startVertex);
				childcount++;
				DFS(visited,result,parent,visitedTime,lowTime,vertex);
				
				if (visitedTime.get(startVertex)<=lowTime.get(vertex))
					isArticulatedPoint=true;
				
				else{
					
				}
			
			
			}
			
			
			
		}
		
	}




	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
