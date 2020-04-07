package com.song.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/memberController")
public class MemberController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    
	private MemberDTO memberDTO = null;
	private MemberService memberService = null;
	
    public MemberController() {
        super();
        memberDTO = new MemberDTO();
        memberService = new MemberService();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//String uri = request.getRequestURI();
		//String command = uri.substring(uri.lastIndexOf("/")+1);
		
		String pathInfo = request.getPathInfo();
		//System.out.println(pathInfo);
		
		try {
			switch(pathInfo) {
			case "/memberJoin":
				System.out.println("Join");
				String method = request.getMethod();
				if(method.equals("POST")) {
					System.out.println("member join");
					
					memberDTO.setId(request.getParameter("id"));
					memberDTO.setPw(request.getParameter("pw"));
					memberDTO.setName(request.getParameter("name"));
					memberDTO.setAge(Integer.parseInt(request.getParameter("age")));
					memberDTO.setEmail(request.getParameter("email"));
					memberDTO.setPhone(request.getParameter("phone"));
					
					int result = memberService.memberJoin(memberDTO);
					String msg = "fail";
					String url = "./memberJoin";
					if(result > 0) {
						msg = "success";
						url = "../WEB-INF/views/result/memberResult.jsp";
						
						request.setAttribute("result", msg);
						RequestDispatcher view = request.getRequestDispatcher(url);
						view.forward(request, response);
						
					} else {
						request.setAttribute("result", msg);
						response.sendRedirect(url);
					}
				} else {
					RequestDispatcher view = request.getRequestDispatcher("../WEB-INF/views/member/memberJoin.jsp");
					view.forward(request, response);				
				}
				break;
			case "/memberLogin":
				System.out.println("Login");
				break;
			case "/memberSelect":
				System.out.println("Select");
				break;
			case "/memberUpdate":
				System.out.println("Update");
				break;
			case "/memberDelete":
				System.out.println("Delete");
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
