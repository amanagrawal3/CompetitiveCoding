package org.aman.interval;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class IntervalOperations {
	public List<Interval> mergeInterval(List<Interval> intervals){
		if(intervals==null||intervals.size()==0)
		return intervals;
		ArrayList<Interval> result=new ArrayList<Interval>();
		Collections.sort(intervals,new IntervalComparator());
		//result.add(intervals.get(0));
		int prestart=intervals.get(0).getStart();
		int preend=intervals.get(0).getEnd();
		for (Interval i:intervals){
		Interval	curr=i;
		  if(curr.getStart()>preend){
			  result.add(new Interval(prestart,preend));
			  prestart=curr.getStart();
			  preend=curr.getEnd();
		}
		else{
		    preend=Math.max(curr.getEnd(), preend);	
		}
		}
		result.add(new  Interval(prestart,preend));
		return result;
		}
 private class IntervalComparator implements Comparator<Interval>{
		public int compare(Interval i1,Interval i2){
			if(i1.getStart()!=i2.getStart())
				return i1.getStart()-i2.getStart();
			else 
				return i1.getEnd()-i2.getEnd();
		}
	}
		
}