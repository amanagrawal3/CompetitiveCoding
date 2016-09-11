package org.aman.general;

public class generics<T> {

	private T t ;
	
	
	
	public T getT(){
		return t;
		}
	public void setT(T t){
		this.t=t;
	}
	public String toString(){
		return t.toString();
	}	
	public static void main(String[] args) {
		@SuppressWarnings("rawtypes")
		generics g1=new generics();
		g1.setT(5);
		System.out.println(g1.toString());

	}

}
