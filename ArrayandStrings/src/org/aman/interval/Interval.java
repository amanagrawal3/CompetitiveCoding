package org.aman.interval;

public class Interval {
	int start;
	int end;
	Interval(){
		start=0;
		end=0;
	}
	Interval(int start,int end){
		this.start=start;
		this.end=end;
	}
	
	public int getStart(){
		return start;
	}
	
	public int getEnd(){
		return end;
	}
	public void setStart(int start){
		this.start=start;
	}
	
	public void setEnd(int end){
		this.end=end;
	}
	

}
