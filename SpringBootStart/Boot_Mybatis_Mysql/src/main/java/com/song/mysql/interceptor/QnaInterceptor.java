package com.song.mysql.interceptor;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.song.mysql.board.BoardVO;
import com.song.mysql.board.notice.NoticeVO;
import com.song.mysql.board.qna.QnaRepository;
import com.song.mysql.member.MemberVO;

@Component
public class QnaInterceptor extends HandlerInterceptorAdapter{

	@Autowired 
	private QnaRepository qnaRepository;
	
	// Controller 진입전
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
			
		System.out.println("컨트롤러 진입 전");
		
		// pathInfo
		String pullReqUrl = request.getRequestURI();
		String[] pathInfo = pullReqUrl.split("/");
		String path = pathInfo[2];
		System.out.println(path);
		
		HttpSession session = request.getSession();
		
		MemberVO memberVO = (MemberVO)session.getAttribute("member");
		if(memberVO == null) {
			
			response.sendRedirect("../");
			return false;
		} 
		
		// delete의 경우 get 요청 가면 delete 되므로 여기에서 막아야함
		if(path.equals("qnaDelete")) {
			
			String num = request.getParameter("num");
			System.out.println("num : "+num);
			
			BoardVO boardVO = new BoardVO();
			boardVO.setNum(Integer.parseInt(num));
			boardVO = qnaRepository.getSelectOne(boardVO);
			String writer = boardVO.getWriter();
			String id = memberVO.getId();
			
			if(!(writer.equals(id))) {
				
				System.out.println("save");
				
				response.sendRedirect("../");
			}
			return false;
		}
		
		// select, write, reply 회원들만 접근
		return true;
	}
	
	// Controller 진입후
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		//super.postHandle(request, response, handler, modelAndView);
	
		System.out.println("Contorller 진입 후");
		
		HttpSession session = request.getSession();
		
		// select, write, reply 회원만 접근
		// update 작성자만 가능하게
		MemberVO memberVO = (MemberVO)session.getAttribute("member");
		if(memberVO == null) {
			
			modelAndView.addObject("result", "로그인이 필요합니다");
			modelAndView.addObject("url", "../member/memberLogin");
			modelAndView.setViewName("common/result");
		}
		
		
	}
}
