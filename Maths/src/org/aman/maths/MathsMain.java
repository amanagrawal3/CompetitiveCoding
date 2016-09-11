package org.aman.maths;
class Maths{
	public int divisible3and5(int n){
		if(n==0 || n<0)
			return 0;
		int sum=0;
		for (int i=1;i<n;i++){
		 if(i%3==0||i%5==0){
			 sum=sum+i;
		 }
		}
		return sum;
		
	}
}
public class MathsMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Maths m1=new Maths();
		System.out.println(m1.divisible3and5(10));
		
		System.out.println(Math.floor(Math.sqrt(5)));
	}

}
