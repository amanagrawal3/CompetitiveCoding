package org.aman.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ArrayOperations {


	/**Given an unsorted array of integers, sort the array into a wave like array. 
An array ‘arr[0..n-1]’ is sorted in wave form if arr[0] >= arr[1] <= arr[2] >= arr[3] <= arr[4]**/
	public void sortinWaveForm(int[] arr){
		show(arr);
		for (int i=0;i<arr.length;i+=2){
			if (i>0 && arr[i-1]>arr[i]){
				swap(arr,i,i-1);
			}
			else if (i<arr.length-1 && arr[i+1]>arr[i]){
				swap(arr,i,i+1);
			}
		}
		show(arr);

	}

	public void swap(int[] arr,int i,int j){
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}

	public void show(int[] arr){
		System.out.println();
		for (int i:arr){
			System.out.print(i+" ");
		}
	}

	//Find the smallest positive number missing from an unsorted array

	public int smallestPositive(int[] arr){
		int len =arr.length;
		if(len==1 && arr[0]!=1)
			return 1;
		int end=seggregatePositive(arr);	 	
		for (int i=0;i<=end;i++){

		}

		return 0;
	}

	public int seggregatePositive(int[] arr){

		int j=arr.length;
		for (int i=0;i<arr.length;i++){
			if(arr[i]<=0){
				swap(arr,i,j--);
			}
		}
		return j;
	}

	//Knapsack problem by recursion

	public int knapsackRecursive(int W,int w[],int v[],int n ){

		if (W==0||n==0)
			return 0;

		if (w[n]>W)
			return knapsackRecursive(W,w,v,n-1);

		else 	
			return Math.max(v[n]+knapsackRecursive(W-w[n],w,v,n-1), knapsackRecursive(W,w,v,n-1));

	}

	/**---------------------------------------------------------------------------------------------------------------------------------------------------
	 * http://www.geeksforgeeks.org/find-maximum-value-of-sum-iarri-with-only-rotations-on-given-array-allowed/ 
	 * @param arr
	 */

	public void maxSumArrayRotation(int[] arr){
		if (arr.length==0)
			return;
		if (arr.length==1)
			System.out.println("Max sum is:"+ 1*arr[0] );
		int count=arr.length;
		int j=0;
		int maxValue=Integer.MIN_VALUE;
		while (j<count){
			int sum=0;
			int temp=arr[0];

			for (int i=0;i<arr.length-1;i++){
				arr[i]=arr[i+1];
			}
			arr[arr.length-1]=temp;
			int k=0;
			for (int i:arr){
				//System.out.print(i);
				sum=sum+(k*i);
				k++;
			}
			//System.out.println("debug:" +sum );
			if (sum>maxValue)
				maxValue=sum;
			//System.out.println();
			j++;
		}
		System.out.println(maxValue);
	}

	/*
	 * ---------------------Find missing number in an array-----------------------------------------------------------------------------------
	 */

	//Using XOR (O(n)) Soln for non duplicate elements


	public void missingNumber(int[] arr,int n){
		int res1=0, res2 = 0;
		for (int i=1;i<=n;i++){
			res1=res1^i;
		}
		System.out.println(res1);

		for (int i=0;i<arr.length;i++){
			res2=res2^arr[i];
		}

		System.out.println("Missing number is :"+(res1^res2));	
	}

	//1 number repeated and 1 number repeating using element as index and mark it visiting

	public void repeatedAndMissingNumber(int[] arr){
		for (int i=0;i<arr.length;i++){
			if(arr[Math.abs(arr[i])-1]>0){
				//	System.out.println(arr[Math.abs(arr[i])-1]);
				arr[Math.abs(arr[i])-1]=-arr[Math.abs(arr[i])-1];
			}
			else 
				System.out.println("Repeated element is:"+Math.abs(arr[i]));
		}

		for (int i=0;i<arr.length;i++){
			if(arr[i]>0)
				System.out.println("Missing Element is "+i+1);
		}
	}

	//	1 number repeated and 1 number missing using XOR

	/**
	 * @param arr
	 */



	//-----------------------------------------------------------------------------------
	/** Given an array A[] and a number x ,check for pair in A[] with sum as x
	 * O(n)-time and O(n) space with HashMap
	 */ 

	public void checkPairSum(int arr[],int sum){
		HashMap<Integer,Integer> hmap=new HashMap<Integer,Integer>();

		class result{
			int first;
			int last;

			result(int first,int last){
				this.first=first;
				this.last=last;
			}

			public void show(){
				System.out.println("Pair is:" +first+":"+last);
			}
		}

		List<result> res =new ArrayList<result>();
		for (int i=0;i<arr.length;i++){

			if (hmap.containsKey(arr[i]))
				hmap.put(arr[i], hmap.get(arr[i]+1));
			else
				hmap.put(arr[i], 1);
		}

		for (int i=0;i<arr.length;i++){
			if (hmap.containsKey(sum-arr[i])){
				res.add(new result(arr[i],sum-arr[i]));
				if(hmap.get(sum-arr[i])>1){
					hmap.put(sum-arr[i], hmap.get(sum-arr[i])-1);
				}
				else {
					hmap.remove(sum-arr[i]);
					hmap.remove(arr[i]);
				}
			}
		}

		for (result s:res){
			s.show();
		}
	}


	//---------------------------------------------------------------------------------------------------------------

	/** Find the majority element  in an array(element appearing more than n/2 times in an array)
	 * Moore-voting algorithm works in O(n) time.First it finds the candidate and then check if it is a majority element
	 */

	public void majorityElement(int[] arr){
		if (arr==null){
			System.out.println("Not an valid input array");
			return;
		}
		if (arr.length>1){
			System.out.println(arr[0]);
		}
		int x=findCandidate(arr);
		//System.out.println("Candidate is:"+x);
		boolean majority=isMajority(arr,x);
		if(majority){
			System.out.println("Majority Element of unsorted array is:"+x);
			return;
		}
		System.out.println("No Majority Element found");
	}
	public int findCandidate(int[] arr){
		int maj_index=0;
		int count=1;

		for (int i=1;i<arr.length;i++){
			if (arr[i]==arr[maj_index]){
				count++;
			}
			else
				count--;
			if (count==0){
				maj_index=i;
				count=1;
			}
		}
		return arr[maj_index];
	}

	public boolean isMajority(int[] arr,int x){
		int count=0;
		for (int i:arr){
			if (i==x)
				count++;
		}
		//System.out.println("count is:"+count);
		if (count>arr.length/2)
			return true;
		return false;
	}


	//--------------------------------------------------------------------------------------------------------------------------------

	/**Seggragate 0's on left side and 1's on right side in an array of 0 & 1
	 * O(n) time for traversing
	 */

	public void seggragate(int[] arr){
		int left=0;
		int right;
		if (arr[arr.length-1]==1)
			right=arr.length-2;
		else
			right=arr.length-1;
		while (left<right){

			while(arr[left]==0 && left<right)
				left++;
			while(arr[right]==1 && left<right)
				right--;
			if (left<right){
				swap(arr,left,right);
				right--;
				left++;
			}
		}
		System.out.print("Seggragate array of 0 and 1 is : ");
		for (int i:arr){
			System.out.print(i+",");
		}
	}

	//-------------------------------------------------------------------------------------------------------------------------------

	/** Find the leaders in an array(A leader is an element  for which all the elements to right is smaller than the number 
	 * and rightmost element is always a leader
	 * O(n) time 
	 */
	public void findLeader(int[] arr){
		System.out.println();
		List<Integer> result =new ArrayList<Integer>();
		int max_so_far=arr[arr.length-1];
		for (int i=arr.length-2;i>=0;i--){
			if(arr[i]>max_so_far){
				max_so_far=arr[i];
				result.add(arr[i]);
			}
		}
		result.add(arr[arr.length-1]);
		System.out.print("Leader element in an array is :"+" ");
		for (Integer i:result){
			System.out.print(i+",");
		}
	}

	//---------------------------------------------------------------------------------------------------------------------------------
	/**find the maximum sum of sub array such that no two elements are adjacent
	 *   
	 */


	public void maximumSumNonAdjacent(int[] arr){

	}





	//----------------------------------------------------------------------------------------------------------------------------------

	/** Find the majority element in an sorted array
	 *O(n) time 
	 */

	public void majorityElementSorted(int[] arr){
		int maj_index=0;
		int count=1;
		int i=1;
		while (i<arr.length){
			if  (arr[maj_index]==arr[i] ){
				count++;
			
			if (count>arr.length/2){
				System.out.println("Majority element of sorted array is :"+ arr[maj_index]);
				return;
			}}
			else {
				count=1;
				maj_index=i;
			}
			i++;
		}
		System.out.println("Majority Element of sorted array is not found");
	}
	
//----------------------------------------------------------------------------------------------------------------------------------------
	
	/** Merge an sorted array of size n into another array of size m+n
	 * 
	 */
	
	public void merge(int[] arr1,int[] arr2){
		int[] result=new int[arr1.length+arr2.length];
		int i=0,j=0;
		int k=0;
	 while (i<arr1.length && j<arr2.length){
		 if (arr1[i]>arr2[j]){
			 result[k]=arr2[j];
			 k++;j++;
		 }
		 else if (arr1[i]<arr2[j]){
			 result[k]=arr1[i];
			 k++;i++;
		 }
		 
		 else {
			 result[k]=arr1[i];
			 i++;j++;k++;
		 }
	 }	 
		 while (i<arr1.length){
			 result[k]=arr1[i];
			 k++;i++;
		 }
		 
		 while (j<arr2.length){
			 result[k]=arr2[j];
			 k++;j++;
		 }
		 
	 
	 System.out.println();
	 System.out.print("Merged array is :" + " ");
		 for (int number:result)
			 System.out.print(number+",");
		
	}
	
	
	//-----------------------------------------------------------------------------------------------------------------------------------
	
	/**There are two sorted arrays. First one is of size m+n containing only m elements. Another one is of size n and contains n elements.
	 *  Merge these two arrays into the first array of size m+n such that the output is sorted.
	 */
	
	public void mergeInFirst(){
		
	}
}
