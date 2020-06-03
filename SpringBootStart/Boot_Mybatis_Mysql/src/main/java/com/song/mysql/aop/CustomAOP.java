package com.song.mysql.aop;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class CustomAOP {

	// notice폴더 아래 모든 서비스 아래 모든 메서드
	// . 매개변수 하나, .. 모든 매개변수 갯수
	@Before("execution(* com.song.mysql.board.notice.*Service.*(..))")
	public void before() throws Exception {
		System.out.println("Before Method");
	}
	
	@AfterReturning("execution(* com.song.mysql.board.notice.*Service.get*(..))")
	public void afterReturning() throws Exception {
		System.out.println("After Returning Method");
	}
	
	@AfterThrowing("execution(* com.song.mysql.board.notice.*Service.get*(..))")
	public void afterThrowing() throws Exception {
		System.out.println("After Throwing Method");
	}
	
	// afterReturning + afterThrowing
	@After("execution(* com.song.mysql.board.notice.*Service.get*(..))")
	public void after() throws Exception {
		System.out.println("After Method");
	}
	
	// 위의 모든것을 합친것, return : Object / param : proceedingJoinPoint / throw Throwable
	@Around("execution(* com.song.mysql.board.notice.*Service.get*(..))")
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
			
		System.out.println("before");
		
		Object obj = joinPoint.proceed();
		
		System.out.println("after");
		
		return obj;
	}
}
