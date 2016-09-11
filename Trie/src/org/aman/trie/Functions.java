package org.aman.trie;
import java.util.*;
public class Functions {
	
	//Find all strings that match specific pattern in a dictionary
	//http://www.geeksforgeeks.org/find-all-strings-that-match-specific-pattern-in-a-dictionary/
	
	public void matchPattern(List<String> list,String pattern){
		
		if(pattern==null)
			return;
		
		String res=encodeString(pattern);
		for (String s:list){
			if(pattern.length()==s.length() && res.equals(encodeString(s))){
				System.out.println("String "+s+" matches with the pattern "+pattern);
			}
			else
				System.out.println("String "+s+" does now matches with the pattern "+pattern);
		}
	}
	
	public String encodeString(String str){
		HashMap<Character,Integer> hmap=new HashMap<Character,Integer>();
		String res="";
		int i=0;
		for (int j=0;j<str.length();j++){
			Character ch =str.charAt(j);
			if (hmap.get(ch)==null)
				hmap.put(ch, i++);
			res=res+hmap.get(ch);
		}
		return res;
	}
	
	
/**----------------------------------------------------------------------------------**/
	//Check if string follows order of characters defined by a pattern or not
	//http://www.geeksforgeeks.org/check-string-follows-order-characters-defined-pattern-not/
	
	
	public boolean matchPattern(String str,String pattern){
		
		if (pattern.length()>str.length())
			return false;
		for (int i=0;i<pattern.length();i++){
			Character c1=pattern.charAt(i);
			Character c2=pattern.charAt(i+1);
			
			int lastc1=str.lastIndexOf(c1);
			int firstc2=str.indexOf(c2);
			if(lastc1==-1 || firstc2==-1|| lastc1>firstc2)
				return false;
		}
		return true;
	}
	
	/**-------------------------------------------------------------------------------------**/
	//http://www.geeksforgeeks.org/calculate-sum-of-all-numbers-present-in-a-string/
	
	public void sumNumberinString(String str){
		
		if (str==null)
			 return;
		int res=0;
		int i=0;
		while (i<str.length()){
			int j=i;
			String r="";
			if (Character.isDigit(str.charAt(i))){
				while (j<str.length() && Character.isDigit(str.charAt(j)) ){
					//System.out.println(str.charAt(j));
					r=r+str.charAt(j);
					j++;
					//System.out.println(r);
				}
				//System.out.println(r.getClass().getName());
				Integer s=Integer.valueOf(r);
				//System.out.println(s);
				res=res+s;
				i=j;
			}
			
			else 
				i++;
			
			
		}
		System.out.println("Sum is :"+res);		
	}
	
	/**-----------------------------------------------------------------------------------------------**/
	//http://www.geeksforgeeks.org/find-longest-palindrome-formed-by-removing-or-shuffling-chars-from-string/
	
	public void longestPalindrome(String str){
		
		HashMap<Character,Integer> hmap=new HashMap<Character,Integer>();
		for (char c:str.toCharArray()){
			if (hmap.containsKey(c))
				hmap.put(c, hmap.get(c)+1 );
			else 
				hmap.put(c, 1);		
		}
		
		int start,mid,end;
	}
	
	
	/**------------------------------------------------------------------------------------------------------------------------
	 * http://www.geeksforgeeks.org/anagram-substring-search-search-permutations/  
	 */
	
	public void anagramSubstringSearch(String str,String pattern){
		HashMap<Character,Integer> pmap=new HashMap<Character,Integer>();
		HashMap<Character,Integer> smap=new HashMap<Character,Integer>();
		boolean result=false;
		for (int i=0;i<pattern.length();i++){
			if (pmap.containsKey(pattern.charAt(i))){
				pmap.put(pattern.charAt(i), pmap.get(pattern.charAt(i))+1);
			}
			else{
				pmap.put(pattern.charAt(i), 1);
			}
			
			if (smap.containsKey(str.charAt(i))){
				smap.put(str.charAt(i), smap.get(str.charAt(i))+1);
			}
			else{
				smap.put(str.charAt(i), 1);
			}
		}
		
		int windowStart=0;
		int windowEnd=pattern.length()-1;
		
		while (true){
			
			if (compare(smap,pmap,pattern)){
				//System.out.println(str.charAt(windowStart)+ ":"+str.charAt(windowEnd));
				System.out.println("anagram found:" + windowStart);
				result=true;
			}
			
			windowStart++;
			windowEnd++;
			
			if (windowEnd>=str.length()){
				if (!result)
					System.out.println("Not found");
				return;
			}
			
			char ch=str.charAt(windowStart-1);
			if (smap.containsKey(ch)){
				if (smap.get(ch)==1){
					smap.remove(ch);
				}
				else if (smap.get(ch)>1)
					smap.put(ch,smap.get(ch)-1);
			}
			
			
			char ch2=str.charAt(windowEnd);
			if (smap.containsKey(ch)){
					smap.put(ch2,smap.get(ch2)+1);
				}
				else{
					smap.put(ch2,1);
				}
			}
			
			
		}
			
