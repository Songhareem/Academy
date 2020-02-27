package com.song.subjectEx;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class MenuClientView {
	
	public void view(ArrayList<MenuVO> mvoList) {
		
		System.out.println("MenuName\tMenuPrice");
		HashMap<String, Integer> menuMap = new HashMap<String, Integer >();
		HashSet<String> keyCheck = new HashSet<String>(); 
		
		// 데이터 넣는곳 
		for(MenuVO mvo : mvoList) {
			System.out.println(mvo.getMenuName() + "\t\t" + mvo.getMenuPrice());
		
			if(!menuMap.containsKey(mvo.getMenuName())) {
				System.out.println(mvo.getMenuName() + mvo.getMenuPrice());
				menuMap.put(mvo.getMenuName(), 1);
				continue;
			}
			
			int numTotal = menuMap.get(mvo.getMenuName()) + 1;
			menuMap.put(mvo.getMenuName(), numTotal);
		}
		
		// 데이터 출력
		System.out.println("========= 영수증  ========");
		System.out.println("음식\t\t수량\t\t가격");
		for(MenuVO mvo : mvoList) {
			
			if(keyCheck.contains(mvo.getMenuName()))
				continue;
			
			String menu = mvo.getMenuName();
			int price = mvo.getMenuPrice();
			int numOfMenu = menuMap.get(menu);
			keyCheck.add(menu);
			System.out.printf("%s\t\t%,d\t\t%,d\n",menu,numOfMenu,price*numOfMenu);
		}
		System.out.println("=======================");
	}
}
