package org.aman.array;

import java.util.Collections;
import java.util.*;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Arrays2 {
	//static int count=0;
	//Number of occurrences of a number in a sorted array.
	public void NoOfOccurence(int[] arr,int i){
		if (arr==null)
			return;
		int start=0;
		int end=arr.length-1;
		int count=0;
		while (start<end){
			int mid=((start+end)/2);
		
			if(arr[mid]>i){
				end=mid-1;
			}
			else if (arr[mid]<i){
			 start=mid+1;
			}
			else if (arr[mid]==i){
				int found=mid;
				int found2=mid+1;
				while ( arr[found]==i && found>start){
					//System.out.println("Hi element found ->" +found+":"+arr[found]);
					count++;
					found--;
				}
				while (arr[found2]==i && found2<end){
				//	System.out.println("Hi element found2->" +found2+":"+arr[found2]);
					count++;
					found2++;
				}
				if(found==0 && arr[0]==i)
					count++;
				if(found2==arr.length-1 && arr[arr.length-1]==i)
					count++;
			break;
			}
		}
		System.out.println(count);
	}

	public void binarySearch(int[] arr,int i){
		if (arr==null)
			return;
		int start=0;
		int end=arr.length-1;
			boolean found=false;
		int pos=0;
		while (start<end){
			int mid=((start+end)/2);
		
			if(arr[mid]>i){
				end=mid-1;
			}
			else if (arr[mid]<i){
			 start=mid+1;
			}
			else if (arr[mid]==i){
			    found=true;
			    pos=mid;
			    break;
			}
		}
		if (found)
		System.out.println(pos);
	}
	
	// Sort an array that contain multiple occurence of 3 integer
	
	public void sort3Integer(int[] arr){
		TreeMap<Integer,Integer> hmap=new TreeMap<Integer,Integer>();
		
		for (int i:arr){
			if(hmap.containsKey(i)){
				hmap.put(i, hmap.get(i)+1);
			}
			else {
				hmap.put(i, 1);
			}
		}
		Iterator<Entry<Integer, Integer>> it=hmap.entrySet().iterator();
		while(it.hasNext()){
			Entry<Integer,Integer> entry=it.next();
			int start=0;
			int j=start;
			int i=0;
			while (i<entry.getValue()){
			arr[j]=entry.getKey();
			j++;
			}
			start=j++;
		}
		show(arr);
	}
	
	public void show(int[] arr){
		for (int i :arr){
			System.out.print(i+",");
		}
	}
	//Sort array of 2 elements in 1 pass
	public void sort2elements(int[] arr){
		int start=-1;
		int end=arr.length;
		
		for (int i=0;i<arr.length;i++){
			if (arr[i]==1){
				swap(arr,i,end--);
			}
			else {
				swap(arr,start++,i);
			}
		}
		show(arr);
	}
	
	public void swap(int[] arr,int i ,int j){
		int temp=i;
		i=j;
		j=temp;
	}
	
	//Search in a sorted array rotated by N
	
	public boolean search(int[] arr,int data){
		
		int start=0;
		int end=arr.length-1;
		while (start<=end){
			int mid =(start+end)/2;
			
			if (arr[mid]>=arr[start]){
				if (arr[start]<=data &&  data<arr[mid])
					end=mid-1;
				else
					start=mid+1;
			}
			else {
			   if(arr[mid]<data && arr[end]>=data)
				   start=mid+1;
			   else
				   end=mid-1;
			}
			
			if  (arr[mid]==data){
				System.out.println("Element found at "+mid);
				return true;
			}
		}
		
		
		return false;
	}
	
	// Remove duplicate elements from a unsorted array
	
	public void removeDuplicate(int[] arr){
		int c=arr.length;
		for (int i=0;i<arr.length;i++){
			System.out.println();
		
			for (int j:arr){
				System.out.print(j+"-");
			}
			
			int removed=removeDuplicateFromUnSorted(arr,c,i+1,arr[i]);
			
		c=c-removed;
			
		}
		
		
	}
	
	private int removeDuplicateFromUnSorted(int[] arr,int len,int start,int toBeRemoved){
		int i=start;
		int j=start;
		int removed=0;
		System.out.println("toberemoved is:"+toBeRemoved);
		while (i<len){
			if (arr[i]!=toBeRemoved) {
				System.out.println("arr[i]!=toBeRemoved"+ String.valueOf(arr[i]!=toBeRemoved));
				arr[j]=arr[i];
				j++;
			}
			else{
				removed++;
			}
			i++;
		}
		return removed;
	}
	
	
	
	//Kth largest element in an array
	
	public void klargest(int[] arr,int k){
		if (arr==null||k==0)
			return;
		java.util.Arrays.sort(arr);
		System.out.println(arr[k-1]);
	}
	
	public void kSmallestQuickSelect(int[] arr,int l,int r,int k){
		if (k>0 && k<r-l+1){
			int pos=partition(arr,l,r);
		}
	}
	
	int partition(int[] arr,int l,int r){
		
		int temp=arr[r];
		int i=l;
		for (int j=1;j<r-1;j++){
			if (arr[j]<=temp){
				swap(arr,arr[i],arr[j]);
				i++;
			}
		}
		return 0;
	}
	
	//Max and Min of an array in least comparison
	
	public void findMinMax(int[] arr){
		
	}
}
