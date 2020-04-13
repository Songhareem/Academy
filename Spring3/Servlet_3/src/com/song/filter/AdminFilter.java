package com.song.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.song.member.MemberDTO;

@WebFilter("/AdminFilter")
public class AdminFilter implements Filter {

    public AdminFilter() {
       
    }

	public void destroy() {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpSession session = ((HttpServletRequest)request).getSession();
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		
		String pathInfo = ((HttpServletRequest)request).getPathInfo();
		// 경로에 따라 아래로 보내거나 그냥 다음 필터로 보내거나 가능
		
		if(memberDTO != null) {
		
			String id = memberDTO.getId();
			if(id.equals("admin")) {
				// admin
				System.out.println("Admin");
				chain.doFilter(request, response);
			} else {
				// 일반 member
				System.out.println("member");
				/*
				 * request.setAttribute("result", "권한이 필요합니다"); request.setAttribute("url",
				 * "../"); RequestDispatcher view =
				 * request.getRequestDispatcher("../common/result.jsp"); view.forward(request,
				 * response);
				 */
				((HttpServletResponse)response).sendRedirect("../member/memberLogin");
			}
		} else {
			// 로그인이 안된 상태
			((HttpServletResponse)response).sendRedirect("../member/memberLogin");
		}
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
