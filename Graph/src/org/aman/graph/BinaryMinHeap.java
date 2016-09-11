package org.aman.graph;

import java.util.ArrayList;
import java.util.HashMap;

public class BinaryMinHeap<T> {
	
	
	private  ArrayList<Node> allnodes=new ArrayList<Node>();
	private HashMap<T,Integer> nodePosition=new HashMap<T,Integer>();
	
	
	public class Node{
		int weight;
		T key;
	}

	public void add(int weight,T key){
		Node node=new Node();
		node.weight=weight;
		node.key=key;
		
		allnodes.add(node);
		
		int size=allnodes.size();
		int curr=size-1;
		int parentIndex=(curr-1)/2;
		
		while (parentIndex>=0){
			Node parentNode =allnodes.get(parentIndex);
			Node currentNode=allnodes.get(curr);
			
			if(parentNode.weight<currentNode.weight){
				swap(parentNode,currentNode);
				curr=parentIndex;
				parentIndex=(parentIndex-1)/2;
			}
			
			else break;
		}
		
	}
	
	public void swap(Node parent,Node current){
		int temp=parent.weight;
		T key=parent.key;
		parent.weight=current.weight;
		parent.key=current.key;
		current.weight=temp;
		current.key=key;
	}
	
	
	
	public boolean empty(){
		return allnodes.size()==0;
	}
	
	
	public void printHeap(){
		for(Node n:allnodes){
			System.out.println(n.weight+" "+n.key);
		}
	}
	
	
	
	public void decrease(T key,int newWeight){
		
		int existing =nodePosition.get(key);
		allnodes.get(existing).weight=newWeight;
		int parent=(existing-1)/2;
		while (parent>=0){
			if ((allnodes.get(parent).weight) > (allnodes.get(existing).weight)){
				swap(allnodes.get(parent),allnodes.get(existing));
				updatePositionMap(allnodes.get(parent).key,allnodes.get(existing).key,parent,existing);
			}
				
		}
	}
	
	public void updatePositionMap(T key,T existing,int parent,int existing1){
		
	  nodePosition.remove(key);
	  nodePosition.remove(existing);
	  nodePosition.put(key, parent);
	  nodePosition.put(existing, existing1);
	}
	
	
	public T extractMin(){
		Node node=extractMinNode();
		return node.key;
	}
	
	public Node extractMinNode(){
		int size=allnodes.size()-1;
		Node minNode =new Node();
		minNode.key=allnodes.get(0).key;
		minNode.weight=allnodes.get(0).weight;
		
		
		return null;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
