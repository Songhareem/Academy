package com.song.collections;

import java.util.ArrayList;

public class ArrayListTest1 {

	public static void main(String[] args) {

		/*
		 * // default 메모리 확보 (int)*10 ArrayList arr = new ArrayList();
		 * 
		 * // Data 추가 arr.add("frist"); arr.add(2); arr.add(3.12); arr.add(1,"second");
		 * // 끼워넣기 insert arr.set(2, 1); // 수정
		 * 
		 * arr.remove(3);
		 * 
		 * //arr.clear(); // 데이터 비우기
		 * 
		 * // 길이 size() //System.out.println(arr.size());
		 * 
		 * // 데이터 뽑기 get return 은 Object => casting 필요 String str = (String)arr.get(0);
		 */
		
		ArrayList<String> strList = new ArrayList<String>();
		strList.add("a");
		strList.add("b");
	}
}
