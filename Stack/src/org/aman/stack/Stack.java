package org.aman.stack;
import java.util.*;

class StackException extends Exception{
	private static final long serialVersionUID = 1L;

	StackException(String Message){
		super();
		System.out.println(Message);
	}
}

public class Stack<T> {
	private int size;	
	private ArrayList<T> arr;
	private int top=-1;
	Stack(){
		arr=new ArrayList<T>();
		size=0;
	}

	public void push (T data) throws StackException{
		if(data ==null)
			throw new StackException("Data cannot be null");
		else{
			arr.add(0,data);
			size++;
			top++;
	}
	}

	public T pop(){
		if (isEmpty()){
			System.out.println("Stack is empty");
			return null;
		}
		T temp=arr.remove(0);
		size--;
		top--;
		return temp;
	}
	
	public int getTop(){
		return top;
	}
	
	public T peek(){
		return arr.get(0);
	}
	public int getSize(){
		return size;
	}
	
	public boolean isEmpty(){
		return size==0;
	}
	
	public void show(){
		System.out.println();
		for (T i:arr){
			System.out.print(i+" ");
		}
	}


}
