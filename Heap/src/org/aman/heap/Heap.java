package org.aman.heap;

class HeapException extends RuntimeException{


	private static final long serialVersionUID = 1L;

	HeapException(String msg){
		super();
		System.out.println(msg);
	}
}

public class Heap<T extends Comparable<T>> {
	private T[] data; 
	private int heapsize;
	@SuppressWarnings("unchecked")
	Heap(){
		heapsize=0;
		data=(T[]) new Comparable[10];
	}
	@SuppressWarnings("unchecked")
	Heap(int size){
		this.heapsize=0;
		data=(T[]) new Object[size];
	}


	public int size(){
		return heapsize;
	}

	public boolean isempty(){
		return heapsize==0;
	}

	public T getRoot(){
		if(isempty()){
			throw new HeapException("No elements in Heap");
		}
		return data[0];
	}

	public int getLeftChildIndex(int nodeindex){
		return 2*nodeindex+1;
	}

	public int getRightChildIndex(int nodeindex){
		return 2*nodeindex+2;
	}

	public int getParentIndex(int nodeindex){
		return (nodeindex-1)/2;
	}


	public void insert(T value){
		if (size()>=data.length){
			throw new HeapException("Heap is full");
		}
		heapsize++;
		data[heapsize-1]=value;
		shiftUp(heapsize-1);
	}

	public void shiftUp(int index){
		if (index!=0){
			int 	parentindex=getParentIndex(index);
			if (data[parentindex].compareTo(data[index])>0){
				swap(data,parentindex,index);
				shiftUp(parentindex);
			}}
	}

	public void swap(T[] data,int i,int j){
		T temp=data[i];
		data[i]=data[j];
		data[j]=temp;
	}

	public void remove(){
		if (data.length<=0)
			throw new HeapException("Heap is empty");

		T remove=data[0];
		data[0]=data[heapsize-1];
		if(heapsize>0){
			shiftDown(data,0);
		}
		System.out.println("Item removed is:"+remove);
	}

	public void shiftDown(T[] data,int index){
		int rightchild=getRightChildIndex(index);
		int leftchild=getLeftChildIndex(index);
		int minindex;
		if(rightchild>=heapsize){
			if(leftchild>=heapsize)
				return;
			else
				minindex=leftchild;
		}

		else{
			if(data[leftchild].compareTo(data[rightchild])<0)
				minindex=leftchild;
			else
				minindex=rightchild;
		}
		
		if(data[index].compareTo(data[minindex])>0){
				swap(data,index,minindex);
				shiftDown(data,minindex);
	}

}

}
