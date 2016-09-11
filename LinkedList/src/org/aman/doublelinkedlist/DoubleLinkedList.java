package org.aman.doublelinkedlist;

public class DoubleLinkedList<T> {
	Node<T> head;
	Node<T>tail;
	private int size;
	
	DoubleLinkedList(){
		head=tail=null;
	}
	
	public void insertAtHead(T data){
		Node<T> newNode=new Node<T>();
		newNode.setElement(data);
		size++;
		if (head==null && tail==null){
			head=tail=newNode;
		}
		else{
			newNode.setNext(head);
			head.setPrevious(newNode);
			head=newNode;
		}
	}
	
	public void insertAtTail(T data){
		Node<T> newNode=new Node<T>();
		newNode.setElement(data);
		size++;
		if (head==null && tail==null){
			head=tail=newNode;
		}
		else{
			tail.setNext(newNode);
			newNode.setPrevious(tail);
			tail=newNode;
		}
	}
	
	public int getSize(){
		return size;
	}
	public void display(){
		Node<T> temp=head;
		while(temp!=null){
			System.out.print(temp.getElement()+" ");
			temp=temp.getNext();
		}
	}
	
	public void deleteNode(int n){
		Node<T> temp=head;
		for(int i=0;i<n;i++){
			temp=temp.getNext();
		}
		deleteNode(temp);
	}
	
	//Given a node delete a linked list
	private void deleteNode(Node<T> curr){
		Node<T> temp=curr.getNext();
		
		if (temp.getPrevious()==null){
			head=temp.getNext();
			head.setPrevious(null);
			return;
		}
		
		else if (temp.getNext()==null){
			temp.setPrevious(tail);
			tail.setNext(null);
			return;
		}
		else {
			
		}
	}
	

}
