package org.aman.graph;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph<T> {
	private List<Edge<T>> allEdges;
	private Map<Long,Vertex<T>> allVertex;
	boolean isdirected=false;

	Graph(boolean isDirected){
		allEdges =new ArrayList<Edge<T>>();
		allVertex=new HashMap<Long,Vertex<T>>();
		this.isdirected=isDirected;
	}

	public void addVertex(Vertex<T> v){
		if (allVertex.containsKey(v.getId()))
			return;

		allVertex.put(v.getId(), v);
		for (Edge<T> edge:v.getEdges()){
			allEdges.add(edge);
		}
	}

	public Vertex<T> addSingleVertex(long id){
		if (allVertex.containsKey(id))
			return allVertex.get(id);

		Vertex<T> v =new Vertex<T>(id);
		allVertex.put(id, v);
		return v;
	}

	public Vertex<T>  getVertex(long id){
		return allVertex.get(id);
	}

	
	public void addEdge(long id1,long id2){
		addEdge(id1,id2,0);
	}
	
	public void addEdge(long id1,long id2,int weight){
		Vertex<T> v1=null;
		if (allVertex.containsKey(id1)){
			v1=allVertex.get(id1);
		}
		else{
			v1=new Vertex<T>(id1);
			allVertex.put(id1, v1);
		}

		Vertex<T> v2=null;
		if (allVertex.containsKey(id2)){
			v2=allVertex.get(id2);
		}
		else{
			v2=new Vertex<T>(id2);
			allVertex.put(id2, v2);
		}

		Edge<T> edge = new Edge<T>(v1,v2,isdirected,weight);
		allEdges.add(edge);
		v1.addAdjacentVertex(edge, v2);
		if(!isdirected){
			v2.addAdjacentVertex(edge, v1);
		}
	}

	public List<Edge<T>> getAllEdges(){
		return allEdges;
	}

	public Collection<Vertex<T>> getAllVertex(){
		return allVertex.values();
	}

	public void setDataForVertex(long id,T data){
		if (allVertex.containsKey(id))
			allVertex.get(id).setData(data);
	}
	
	public void createMatrix(Graph<T> graph){
		
		int INF=10000000;
		int size=graph.getAllVertex().size();
		int[][] matrix=new int[size][size];
		
		for (int i=0;i<size;i++){
			for (int j=0;j<size;j++){
				matrix[i][j]=INF;
			}	
		}
		
	}
} 
