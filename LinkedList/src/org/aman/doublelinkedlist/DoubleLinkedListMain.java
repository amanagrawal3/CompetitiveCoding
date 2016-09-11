package org.aman.doublelinkedlist;

public class DoubleLinkedListMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DoubleLinkedList<Integer> d1=new DoubleLinkedList<Integer>();
		d1.insertAtHead(1);
		d1.insertAtHead(2);
		d1.insertAtHead(3);
		d1.display();
		
		d1.deleteNode(2);

	}

}
