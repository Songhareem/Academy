package com.song.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RandomController
 */
@WebServlet("/RandomController")
public class RandomController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RandomController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Method 형식은 GET 방식");
	
		String method = request.getMethod();			// Get / Post ...
		StringBuffer sb = request.getRequestURL();		// URL
		String uri = request.getRequestURI();			// URL에서 IP PORT부분 제외
		String ctxPath = request.getContextPath();		// 프로젝트명
		String servletPath = request.getServletPath();	// 서블릿명
		
		System.out.println("Method : "+method);
		System.out.println("URL : "+ sb.toString());
		System.out.println("URI : "+ uri);
		System.out.println("Path : "+ ctxPath);
		System.out.println("pathInfo" + servletPath);
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Method 형식은 POST 방식");
	}

}
