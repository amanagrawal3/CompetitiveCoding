package org.aman.heap;

public class HeapMain {

	
	public static void main(String[] args) {
		Heap<Integer> h1=new Heap<Integer>();
		h1.insert(1);
	h1.insert(2);
	h1.insert(0);
	h1.insert(-2);
//	System.out.println(h1.getRoot());
	h1.remove();
	h1.remove();
	}

}
