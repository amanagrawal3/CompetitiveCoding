package org.aman.abstractexamples;

public class Overloading {

	public static void main(String[] args) {

		Overloading obj = new Overloading();
		obj.overLoad(new Integer(0));
		obj.show(5);
	}

	 private void show(Number n){
		 System.out.println("in number");
	 }
	 private void show(Integer n){
		 System.out.println("in integer");
	 }
	 
	private void overLoad(Object o) {
		System.out.println("Object o argument method.");
	}

	private void overLoad(Double dArray) {
		System.out.println("double array argument method.");
	}

}