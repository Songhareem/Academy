package com.song.Spring_legacy2.transfer;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Card {
	
	@AfterReturning("execution(* com.song.Spring_legacy2.transfer.Transfer.*())")
	public void cardAfter() {
		System.out.println("---------------------");
		System.out.println("카드 결제");
	}
	
	@Around("execution(* com.song.Spring_legacy2.transfer.Transfer.*(*,..))")
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
