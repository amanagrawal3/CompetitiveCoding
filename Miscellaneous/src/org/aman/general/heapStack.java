package org.aman.general;

public class heapStack {

 private void check(int i,Object param){
	 String str=param.toString();
	 System.out.println(str);
	 System.out.println(param.toString());
 }
	public static void main(String[] args) {
		int i=1;
		Object obj=new Object();
heapStack hs1=new heapStack();
hs1.check(i,obj);
System.out.println(obj.toString());
	}

}
