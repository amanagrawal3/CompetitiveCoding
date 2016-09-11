package org.aman.stack;
class StackException extends Exception{
	private static final long serialVersionUID = 1L;
	
	StackException(String msg){
		super();
		System.out.println(msg);
	}
}

public class Stack<T> {

	T[] arr;
	private int top;
	private int size;
	private int capacity;
	@SuppressWarnings("unchecked")
	
	public Stack(){
		capacity=20;
		arr= (T[]) new Object[capacity];
		top=-1;
		size=0;
		
	}

	@SuppressWarnings("unchecked")
	public Stack(int capacity){
		this.capacity=capacity;
		arr= (T[]) new Object[capacity];
		top=-1;
		size=0;		
	}

	public int size(){
		return size;
	}

	public void push(T data) throws StackException{
		if (data==null)
			throw new StackException("Data cannot be null");
		if(size>=capacity){
			throw new StackException("Capacity is full");
		}
		else{
			arr[++top]=data;
			size++;
		}
	}

	public T pop() throws StackException{
		if(size==0)
			throw new StackException("Stack is empty");

		T temp=arr[top];
		arr[top]=null;
		top--;
		size--;
		return temp;
	}

	public void peek() throws StackException{
		if(size==0)
			throw new StackException("Stack is empty");
		System.out.println(arr[top]);
	}

	public boolean isEmpty(){
		return size==0;
	}

}
