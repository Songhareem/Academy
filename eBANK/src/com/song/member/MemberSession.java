package com.song.member;

import java.util.HashMap;

public class MemberSession {

	private static HashMap<String, Object> session;
	
	static {
		session = new HashMap<String, Object>();
	}
	
	public static Object getSession(String key) {
		
		return MemberSession.session.get(key); 
	}
	
	public static void setSession(String key, Object value) {
		
		MemberSession.session.put(key, value);
	}
	
	public static void removeSession(String key) {
		
		MemberSession.session.remove(key);
	}
}
