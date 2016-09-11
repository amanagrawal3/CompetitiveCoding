package org.aman.abstractexamples;

 abstract class Animal {
	
	public void eat(){
		
		System.out.println("Base class eat called");
	}
	
	abstract public void show();
	
}

class Horse extends Animal{
	
	public void eat(){
		System.out.println("Cild class eat called");
	}
	
	public void show(){
		
	System.out.println("Check Referencetype");
	}
}



public class AbstractMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Horse h=new Horse();
		h.eat();
		h.show();
	//	Animal a = new Animal();
		//a.eat();
		//a.show();
		Animal ah=new Horse();
		ah.eat();
		ah.show();

	}

}
