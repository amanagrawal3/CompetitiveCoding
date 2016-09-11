package org.aman.singlelinkedlist;

public class LinkedListOperations<T> {

	private Node<T> head;
	private int size;
	LinkedListOperations(){
		head=null;
		size=0;
	}
	
	public void insertFirst(T element){
		Node<T> newNode= new Node<T>();
		newNode.setElement(element);
		size++;
		newNode.setLink(head);
		head=newNode;
	}
	
	public  T deleteFirst() throws LinkListException{
		if (head==null)
			throw new LinkListException("List is empty");
		Node<T> temp=head;
		T data=temp.getElement();
		head=head.getLink();
		return data;
	}
	
	public void displayLinkList() throws LinkListException{
		if (head==null)
			throw new LinkListException("List is empty");
		Node<T> temp =head;
		while (temp!=null){
			System.out.print(temp.getElement()+"-->");
			temp=temp.getLink();
		}
		System.out.println();
	}
	public int getSize(){
		return size;
	}
	
	//Find Nth node from end of linked list
	public void NthNodeFromLast(int n) throws LinkListException{
		if (n<0|| n>getSize())
			throw new LinkListException("N is incorrect");
		Node<T> temp=head;
		int i=1;
		while(i<getSize()-(n-1)){
			temp=temp.getLink();
			i++;
		}
		System.out.println(temp.getElement());
	}
	
	//Find middle of linked list
	public void middleLinkedList(){
		int length=getSize();
		int i=1;
		Node<T> temp=head;
		while (i<(length/2)+1){
			temp=temp.getLink();
			i++;
		}
		System.out.println(temp.getElement());
	}
	//Find the NthNode in a linkedList
	public void NthNode(int n) throws LinkListException{
		if (n<0 || n>getSize())
			throw new LinkListException("N is incorrect");
		int i=0;
		Node<T> temp=head;
		while (i<n-1){
			temp=temp.getLink();
			i++;
		}
			System.out.println(temp.getElement());
	}
	
	//pairwise swap elements of LinkedList
	public void PairWiseSwap(){
		if(head==null){
			System.out.println("List is empty");
			return;
		}
		Node<T> curr=head;
		while(curr!=null && curr.getLink()!=null){
			T temp=curr.getElement();
			curr.setElement(curr.getLink().getElement());
			curr.getLink().setElement(temp);
			curr=curr.getLink().getLink();
		}
		}
	
	//Move last Element to front of linkedList
	
	public void moveLastElement(){
		
		Node<T> temp=head;
		Node<T> next=temp.getLink();
		while(temp.getLink().getLink()!=null){
			temp=temp.getLink();
			next=temp.getLink();
			
		}
		temp.setLink(null);
		next.setLink(head);
		head=next;
	}
	
	public void reverse(){
		reverse(head);
	}
	
	private void reverse(Node<T> head){
		if(head==null)
			return;
		Node<T> prev=null;
		Node<T> curr=head;
		Node<T> next=curr.getLink();
		while(curr!=null && next!=null){
			next=curr.getLink();
			curr.setLink(prev);
			prev=curr;
			curr=next;
		}
		head=prev;
	}
	
	//Reorder a  linked list in-place 
	
	/**Given a singly linked list L: L0 =L1,Ln,Ln-1,Ln;
                   reorder it to: L0,Ln,L1,Ln-1,L2,Ln-2..**/
	
	public void reOrder(){
		
	}

}

