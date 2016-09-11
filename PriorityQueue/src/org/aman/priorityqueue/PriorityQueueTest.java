package org.aman.priorityqueue;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;


class Items implements Comparable<Items>{
	String name;
	int rank;
	Items(String name,int rank){
		this.name=name;
		this.rank=rank;
	}

	public boolean equals(Items i){
		if (i==null){
			return false;
		}
		if (getClass()!=i.getClass()){
			return false;
		}
		if (this.rank!=i.rank){
			return false;
		}
		if ((this.name==null)?(i.name!=null):!this.name.equals(i.name)){
			return false;
		}
		return true;
	}

	public int hashCode(){
		int hash=5;
		hash=97+ ((this.name!=null)?this.name.hashCode():0);
		hash=97+(this.rank);
		return hash;
	}
	public int compareTo(Items arg0) {
		if (this.rank==arg0.rank)
			return this.name.compareTo(arg0.name);

		return this.rank-arg0.rank;
	}
	public String toString(){
		return this.name+" :"+ this.rank; 
	}
}
public class PriorityQueueTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Queue<Items> queue1=new PriorityQueue<Items>(10,Collections.reverseOrder());
		queue1.add(new Items("Aman",5));
		queue1.add(new Items("dilu",2));
		queue1.add(new Items("shubh",8));
		System.out.println(queue1);
		System.out.println(queue1.poll());
	}

}
