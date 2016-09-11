package org.aman.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class StringsOperations {
	public String reverseString(String s){
		if(s==null){
			return null;
		}
		String[] arr=s.split(" ");
		StringBuilder result =new StringBuilder();
		for (int i=arr.length-1;i>=0;i--){
			result.append(arr[i]+" ");
		}
		s=result.toString();
		return s;
	}
	
	public void reverseInPlace(String  str){
		if(str==null||str.length()==0)
			return ;
		
		char[] arr=str.toCharArray();
		int i=0;
		for (int j=0;j<arr.length;j++){
			if (arr[j]==' '){
				reverse(arr,i,j-1);
				i=j+1;
			}}
			reverse(arr,i,arr.length-1);
			reverse (arr,0,arr.length-1);
		
		System.out.println(String.valueOf(String.valueOf(arr)));
	}
	

	
	public void reverse(char[] arr,int i,int j){
		while (i<j){
			char temp=arr[i];
			arr[i]=arr[j];
			arr[j]=temp;
			i++;
			j--;
		}
		//System.out.println(String.valueOf(arr));
	}
	
	public boolean isomorphic(String str1,String str2){
		if ((str1==null && str2!=null)||(str2==null && str1!=null)||(str1.length()!=str2.length()))
			return false;
		HashMap<Character,Character> hmap=new HashMap<Character,Character>();
			for (int i=0;i<str1.length();i++){
				char c1=str1.charAt(i);
				char c2=str2.charAt(i);
				
				if(hmap.containsKey(c1)){
					if(hmap.get(c1)!=c2){
						return false;
					}}
					else {
						if (hmap.containsValue(c2))
							return false;
						hmap.put(c1, c2);
					}
				}
					
		return true;
	}
	
	// Find the number of times each character occurs in the string.
	
	public void countFrequency(String str){
		
		HashMap<Character,Integer> hmap= new HashMap<Character,Integer>();
		System.out.println(str);
		for (Character i: str.toCharArray()){
			if (hmap.containsKey(i)){
				hmap.put(i, hmap.get(i)+1);
			}
			else {
				hmap.put(i, 1);
			}
			
			for (Entry<Character, Integer> entry:hmap.entrySet()){
				System.out.println(entry.getKey().hashCode());
				System.out.println("key is :"+entry.getKey()+" "+ "Value is :"+entry.getValue());
			}
		}
	}
	
// Find position of a string in another string
	
	public int findPos(String str1,String str2){
		
		System.out.println(str2.length());
		if (str1==null && str1.length()<str2.length())
			return -1;
		int j,k;
		for (int i=0;i<str1.length()-str2.length();i++){
			j=0;
			k=i;
			System.out.println("Value of k is :"+k);
			while (str1.charAt(k)==str2.charAt(j) && j<str2.length()){
				System.out.println("J is:"+j);
				k++;
				j++;
				}
				if (j==str2.length()-1)
					return i+1;
			}
		return -1;
	}
	
	//wild card matching * and ?
	
	public boolean wildCardMatching(String str1,String str2){
		
		char[] s=str1.toCharArray();
		char[] p=str2.toCharArray();
		if (str1==null ||str2==null)
			return false;
		int startIndex=0;
		boolean isFirst=true;
		//removing multiple ** from pattern string
		for (int i=0;i<p.length;i++){
			if (p[i]=='*'){
				if(isFirst){
					p[startIndex++]=p[i];
					isFirst=false;
				}
			}
			else{
				p[startIndex++]=p[i];
				isFirst=true;
			}
			}
		
		boolean[][] T=new boolean[str1.length()+1][startIndex+1];
			
			if(p[0]=='*' && startIndex>0){
				T[0][1]=true;
			}
			
			T[0][0]=true;
			for (int i=1;i<T.length;i++){
				for (int j=1;j<T[0].length;j++){
					if( p[j-1]=='?' || s[i-1]==p[j-1]){
						T[i][j]=T[i-1][j-1];
					}
					else if (p[j-1]=='*'){
						T[i][j]=(T[i-1][j]||T[i][j-1]);
					}
					else{
						T[i][j]=false;
					}
				}
			}
		return T[s.length][startIndex];
	}
	
	//Regular Express matching using . and *
	public boolean regexMatching(String str1,String str2){
		char[] s=str1.toCharArray();
		char[] p=str2.toCharArray();
		
		boolean[][] T=new boolean[s.length+1][p.length+1];
		T[0][0]=true;
		
		for (int i=1;i<T[0].length;i++){
			if(p[i-1]=='*')
				T[0][i]=T[0][i-2];
		}
		
		for (int i=1;i<T.length;i++){
			for (int j=1;j<T[0].length;j++){
				if(p[j-1]=='.'|| s[i-1]==p[j-1])
					T[i][j]=T[i-1][j-1];
				else if(p[j-1]=='*'){
					T[i][j]=T[i][j-2];
					if(p[j-2]=='.'||s[i-1]==p[j-2])
						T[i][j]=T[i][j]||T[i-1][j];
				}
				else 
					T[i][j]=false;
			}
		}
		return T[s.length][p.length];
	}
	
	public boolean equals(Object obj){
		if (this == obj)
			return true;
		if(obj == null && this.getClass()!=obj.getClass())
			return false;
		return this.equals(obj);
	}
	public int hashcode(){
		int result=17;
		result=31*result+((this!=null)?this.hashcode():0);
		return result;
	}

//-------------------------------------------------------------------------------
//Z String Algorithm for pattern matching

public void ZString(String str1,String str2){

	char[] text=str1.toCharArray();
	char[] pattern=str2.toCharArray();
	char[] newString= new char[text.length+pattern.length+1];
	int i=0;
	for (char c:pattern){
		newString[i]=c;
		i++;
	}
	newString[i++]='$';
	for (char c:text){
		newString[i]=c;
		i++;
	}
	ArrayList<Integer> result=new ArrayList<Integer>();
	int Z[] =calculateZ(newString);
	
	for (int j=0;j<Z.length;j++){
		if (pattern.length==Z[j]){
			result.add(i);
		}
	}
	System.out.println("Arraylist is:"+result);
	for (Integer k:result){
		System.out.println(k);
	}
}

public int[] calculateZ(char[] input){
	int[] Z=new int[input.length];
	int left=0;
	int right=0;
	
	for (int k=1;k<input.length;k++){
		if(k>right){
			left=right=k;
			if(right<input.length && input[right]==input[right-left])
				right++;
			Z[k]=right-left;
			right--;
		}
		
		else {
			int k1=k-left;
			if (Z[k1]<right-k+1)
				Z[k]=Z[k1];
			else{
				left=k;
				while(right<input.length && input[right] == input[right - left]){
					right++;
				}
				 Z[k] = right - left;
                 right--;
			}
		}
	}
	for(int j:Z)
	System.out.print(j+" ");
	return Z;
}

//Find all strings that match specific pattern in a dictionary


}
