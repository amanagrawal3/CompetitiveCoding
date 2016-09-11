package org.aman.general;

public class StringFuctions {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str="Aman is great";
		String str2="Aman is great";
		String str3=new String("Aman is great");
		String str4=new String();
		str4=str2;
		System.out.println(str2==str4);
		System.out.println(str==str3);
		System.out.println(str.equals(str3));
		System.out.println(str==str2);
		System.out.println(str.equals(str2));
				System.out.println(str.hashCode()+" "+ str2.hashCode()+" "+str3.hashCode()+" "+str4.hashCode() );
				System.out.println(str.substring(2).hashCode());
				System.out.println(str.substring(0, 1));
				System.out.println(str.startsWith("an"));
				System.out.println(System.identityHashCode(str3)+" "+System.identityHashCode(str)+" "+System.identityHashCode(str4));

	}

}
