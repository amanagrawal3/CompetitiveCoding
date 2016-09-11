package org.aman.stack;

public class StackArray<T> {
	private	T[] arr;
	private int size;
	private int capacity;
	private int top;
	@SuppressWarnings("unchecked")
	StackArray(int capacity){
		this.arr=(T[]) new Object[capacity];
		size=0;
		this.capacity=capacity;
		top=-1;
	}
	
	public void push (T data) throws StackException{
		if(data ==null)
			throw new StackException("Data cannot be null");
		if (getSize()>=capacity)
			throw new StackException("Stack is full");
		else{
			arr[++top]=data;
			size++;
	}
	}

	public T pop(){
		if (isEmpty()){
			System.out.println("Stack is empty");
			return null;
		}
		T temp=arr[top];
		arr[top]=null;
		top--;
		size--;
		return temp;
		
	}
	
	public T peek(){
		return arr[top];
	}
	public int getSize(){
		return size;
	}
	
	public boolean isEmpty(){
		return size==0;
	}
}
