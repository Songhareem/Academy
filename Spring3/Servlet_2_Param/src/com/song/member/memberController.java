package com.song.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class memberController
 */
@WebServlet("/memberController")
public class memberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public memberController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//String uri = request.getRequestURI();
		//String command = uri.substring(uri.lastIndexOf("/")+1);
		
		String pathInfo = request.getPathInfo();
		//System.out.println(pathInfo);
		switch(pathInfo) {
		case "/memberJoin":
			System.out.println("Join");
			String method = request.getMethod();
			if(method.equals("POST")) {
				System.out.println("member join");
				
				String id	 	= request.getParameter("id");
				String pw 		= request.getParameter("pw");
				String name		= request.getParameter("name");
				String age		= request.getParameter("age");
				String email	= request.getParameter("email");
				String phone	= request.getParameter("phone");
				
				System.out.println(id);
				System.out.println(pw);
				System.out.println(name);
				System.out.println(age);
				System.out.println(email);
				System.out.println(phone);
				
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
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
