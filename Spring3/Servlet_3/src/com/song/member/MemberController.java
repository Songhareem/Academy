package com.song.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/MemberController")
public class MemberController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    private MemberService 	memberService;
    private MemberDTO		memberDTO;
    private String			msg;
    private HttpSession session;
    
    public MemberController() {
        super();
        memberService = new MemberService();
        memberDTO = new MemberDTO();
        msg = "";
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		// 한글 깨짐 방지 -> 클래스화 시키자 util에
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		//getServletConfig();	// 현재 Servlet의 객체에 저장된 initParam 읽어오기
		//getServletContext(); // 전체 정보 저장객체(application, 
		
		// pathInfo
		String pathInfo = request.getPathInfo();
		
		// method
		String method = request.getMethod();
		
		// forward, redirect 선택
		String responseMode = "forward";

		// url 변수
		String url = "";
		
		try {
			switch(pathInfo) {
			
			case "/memberJoin":
				System.out.println("memberJoin");
				if(method.equals("POST")) {
					
					memberDTO.setId(request.getParameter("id"));
					memberDTO.setPw(request.getParameter("pw"));
					memberDTO.setName(request.getParameter("name"));
					memberDTO.setAge(Integer.parseInt(request.getParameter("age")));
					memberDTO.setEmail(request.getParameter("email"));
					memberDTO.setPhone(request.getParameter("phone"));
					
					int result = memberService.memberJoin(memberDTO);
					if(result > 0) {
						msg = "회원가입 성공";
						request.setAttribute("url", "../");
					} else {
						msg = "회원가입 실패";
						request.setAttribute("url", "./memberJoin");
					}
					
					request.setAttribute("result", msg);
					url = "../WEB-INF/views/common/result.jsp";
					
				} else {
					url = "../WEB-INF/views/member/memberJoin.jsp";
				}
				break;
			
			case "/memberLogin":
				System.out.println("memberLogin");
				if(method.equals("POST")) {
					System.out.println("save");
					System.out.println(request.getParameter("id"));
					System.out.println(request.getParameter("pw"));
					memberDTO.setId(request.getParameter("id"));
					memberDTO.setPw(request.getParameter("pw"));
					System.out.println("save done");
					
					memberDTO = memberService.memberLogin(memberDTO);
					if(memberDTO != null) {
						System.out.println("로그인 성공");
						HttpSession session = request.getSession();
						session.setAttribute("member", memberDTO);
						responseMode = "redirect";
						url = "../";
					} else {
						request.setAttribute("result", "로그인 실패");
						request.setAttribute("url", "./memberLogin");
						url = "../WEB-INF/views/common/result.jsp";
					}
				} else {
					url = "../WEB-INF/views/member/memberLogin.jsp";
				}
				break;
				
			case "/memberUpdate":
				System.out.println("memberUpdate");
				if(method.equals("POST")) {
					memberDTO.setId(request.getParameter("id"));
					memberDTO.setPw(request.getParameter("pw"));
					memberDTO.setName(request.getParameter("name"));
					memberDTO.setAge(Integer.parseInt(request.getParameter("age")));
					memberDTO.setEmail(request.getParameter("email"));
					memberDTO.setPhone(request.getParameter("phone"));
					
					int result = memberService.memberUpdate(memberDTO);
					if(result > 0) {
						// redirect mypage
						responseMode = "redirect";
						session = request.getSession();
						session.setAttribute("member", memberDTO);
						url = "./memberPage";
						System.out.println("Update Success");
					} else {
						System.out.println("Update Fail");
					}
				} else {
					url = "../WEB-INF/views/member/memberUpdate.jsp";
				}
				break;
			
			case "/memberPage":
				System.out.println("memberPage");
				
				url="../WEB-INF/views/member/memberPage.jsp";
				break;
				
			case "/memberDelete":
				System.out.println("memberDelete");
				
				session = request.getSession();
				memberDTO = (MemberDTO)session.getAttribute("member");
				int result = memberService.memberDelete(memberDTO);
				msg = "회원 탈퇴 실패";
				if(result > 0) {
					msg = "회원 탈퇴 성공";
					session.invalidate();
				}
				request.setAttribute("result", msg);
				request.setAttribute("url", "../");
				url = "../WEB-INF/views/common/result.jsp";
				break;
			
			case "/memberLogout":
				session = request.getSession();
				//session.removeAttribute("member");
				session.invalidate();
				responseMode = "redirect";
				url="../";
				break;
				
			default :
				System.out.println(pathInfo);
				break;
			}
			
			if(responseMode.equals("forward")) {
				RequestDispatcher view = request.getRequestDispatcher(url);
				view.forward(request, response);
			} else {
				response.sendRedirect(url);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