	public boolean compare(HashMap<Character,Integer> smap,HashMap<Character,Integer> pmap,String pattern){
		
		for (int i=0;i<pattern.length();i++){
			if (smap.containsKey(pattern.charAt(i))){
				if (smap.get(pattern.charAt(i))!=pmap.get(pattern.charAt(i)))
					return false;
			}
			else 
				return false;
		}
			return true;
	}
	
	
	
	/**----------------------------------------------------------------------------------------------------------------------
	 * Given an array of strings, group anagrams together.
	 */
	
	public void groupAnagrams(String[] arr){
		HashMap<String,Integer> hmap=new HashMap<String,Integer>();
		for (int i=0;i<arr.length;i++){
			hash(arr[i],hmap);
			
		}
	}
	
	public void hash(String str,HashMap<String,Integer> hmap){
		long hash=0;
		if (!hmap.containsKey(str)){
				
		}
	}
	
	
	/**----------------------------------------------------------------------------------------------------------------------------
	 * http://www.geeksforgeeks.org/lexicographic-permutations-of-string/
	 */
	
	public void lexicographicPermutations(String str){
		if (str==null)
			return;
		
		char[] ch=str.toCharArray();
		Arrays.sort(ch);
		String str1=String.valueOf(ch);
		
		boolean isTrue=true;
		
		while(isTrue){
			
			for (int i=str1.length()-2;i>=0;i--){
				if (str1.charAt(i)<str1.charAt(i+1)){
					break;
				}
				if(i==-1)
					isTrue=false;
				
				else{
					int ceilIndex= ceilIndex(str1,i);
					swap(str1,i,ceilIndex);
				}
			}
		}
	}
	
	public int ceilIndex(String str,int i){
		int ceilIndex=i+1;
		for (int j=i;j<str.length();j++){
			if (str.charAt(j)>str.charAt(i) && str.charAt(j)<str.charAt(ceilIndex) )
				ceilIndex=i;
			
		}
		return ceilIndex;
	}
	
	public void swap(String str,int i,int j){
		char temp=str.charAt(i);
		char temp2=str.charAt(j);
		char[] ch=str.toCharArray();
		ch[i]=temp2;
		ch[j]=temp;
		str=String.valueOf(ch);
	}
	
	
	
	/**---------------------------------------------------------------------------------------------------------------------------------
	 * 
	 * http://www.geeksforgeeks.org/longest-palindromic-substring-set-2/
	 * O (n^2) solution with O(1) space
	 */
	
	public void longestPallindromicSubstring(String str){
		char[] input=str.toCharArray();
		int maxlen=0;
		int beginStart=0;
		int start,end;
		System.out.println("In function");
		for (int mid=0;mid<input.length;mid++){
			
			//Find the longest odd length palindrome with center point as i
			
			start=mid;
			 end=mid+1;
			while (start>=0 && end<input.length && input[start]==input[end])
			{
				if (end-start+1>maxlen)
				{
					beginStart=start;
					maxlen=end-start+1;		
				}
				start--;
				end++;
			}
			
			//// Find the longest even length palindrome with center point  as i-1 and i. 
			 start =mid;
			 end=mid;
			
			while (start>=0 && end<input.length && input[start]==input[end])
			{
				if (end-start+1>maxlen)
				{
					beginStart=start;
					maxlen=end-start+1;	
				}
				start--;
				end++;
			}
			
		}
		
		System.out.println("Maximum pallindromic subsequence is :" + String.valueOf(input).substring(beginStart, beginStart+maxlen)+ " length is:"+maxlen);
	}
}
