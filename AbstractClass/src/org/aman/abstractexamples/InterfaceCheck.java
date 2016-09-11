package org.aman.abstractexamples;

interface A{
	void check();
}

abstract class B implements A{
	public void check(){
		System.out.println("In abstract class");
	}
}

public class InterfaceCheck extends B implements A{

//	public void check(){
	//	System.out.println("In concrete class");
	//}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		A a =new InterfaceCheck();
		a.check();
		B b =new InterfaceCheck();
		b.check();

	}

}
