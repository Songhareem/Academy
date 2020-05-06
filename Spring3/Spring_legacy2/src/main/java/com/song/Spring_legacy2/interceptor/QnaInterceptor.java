package com.song.Spring_legacy2.interceptor;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.song.Spring_legacy2.board.BoardVO;
import com.song.Spring_legacy2.member.MemberVO;

@Component
public class QnaInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		boolean check = false;
		
		Object obj = request.getSession().getAttribute("member");
		if(obj != null) {
			check = true;
		} else {
			request.setAttribute("result", "권한이 없음");
			request.setAttribute("url", "../");
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/result.jsp");
			view.forward(request, response);
		}
		
		return check;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
		String method = request.getMethod();
		String url = request.getServletPath();
		url=url.substring(url.lastIndexOf("/"));
		if(!method.equals("GET"))
			return;
		
		if(!url.equals("qnaUpdate"))
			return;
		
		MemberVO memberVO = (MemberVO)request.getSession().getAttribute("member");
		BoardVO boardVO = (BoardVO)modelAndView.getModel().get("vo");
		String board = (String)modelAndView.getModel().get("board");
		board = "./" + board + "List";
		
		if(memberVO != null) {
			
			if(!memberVO.getId().equals(boardVO.getWriter())) {
				modelAndView.setViewName("redirect: "+board);
			}
			
		} else {
			
			modelAndView.addObject("result", "권한이 없음");
			modelAndView.addObject("url", board);
			modelAndView.setViewName("common/result");
		}
	}
}
