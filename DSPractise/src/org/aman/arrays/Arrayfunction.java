package org.aman.arrays;

public class Arrayfunction {
	//To rotate the array by k no.'s
	public void rotateArray(int [] arr,int k){
		
		if (k>arr.length){
			k=k%arr.length;
		}
		
		if (arr==null||k<0){
			throw new IllegalArgumentException("Illegal Argument!");
		}
		System.out.println("Original  array is :"+" ");
		showArray(arr);
		
		int a=arr.length-k;
	
		reverse(arr,0,a-1);
		reverse(arr,a,arr.length-1);
		reverse(arr,0,arr.length-1);
		
		
		System.out.println("Rotated array is :"+" ");
		showArray(arr);
		
	}
	
	
	//to reverse the array
	
	public void reverse(int[] arr,int start,int end){
		int temp;
		
		if (arr==null||arr.length==1)
			return;
		while (start<end){
			temp=arr[start];
			arr[start]=arr[end];
			arr[end]=temp;
			
			start++;
			end--;
		}
		
	}
	
	//to print the array
	public void showArray(int []arr){
		for (int i : arr){
			System.out.print(i+" ");
		}
		System.out.println();
	}

}
