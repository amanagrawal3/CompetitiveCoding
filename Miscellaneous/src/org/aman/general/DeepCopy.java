package org.aman.general;

class C implements Cloneable{
	int i;
	int j;
	C(int i,int j){
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
	public Object clone() throws CloneNotSupportedException{
		return super.clone();
	}
}

class D implements Cloneable{
	int i;
	int j;
	C a;
	D(int i,int j,C a){
		this.i=i;
		this.j=j;
		this.a=a;
	}
	
	public Object clone() throws CloneNotSupportedException{
		D c=(D) super.clone();
		c.a=(C) a.clone();
		return c;
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

public class DeepCopy {

	public static void main(String[] args) {
        C a=new C(1,2);
		D b1 =new D(5,10,a);
		D b2=null;
		try{
			b2=(D) b1.clone();
		}
		catch(CloneNotSupportedException e){
			e.printStackTrace();
		}
		System.out.println(b2.toString());
		b2.a.setI(100);
		System.out.println(b2.toString());
	}

}
