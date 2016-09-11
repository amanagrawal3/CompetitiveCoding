package org.aman.singlelinkedlist;

public class Node<T> {
	T element;
	Node<T> link;
	public Node(){
		this.element=null;
		link=null;
	}
	
	public T getElement(){
		return element;
	}
	
	public void setElement(T ele){
		element=ele;
	}
	public Node<T> getLink(){
		return link;
	}
	public void setLink(Node<T> link){
		this.link=link;
	}
}
