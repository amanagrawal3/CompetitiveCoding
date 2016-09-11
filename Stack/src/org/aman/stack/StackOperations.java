package org.aman.stack;
import org.aman.stack.Stack;
public class StackOperations<T> implements Comparable<T> {
	Stack<T> s2=new Stack<T>();
	
	@SuppressWarnings("unchecked")
	public  void sort(Stack<T> s1) throws StackException{
		if (s1.isEmpty()){
			System.out.println("Stack is empty");
			return;
		}
		s1.show();
		//s2.push(s1.pop());
		while(!s1.isEmpty()){
			//if (((Comparable<T>) s1.peek()).compareTo(s2.peek())>0){
				T temp=s1.pop();
				while(!s2.isEmpty() && (((Comparable<T>) temp).compareTo(s2.peek())>0)){
						s1.push(s2.pop());
				}
				s2.push(temp);
			}
	//	System.out.println("Aman");
		s2.show();
	}
	@Override
	public int compareTo(T obj) {
		// TODO Auto-generated method stub
		return this.compareTo(obj);
	}
}
