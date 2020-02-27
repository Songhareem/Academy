package com.song.subjectEx;

public class MenuClientUtil {

	public MenuVO makeMenu(String menu) {
		
		MenuVO mvo = new MenuVO();
		
		String[] tmp = menu.split("-");
		
		mvo.setMenuName(tmp[0]);
		mvo.setMenuPrice(Integer.parseInt(tmp[1]));
		
		return mvo;
	}
}
