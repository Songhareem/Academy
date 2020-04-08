package com.song.point;

import java.io.IOException;
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
		
		// Foword(true), redirect(false) 선택
		boolean check = true;
		
		// url 변수
		String url = "";
		
		switch(pathInfo) {
		case "/pointList":
			System.out.println("pointList");
			break;
		case "/pointAdd":
			System.out.println("pointAdd");
			break;
		case "/pointMod":
			System.out.println("pointMod");
			break;
		case "/pointSelect":
			System.out.println("pointSelect");
			break;
		case "/pointDel":
			System.out.println("pointDel");
			break;
		default :
			System.out.println("point default pathInfo : " + pathInfo);
			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
