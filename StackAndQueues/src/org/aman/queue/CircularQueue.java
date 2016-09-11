package org.aman.queue;

public class CircularQueue<T> {

	private int front;
	private int rear;
	T[] arr;
	private int capacity;
	private int size;

	@SuppressWarnings({ "unchecked", "unused" })
	CircularQueue(int capacity){
		T[] arr=(T[]) new Object[capacity];
		front=rear=-1;
		size=0;
	}

	public void enqueue(T data){
		if(front==(rear+1)% arr.length){
			System.out.println("No plce to fill");
			return;
		}

		if(front==-1){
			arr[0]=data;
			front=0;
			rear=0;
		}
		rear=(rear+1)%arr.length;
		arr[rear]=data;
	}
	
	public void dequue(){
		
	}

}
