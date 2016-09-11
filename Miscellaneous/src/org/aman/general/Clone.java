package org.aman.general;

class A {
	
	int i;
	int j;
	A(int i,int j){
		this.i=i;
		this.j=j;
	}
	
	public int getI(){
		return i;
	}
	public int getJ(){
		return j;
	}
	public void setI(int i){
		this.i=i;
	}
	public void setJ(int j){
		this.j=j;
	}
}

class B implements Cloneable{
	int i;
	int j;
	A a;
	B(int i,int j,A a){
		this.i=i;
		this.j=j;
		this.a=a;
	}
	
	public Object clone() throws CloneNotSupportedException{
		return super.clone();
	}
	public int getI(){
		return i;
	}
	public int getJ(){
		return j;
	}
	public void setI(int i){
		this.i=i;
	}
	public void setJ(int j){
		this.j=j;
	}
	public String toString(){
		return "i is :"+i +"j is:" +j+"a.i is:"+a.i+"a.j is:"+a.j;
	}
}

public class Clone {

	public static void main(String[] args) {
        A a=new A(1,2);
		B b1 =new B(5,10,a);
		B b2=null;
		try{
			b2=(B) b1.clone();
		}
		catch(CloneNotSupportedException e){
			e.printStackTrace();
		}
		System.out.println(b2.toString());
		b2.a.setI(100);
		System.out.println(b2.toString());
	}

}
