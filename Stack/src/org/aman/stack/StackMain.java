package org.aman.stack;

public class StackMain {

	
	public static void main(String[] args) throws StackException {
		// TODO Auto-generated method stub
		Stack<Integer> s1=new Stack<Integer>();
		s1.push(6);
		s1.push(2);
		s1.push(4);
		s1.push(1);
		s1.push(9);
		//System.out.println(s1.pop());
		StackOperations<Integer> stopr=new StackOperations<Integer>();
		stopr.sort(s1);
		
		StackArray<Integer> s2=new StackArray<Integer>(6);
		s2.push(1);
		s2.push(2);
		s2.push(3);
		//System.out.println(s2.pop());

	}

}
