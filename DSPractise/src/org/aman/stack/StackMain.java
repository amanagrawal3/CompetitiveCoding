package org.aman.stack;

public class StackMain {

	public static void main(String[] args) {
		
		
		String[] tokens=new String[] {"2", "1", "+", "3", "*" };
		
		Stackfunction s1=new Stackfunction();
		s1.reversePolish(tokens);
		
	}

}
