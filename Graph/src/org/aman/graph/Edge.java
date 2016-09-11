package org.aman.graph;

public class Edge<T> {
	private Vertex<T> v1;
	private Vertex<T> v2; 
	private boolean isDirected=false;
	private int weight;
	
	Edge(Vertex<T> v1,Vertex<T> v2){
		this.v1=v1;
		this.v2=v2;
	}
	
	Edge(Vertex<T> v1,Vertex<T> v2,boolean isDirected,int weight){
		this.v1=v1;
		this.v2=v2;
		this.isDirected=isDirected;
		this.weight=weight;
	}
	
	Edge(Vertex<T> v1,Vertex<T> v2,boolean isDirected){
		this.v1=v1;
		this.v2=v2;
		this.isDirected=isDirected;
	}
	
	public Vertex<T> getVertex1(){
		return v1;
	}
	public Vertex<T> getVertex2(){
		return v2;
	}
	public boolean isDirected(){
		return isDirected;
	}
	
	public int getWeight(){
		return weight;
	}
	
	public int hashCode(){
		final int prime = 31;
        int result = 1;
        result = prime * result + ((v1 == null) ? 0 : v1.hashCode());
        result = prime * result + ((v2 == null) ? 0 : v2.hashCode());
        return result;
	}
	
	public boolean equals(Object o){
		if (this==null|| o==null)
			return false;
		if (this.getClass()!=o.getClass())
			return false;
		if(this==o)
			return true;
		
		@SuppressWarnings("unchecked")
		Edge<T> other=(Edge<T>) o;
		if (this.v1==null){
			if (other.v1!=null)
			return false;
		}
		else if (!v1.equals(other.v1))
			return false;
		else if (this.v2==null|| other.v2!=null)
			return false;
		else if (!v2.equals(other.v2))
			return false;
		
		return true;
	}
	
	public String toString() {
        return "Edge [isDirected=" + isDirected + ", vertex1=" + v1
                + ", vertex2=" + v2 + ", weight=" + weight + "]";
    }
	
	
	
}
