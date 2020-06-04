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
import com.song.mysql.board.notice.NoticeRepository;
import com.song.mysql.board.notice.NoticeVO;
import com.song.mysql.member.MemberVO;

@Component
public class NoticeInterceptor extends HandlerInterceptorAdapter{

	@Autowired
	private NoticeRepository noticeRepository;
	
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

		MemberVO memberVO = (MemberVO) session.getAttribute("member");
		// delete는 admin만 접근 가능하게
		if (memberVO != null && path.equals("noticeDelete")) {
			
			String id = memberVO.getId();
			
			if(!(id.equals("admin"))) {
				
				System.out.println("save");
				
				response.sendRedirect("../");
			}
			return false;
		}

		return true;
	}

	// Controller 진입후
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		//super.postHandle(request, response, handler, modelAndView);
	
		System.out.println("Contorller 진입 후");
		
		// write, update, delete 관리자만 (controller 이후)
		HttpSession session = request.getSession();
		
		MemberVO memberVO = (MemberVO)session.getAttribute("member");
		if(memberVO == null || memberVO.getId().equals("admin")) {
			
			modelAndView.addObject("result","권한이 없습니다");
			modelAndView.addObject("url", "../");
			modelAndView.setViewName("common/result");
		}
	}
}
