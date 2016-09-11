package org.aman.trie;

import java.util.ArrayList;
import java.util.Arrays;

public class StringMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<String> dict =new ArrayList<String>( Arrays.asList("abb", "abc", "xyz", "xyy" ));
		Functions f1=new Functions();
		f1.matchPattern(dict, "foo");
		
		String str = "engineers rock";
	    String pattern = "gsr";
	    System.out.println(f1.matchPattern(str, pattern));
	    String str1 = "1abc23";
	    f1.sumNumberinString(str1);
	  //  f1.anagramSubstringSearch("afdgzyxksldfm","xyiz");
	    f1.anagramSubstringSearch("BACDGABCDA", "ABCD");
	   // f1.lexicographicPermutations("CABD");
	 //  Arrays.sort(str1.toCharArray());
	   //System.out.println(str1);
	   
	   String str4="forgeeksskeegfor";
	   f1.longestPallindromicSubstring(str4);
	}

}
