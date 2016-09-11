package org.aman.queue;

import org.aman.stack.Stack;



public class QueueUsingStack<T> {

	Stack<T> s1=new Stack<T>();
	Stack<T> s2=new Stack<T>();

	public void enqueue(T data) throws Exception{
		try {
			if (data==null)
				throw new Exception("Data cannot be null");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		while(!s1.isEmpty()){
			s2.push(s1.pop());
		}
		s1.push(data);
		
		while(!s2.isEmpty()){
			s1.push(s2.pop());
		}
	}

	public T dequeue() throws Exception{
		return s1.pop();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
