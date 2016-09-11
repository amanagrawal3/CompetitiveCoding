package org.aman.heap;

class HeapException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	HeapException(String msg){
		super();
		System.out.println(msg);
	}
}


public class Heap {

	private int[] data;
	private int heapsize;
	
	public Heap(int size){
		data=new int[size];
		heapsize=size;
	}
	
	public int getMinimum() throws HeapException{
		if (isEmpty()){
			throw new  HeapException("Heap is empty");
		}
		else
			return data[0];
	}


public boolean isEmpty(){
	return heapsize==0;
}

public int size(){
	return heapsize;
}


private int getLeftChildIndex(int nodeIndex) {
      return 2 * nodeIndex + 1;
}

private int getRightChildIndex(int nodeIndex) {
      return 2 * nodeIndex + 2;
}

private int getParentIndex(int nodeIndex) {
    return (nodeIndex - 1) / 2;
}


}