package org.aman.seamaphore;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class BlockingQueueProducer implements Runnable{

	protected BlockingQueue<String> list;
	public BlockingQueueProducer(BlockingQueue<String> queue){
		list=queue;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try{
			Thread.sleep(250);
			list.put("Aman");
			Thread.sleep(500);
			list.put("Agrawal");
			Thread.sleep(750);
			list.put("Rocks");
		}
		catch(InterruptedException e){
			e.printStackTrace();
		}
	}
	
}

class BlockingQueueConsumer implements Runnable{
	BlockingQueue<String> list;
	public BlockingQueueConsumer(BlockingQueue<String> queue){
		list=queue;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try{
		System.out.println(list.take());
		System.out.println(list.take());
		System.out.println(list.take());
		}
		catch(InterruptedException e){
			e.printStackTrace();
		}
	}
	
}


public class ProdCosumer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BlockingQueue<String> blqueue =new ArrayBlockingQueue<String>(1024);
		BlockingQueueProducer queueProducer = new BlockingQueueProducer(blqueue);
		BlockingQueueConsumer queueConsumer = new BlockingQueueConsumer(blqueue);
		new Thread(queueProducer).start();
		new Thread(queueConsumer).start();
	}

}
