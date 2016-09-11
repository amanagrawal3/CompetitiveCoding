package org.aman.heap;

public class HeapOperations<T extends Comparable<?>> {

	private static final int capacity=2;
	private int size;
	T[] heap;
	
	HeapOperations(){
		size=0;
		heap= (T[]) new Comparable[capacity];
	}
	
	HeapOperations(T[] arr){
		heap=(T[]) new Comparable[arr.length+1];
		System.arraycopy(arr,0 , heap, 1, arr.length);
		//this.heap=arr;
		size=arr.length;
		buildHeap();
	}
	
	private void buildHeap(){
		
	}
	
}
