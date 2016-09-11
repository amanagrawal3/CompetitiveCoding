package org.aman.thread;


public class Thread2 {

	
	public static void main(String[] args) {
		Test t1=new Test();
		t1.start();
	}

}


class Test extends Thread{
	Test(){
		setDaemon(true);
	}
	public void run(){
		System.out.println("Run");
		try{
			sleep(10);
		}
		catch(Exception e){
			System.out.println("Run");
		}
	}
	
}
