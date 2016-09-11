package org.aman.array;

public class ArrayMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Arrays2 a1=new Arrays2();
		int[] arr={1,1,1,1,1,1};
		//a1.NoOfOccurence(arr, 6);
		//a1.binarySearch(arr, 6);
		//int[] arr2={2,3,4,2,4,3,3,3,4,2};
		//a1.sort3Integer(arr2);
		int[] arr3={1,1,1,0,0,0,0,2,2,2};
		//a1.sort2elements(arr3);
		int[] arr4={10, 90, 49, 2, 1, 5, 23};
		//System.out.println(a1.search(arr4, 9));
		//	a1.removeDuplicate(arr3);
		int[] arr5={1,2,3,2,5,2,4,2,3,2,2,5,2};
		ArrayOperations a2=new ArrayOperations();
		a2.sortinWaveForm(arr4);


		int val[] = new int[]{60, 100, 120};
		int wt[] = new int[]{10, 20, 30};
		int  W = 50;
		System.out.println(a2.knapsackRecursive(W, wt, val, wt.length-1));
		//System.out.println(a2.knapSack(W, wt, val, wt.length));

		int[] a3={8,3,1,2};
		a2.maxSumArrayRotation(a3);

		int[] a4={1,2,4};
		a2.missingNumber(a4, 4);
		int[] a5={2,5,4,2,3};
		a2.repeatedAndMissingNumber(a5);
		//  System.out.println(Math.abs(-4));

		System.out.println(9 & ~8);
		System.out.println(Integer.toBinaryString(9));
		System.out.println(Integer.toBinaryString(-9));

		int[] a6={2,4,5,1,6,0,2,4,8,9};
		ArrayOperations ao1=new ArrayOperations();
		ao1.checkPairSum(a6, 6);
		int[] majority={2,2,2,2,1,1,1,1,2,2,3,4,2,4,1,1,1,1,1,1,1,1,1};
		ao1.majorityElement(majority);
		int[] majoritySorted={1,1,1,1,2,2,2,3,3,3,3,3,};
		ao1.majorityElementSorted(majoritySorted);

		int[] seggragate01={1,1,1,0,0,0,1,0,0,1};
		ao1.seggragate(seggragate01);

		int[] leader={4,3,5,6,2,1};
		ao1.findLeader(leader);
		
		int[] merge1={1,2,3,4,5};
		int[] merge2={3,4,6};
		ao1.merge(merge1, merge2);
		//System.out.println(9/2);

	}

}
