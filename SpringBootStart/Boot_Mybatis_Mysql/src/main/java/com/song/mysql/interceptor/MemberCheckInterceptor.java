package com.song.mysql.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.song.mysql.member.MemberVO;

@Component
public class MemberCheckInterceptor extends HandlerInterceptorAdapter{

	// Controller 진입전
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		boolean check = false;
		
		MemberVO memberVO = (MemberVO)request.getSession().getAttribute("member");
		if(memberVO != null) {
			check = true;
		} else {
			response.sendRedirect("../messageResult?result=로그인이필요합니다&url=../");
		}
		
		return check;
	}
}

