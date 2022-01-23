package com.learning;

import java.util.StringTokenizer;

public class StringTokenizerExample {

	public static void main(String[] args) {
		String str = "my,name: is saipriyadarshini";
		StringTokenizer st=new StringTokenizer(str);
		System.out.println(st.countTokens());
		while (st.hasMoreTokens()) {  
	         System.out.println(st.nextToken());  
	     }  
	}

}
