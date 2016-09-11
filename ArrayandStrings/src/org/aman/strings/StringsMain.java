package org.aman.strings;

public class StringsMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1="My name is Aman";
		StringsOperations str=new StringsOperations();
	//	System.out.println(str.reverseString("My Name is Aman"));
		//str.reverse("Aman".toCharArray(), 0, "Aman".length()-1);
		str.reverseInPlace(s1);
		String str1="add";
		String str2="cre";
		
		System.out.println(str.isomorphic(str1, str2));
		
		str.countFrequency(str1);
		System.out.println(s1);
		//System.out.println(str.findPos(s1, "name"));
		System.out.println(str.wildCardMatching("Aman", "?A*an"));
		System.out.println(str.regexMatching("Tusha","Tushar*a*b*"));
		str.ZString(s1, "name");
	}

}
