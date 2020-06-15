package com.song.s1.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class CustomInterceptor extends HandlerInterceptorAdapter{

	// Controller 진입전
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		System.out.println("컨트롤러 진입 전");
		
		// return true : 컨트롤러 진입
		// return flase : 컨트롤러 진입불가 - redirect로 다른 경로로 진입(servlet forword 또는 redirect)
		return true; //super.preHandle(request, response, handler);
	}
	
	// Controller 진입후
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		//super.postHandle(request, response, handler, modelAndView);
	
		System.out.println("Contorller 진입 후");
	}
	
	// jsp 렌더링 후
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		//super.afterCompletion(request, response, handler, ex);
	
		System.out.println("jsp 랜더링 후");
	}
	
	// 비동기 요청시, post / after 수행하지 않고 이 function 으로 옴
	@Override
	public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//super.afterConcurrentHandlingStarted(request, response, handler);
	}
}
