package com.song.Spring_legacy2.transfer;

import org.aspectj.lang.ProceedingJoinPoint;

public class Card {

	public void cardAfter() {
		System.out.println("---------------------");
		System.out.println("카드 결제");
	}
	
	public Object cardCheck(ProceedingJoinPoint join) throws Throwable {
		
		System.out.println("---------------------");
		System.out.println("카드chekc in");
	
		Object[] ar = join.getArgs();
		
		for (Object object : ar) {
			
			System.out.println(object);
		}
		Object object = join.proceed();
		
		System.out.println("카드chekc out");
	
		return object;
	}
}
