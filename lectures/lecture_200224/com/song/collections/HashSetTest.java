package com.song.collections;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetTest {

	public static void main(String[] args) {

		HashSet<String> hs = new HashSet<String>();
		
		hs.add("t1");
		hs.add("t2");
		hs.add("t3");
		
		// 권장
		for (String string : hs) {
			
			System.out.println(string);
		}
		
		// 비권장
		Iterator iter = hs.iterator();
		
		while(iter.hasNext()) {
			
			System.out.println(iter.next());
		}
		
		System.out.println(hs.size());
	}

}
