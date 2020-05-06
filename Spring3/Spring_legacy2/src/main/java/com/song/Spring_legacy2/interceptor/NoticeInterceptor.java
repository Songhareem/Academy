package com.song.Spring_legacy2.interceptor;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.song.Spring_legacy2.member.MemberVO;

@Component
public class NoticeInterceptor extends HandlerInterceptorAdapter{
	
	// 진입 전
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub

		boolean check = false;
		MemberVO memberVO = (MemberVO)request.getSession().getAttribute("member");
		if(memberVO != null && memberVO.getId().equals("admin")) {
			check = true;
			System.out.println("관리자");
		} else {
			System.out.println("관리자 아님");
			//response.sendRedirect("../member/memberLogin");
			request.setAttribute("result", "권한이 없음");
			request.setAttribute("url", "../");
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/result.jsp");
			view.forward(request, response);
		}
		
		return true;
	}
}
