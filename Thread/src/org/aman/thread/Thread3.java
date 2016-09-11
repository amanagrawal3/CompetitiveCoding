package org.aman.thread;

class Counter implements Runnable{
	private int currentValue;
	public Counter(){
		currentValue=0;
	}
	public int getValue(){
		return currentValue;
	}
	public void run(){
		try{
			while (currentValue<5){
				System.out.println(Thread.currentThread().getName()+":"+currentValue++);
				Thread.sleep(250);
			}
			
		}
		catch(Exception e){
			System.out.println(Thread.currentThread().getName()+"interrupted");
		}
	System.out.println("Exiting from thread:"+Thread.currentThread().getName());
	}
	
}


public class Thread3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Counter c1=new Counter();
		Thread worker=new Thread(c1,"Counter 1");
		System.out.println(worker);
		worker.start();
		try{
			int val;
			do{
				val=c1.getValue();
				System.out.println("Current value read by"+Thread.currentThread().getName()+"is"+val);
				Thread.sleep(250);
			}while (val<=5);
			}
		catch(Exception e){
			System.out.println("Main thread is interruoted");
		}
	System.out.println("Exiting from main thread");
	}

}
