package com.song.mysql.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.song.mysql.board.BoardVO;
import com.song.mysql.board.qna.QnaRepository;
import com.song.mysql.member.MemberVO;

@Component
public class WriterCheckInterceptor extends HandlerInterceptorAdapter{

	@Autowired
	private QnaRepository qnaRepository;
	
	// Controller 진입전
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		String method = request.getMethod();
		
		// POST 일때 패스
		if(method.equals("POST")) {
			return true;
		}
		
		// GET 일때만 검증
		MemberVO memberVO = (MemberVO)request.getSession().getAttribute("member");
		int num = Integer.parseInt(request.getParameter("num"));
		
		BoardVO boardVO = new BoardVO();
		boardVO.setNum(num);
		boardVO = qnaRepository.getSelectOne(boardVO);
		if(memberVO != null && boardVO.getWriter().equals(memberVO.getId())) {
			return true;
		} else {
			
			response.sendRedirect("../messageResult?result=권한이없습니다&url=../");
			return false;
		}
	}
}