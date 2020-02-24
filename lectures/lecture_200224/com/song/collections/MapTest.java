package com.song.collections;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapTest {

	public static void main(String[] args) {

		HashMap<String, String> hm = new HashMap<String, String>();
		
		// 있으면, 덮어씌움
		hm.put("hello", "world");
		hm.put("inner", "peace");
		
		// keySet = 키를 set으로 바꿔줌
		Set<String> keys = hm.keySet();
		for(String s : keys) {
			System.out.print(s+" ");
			System.out.println(hm.get(s));
		}
		
		System.out.println();
		hm.remove("hello");

		Iterator<String> iter = hm.keySet().iterator();
		while(iter.hasNext()) {
			String key = iter.next(); 
			System.out.print(key+" ");
			System.out.println(hm.get(key));
		}
		
	}
}
