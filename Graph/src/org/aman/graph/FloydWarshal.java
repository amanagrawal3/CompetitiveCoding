package org.aman.graph;

import java.util.Deque;
import java.util.LinkedList;

public class FloydWarshal<T> {

	private static final int INF = 1000000;
	public void allPairShorteshPath(int[][] graph){
		
		int size=graph.length;
		int[][] distance=new int[size][size];
		int[][] path=new int[size][size];
		
		for (int  i=0;i<size;i++){
			for (int j=0;j<size;j++){
			distance[i][j]=graph[i][j];
			
			if(graph[i][j]!=INF && i!=j){
				path[i][j]=i;
			}
			else 
				path[i][j]=-1;
			
			}
		}
		
		for(int k=0;k<size;k++){
			for (int i=0;i<size;i++){
				for (int j=0;j<size;j++){
					if(distance[i][k]==INF || distance[k][j]==INF)
						continue;
					
					if(distance[i][j]>distance[i][k]+distance[k][j]){
						distance[i][j]=distance[i][k]+distance[k][j];
						path[i][j]=path[k][j];
					}
				}
			}
		}
		
		
		 for(int i = 0; i < distance.length; i++) {
			 if (distance[i][i]<0)
				 throw new IllegalArgumentException("Negative cycle exist");
		 }
		 
		 printPath(path,3,2);
	}
	
	public void printPath(int[][] graph,int start,int end){
		
		Deque<Integer> stack=new LinkedList<Integer>();
		stack.addFirst(end);
		
		while(true){
			
			end=graph[start][end];
			if(end==-1){
				return;
			}
			stack.addFirst(end);
			if (end==start)
				break;
		}
		
		while(!stack.isEmpty()){
			System.out.print(stack.pollFirst()+" ");
		}
	}
	
	public static void main(String[] args) {
		Graph<Integer> graph=new Graph<Integer>(true);
		graph.addEdge(0, 1, 3);
		graph.addEdge(0, 2, 6);
		graph.addEdge(0, 3, 15);
		graph.addEdge(1, 2, -2);
		graph.addEdge(3, 0, -1);
		graph.createMatrix(graph);
		
		
		int[][] graph1 = {
                {0,   3,   6,   15},
                {INF, 0,  -2,   INF},
                {INF, INF, 0,   2},
                {1,   INF, INF, 0}
        };
		
		 FloydWarshal<Integer> f1=new FloydWarshal<Integer>();
		 f1.allPairShorteshPath(graph1);

		
		
		
	
	
	
	}

}
