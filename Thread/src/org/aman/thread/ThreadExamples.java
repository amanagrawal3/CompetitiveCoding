package org.aman.thread;

class ThreadDemo extends Thread{
	
	public void run(){
		System.out.println("In my first thread class");
		System.out.println(Thread.currentThread().getName());
	}
}

class Count extends Thread{
	Count(){
		super("MyThread Aman");
		System.out.println("My thread"+this);
		start();
	}
	
	public void run(){
		try{
			for (int i=0;i<100;i++){
				System.out.print(i);
				Thread.sleep(1000);
				Thread.currentThread().wait();
			}}
		catch (InterruptedException e){
			e.printStackTrace();
		}
	}
}

public class ThreadExamples {
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ThreadDemo t1=new ThreadDemo();
		//t1.start();
		//t1.setName("Aman");
		Count t2=new Count();
		
		while (t2.isAlive()){
			System.out.println("Main Thread will be alive till child thread is alive");
		}
		//t2.join();
		System.out.println("Main Thread's run is over");
		}
	}


