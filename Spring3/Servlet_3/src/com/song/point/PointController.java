package com.song.point;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/PointController")
public class PointController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PointController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 한글 깨짐 방지 -> 클래스화 시키자 util에
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		// pathInfo
		String pathInfo = request.getPathInfo();
		
		// Method
		String method = request.getMethod();
		
		// forward, redirect 선택
		String responseMode = "forward";
		
		// url 변수
		String url = "";
		
		switch(pathInfo) {
		
		case "/pointList":
			System.out.println("pointList");
			url = "../WEB-INF/views/point/pointList.jsp";
			break;
		
		case "/pointAdd":
			System.out.println("pointAdd");
			if(method.equals("POST")) {
				
			} else {
				url = "../WEB-INF/views/point/pointAdd.jsp";
			}
			break;
		
		case "/pointMod":
			System.out.println("pointMod");
			if(method.equals("POST")) {
				
			} else {
				url = "../WEB-INF/views/point/pointMod.jsp";
			}
			break;
		
		case "/pointSelect":
			System.out.println("pointSelect");
			url = "../WEB-INF/views/point/pointSelect.jsp";
			break;
		
		case "/pointDel":
			System.out.println("pointDel");
			break;
		
		default :
			System.out.println("point default pathInfo : " + pathInfo);
			break;
		}
	
		if(responseMode.equals("forward")) {
			RequestDispatcher view = request.getRequestDispatcher(url);
			view.forward(request, response);
		} else {
			response.sendRedirect(url);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
}
