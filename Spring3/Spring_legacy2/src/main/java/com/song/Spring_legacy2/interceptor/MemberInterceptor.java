package com.song.Spring_legacy2.interceptor;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.song.Spring_legacy2.member.MemberVO;

@Component
public class MemberInterceptor extends HandlerInterceptorAdapter{
	
	// 진입 전
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub

		boolean check = false;
		MemberVO memberVO = (MemberVO)request.getSession().getAttribute("member");
		if(memberVO != null) {
			check = true;
			System.out.println("로그인 상태");
		} else {
			
			System.out.println("비 로그인 상태");
			//response.sendRedirect("../member/memberLogin");
			request.setAttribute("result", "로그인 해주세요");
			request.setAttribute("url", "./memberLogin");
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/result.jsp");
			view.forward(request, response);
		}
		
		return true;
	}
}