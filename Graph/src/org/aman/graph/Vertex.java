package org.aman.graph;

import java.util.ArrayList;
import java.util.List;

public class Vertex<T> {
	long id;
	private T data;
	private List<Edge<T>> edges  =new ArrayList<Edge<T>>();
	private List<Vertex<T>> adjacentVertex  =new ArrayList<Vertex<T>>();

	Vertex(long id){
		this.id=id;
	}

	public void setData(T data){
		this.data=data;
	}

	public T getData(){
		return data;
	}

	public long getId(){
		return id;
	}
	
	public void addAdjacentVertex(Edge<T> e,Vertex<T> v){
		edges.add(e);
		adjacentVertex.add(v);
	}
	
	public String toString(){
		return String.valueOf(id);
	}
	
	public List<Vertex<T>> getAdjacentVertex(){
		return adjacentVertex;
	}
	
	public List<Edge<T>> getEdges(){
		return edges;
	}
	public int getDegree(){
		return edges.size();
	}
	
	public int hashcode(){
		final int prime=31;
		int result=1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}
	
	public boolean equals(Object o){
		if (this ==null||o==null)
			return false;
		if(this.getClass()!=o.getClass())
			return false;
		if(this==o)
			return true;
		
		@SuppressWarnings("unchecked")
		Vertex<T> v=(Vertex<T>) o;
		if (v.id!=this.id)
			return false;
		return true;
	}
}
