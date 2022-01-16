package com.learning;

import java.util.HashMap;
import java.util.Map;

public class HashMapGetOrDefault {

	public static void main(String[] args) {
	  Map<Integer,String> map=new HashMap<>();
	  map.put(1, "hello");
	  String val=map.getOrDefault(2, "bye");
	  
	  map.forEach((k,v)->
		  System.out.println(k+" "+v));
	
	System.out.println("value is "+val);
	}

}
