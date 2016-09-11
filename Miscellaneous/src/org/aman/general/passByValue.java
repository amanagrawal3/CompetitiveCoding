package org.aman.general;

class Bike {
	private String color;
	
	Bike(String color){
		this.color=color;
	}
	
	public String getColor(){
		return this.color;
	}
	
	public void setColor(String color){
		this.color=color;
	}
	
	void swap(Bike b1,Bike b2){
		Bike temp =b1;
		b1=b2;
		b2=temp;
	}
	
	void change(Bike b1){
		b1.setColor("Blue");
	}
	
	Bike checkReturn(Bike b1,Bike b2){
		Bike temp =b1;
		b1=b2;
		b2=temp;
		return b1;
	}
}


public class passByValue {

	/**
	 * @param args	
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bike b1=new Bike("Black");
		Bike b2=new Bike("Red");
		System.out.println(b1.getColor());
		System.out.println(b2.getColor());
		b1.swap(b1,b2);
		System.out.println(b1.getColor());
		System.out.println(b2.getColor());
		b1.change(b2);
		System.out.println(b1.getColor());
		System.out.println(b2.getColor());
		
		Bike b3=b1.checkReturn(b1, b2);
		System.out.println(b3.getColor());
	}

}
