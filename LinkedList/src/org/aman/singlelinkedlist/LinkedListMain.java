package org.aman.singlelinkedlist;

public class LinkedListMain {

	public static void main(String[] args) throws LinkListException {
		LinkedListOperations<Integer> l1=new LinkedListOperations<Integer>();
		//l1.deleteFirst();
		l1.insertFirst(1);
		l1.insertFirst(10);
		l1.insertFirst(100);
		l1.insertFirst(1000);
		l1.insertFirst(10000);
		l1.insertFirst(1000000);
		l1.displayLinkList();
	l1.NthNodeFromLast(4);
	l1.middleLinkedList();
	l1.NthNode(5);
	l1.PairWiseSwap();
	l1.displayLinkList();
	l1.moveLastElement();
	l1.displayLinkList();
	l1.reverse();
	l1.displayLinkList();
	}

}
