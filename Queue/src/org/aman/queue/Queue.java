package org.aman.queue;

import java.util.Iterator;
import java.util.LinkedList;

public class Queue<T> {
	LinkedList<Integer> queue1=new LinkedList<Integer>();
	LinkedList<Integer> queue2=new LinkedList<Integer>();

	//Stack push using queue methods
	public void push(int item){
		if(queue1.isEmpty() && queue2.isEmpty()){
			queue1.offer(item);
		}
		else{
			if (queue1.size()>0){
				queue2.offer(item);
				while(!queue1.isEmpty())	
					queue2.offer(queue1.poll());
			}
			else if(queue2.size()>0){
				queue1.offer(item);
				while (!queue2.isEmpty())
					queue1.offer(queue2.poll());
			}
		}
	}
	
	//Stack pop using queue methods
	public int pop(){
		if (queue1.isEmpty() && queue2.isEmpty())
			return 0;
		else{
			if (queue1.size()>0)
			 return	queue1.poll();
			else if (queue2.size()>0)
				return queue2.poll();
		}
		return 0;
	}
	//View Stack Top using queue methods
	public int top(){
		if (queue1.isEmpty() && queue2.isEmpty())
			return 0;
		else{
			if (queue1.size()>0)
			 return	queue1.peek();
			else if (queue2.size()>0)
				return queue2.peek();
		}
		return 0;
	}
	
	public void show(){
		if (queue1.size()>0){
			Iterator it=queue1.iterator();
			while (it.hasNext())
				System.out.print(it.next());
		}
		else if (queue2.size()>0){
			Iterator it=queue2.iterator();
			while (it.hasNext())
				System.out.print(it.next()+",");
		}
	}
	
	public static void main(String[] args) {
		Queue mystack =new Queue();
		mystack.push(4);
		mystack.push(0);
		mystack.push(45);
		mystack.push(1000);
		System.out.println(mystack.top());
		System.out.println(mystack.pop());
		//mystack.show();
		//System.out.println(mystack);
	}

}
