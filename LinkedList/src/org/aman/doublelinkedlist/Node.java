package org.aman.doublelinkedlist;

public class Node<T> {
	T element;
	Node<T> next;
	Node<T> previous;
	public Node(){
		this.element=null;
		next=previous=null;
	}
	
	public T getElement(){
		return element;
	}
	
	public void setElement(T ele){
		element=ele;
	}
	public Node<T> getNext(){
		return next;
	}
	public void setNext(Node<T> next){
		this.next=next;
	}
	
	public Node<T> getPrevious(){
		return previous;
	}
	public void setPrevious(Node<T> previous){
		this.previous=previous;
	}
}
