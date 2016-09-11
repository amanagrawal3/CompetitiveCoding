package org.aman.collections;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class Collections {

	
	public void treeMap(){
		System.out.println("Tree map Implementations");
		TreeMap<Integer,Integer> tmap=new TreeMap<Integer,Integer>();
		tmap.put(3, 1);
		tmap.put(2, 4);
		tmap.put(1, 8);
	//	Set<Entry<Integer, Integer>> set=tmap.entrySet();
		Iterator<Entry<Integer, Integer>> it=tmap.entrySet().iterator();
		while(it.hasNext()){
			Entry<Integer, Integer> thisEntry= it.next();
			System.out.print(thisEntry.getValue()+" ");
		}
	}
	
	public static void main(String[] args) {
		Collections c1=new Collections();
		c1.treeMap();

	}

}
