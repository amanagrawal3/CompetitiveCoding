package org.aman.design;

interface Duck{
	public void quack();
	public void fly();
}

interface Turkey{
	public void gobble();
	public void fly();
}
class MallardDuck implements Duck{

	@Override
	public void quack() {
	System.out.println("Duck Quack");
	}

	@Override
	public void fly() {
	System.out.println("Duck can fly");		
	}
}
class WildTurkey implements Turkey{
	public void gobble(){
		System.out.println("Turkey can gobble");
	}
	public void fly(){
		System.out.println("Turkey can fly");
	
	}
}
//Use Turkey object in place of Duck object .Writing an Adapter pattern
class TurkeyAdapter implements Duck{
	Turkey t1;
	TurkeyAdapter(Turkey turkey){
		t1=turkey;
	}
	
	public void quack() {
		t1.gobble();
		}

	@Override
	public void fly() {
		for (int i=0;i<5;i++){
			t1.fly();
		}
		
	}
	

 static void testAdapter(Duck duck){
	duck.quack();
	duck.fly();
}}
public class AdapterPattern {

	public static void main(String[] args) {
		MallardDuck duck =new MallardDuck();
		WildTurkey turkey =new WildTurkey();
		TurkeyAdapter adapt1=new TurkeyAdapter(turkey);
		turkey.gobble();
		turkey.fly();
		TurkeyAdapter.testAdapter(duck);
		TurkeyAdapter.testAdapter(adapt1);
	}

}
