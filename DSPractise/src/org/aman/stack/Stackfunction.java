package org.aman.stack;
import java.util.*;
public class Stackfunction {
	
	//reverse Polish Notation
	public void reversePolish(String[] tokens){
		int value=0;
		Stack<String> stk=new Stack<String>();
		String operators="+-/*";
		for (String str:tokens){
		if(!operators.contains(str)){
			stk.push(str);
		}
		else{
			int a=Integer.valueOf(stk.pop());
			int b=Integer.valueOf(stk.pop());
			int index=operators.indexOf(str);
			switch (index){
			case 0:
				stk.push(String.valueOf(a+b));
				break;
			case 1:
				stk.push(String.valueOf(a-b));
				break;
			case 2:
				stk.push(String.valueOf(a/b));
				break;
			case 3:
				stk.push(String.valueOf(a*b));
				break;
			}
				
		}
		}
		System.out.println("Calculated result is:"+" "+Integer.valueOf(stk.pop()));
		
			
		
		
		
		
	}

}
