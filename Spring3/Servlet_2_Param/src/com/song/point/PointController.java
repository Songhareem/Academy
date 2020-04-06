package com.song.point;

import java.io.IOException;
import java.util.Enumeration;
import java.util.StringTokenizer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PointController
 */
@WebServlet("/PointController")
public class PointController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PointController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uri = request.getRequestURI();		
		String tmp[] = uri.split("/");
		String command = tmp[tmp.length - 1];
		
		PointDTO pdto = new PointDTO();
		
		if(command.equals("pointAdd")) {
			System.out.println("Add");
			// Get일때 / Post일때
			String method = request.getMethod();
			if(method.equals("POST")) {
				
				System.out.println("pointAdd post");
				
				Enumeration<String> names = request.getParameterNames();
				while(names.hasMoreElements()) {
					System.out.println(names.nextElement());
				}
				
				
				// name이 단일일때 받는 것 getParameter("name명");
				pdto.setName(request.getParameter("name"));
				pdto.setNum(request.getParameter("num"));
				pdto.setKor(Integer.parseInt(request.getParameter("kor")));
				pdto.setEng(Integer.parseInt(request.getParameter("eng")));
				pdto.setMath(Integer.parseInt(request.getParameter("math")));
				pdto.setTotal();
				pdto.setAvg();
				
				// name이 여러개일 때, getParameterValues("name명");
				String[] checks = request.getParameterValues("check");
				for (String string : checks) {
					System.out.println("check : " + string);
				}
				
			} else {
				RequestDispatcher view = request.getRequestDispatcher("../WEB-INF/views/point/pointAdd.jsp");
				view.forward(request, response);				
			}
		} else if(command.equals("pointSelect")) {
			System.out.println("Select");
		} else if(command.equals("pointMod")) {
			System.out.println("Mod");
		} else if(command.equals("pointDel")) {
			System.out.println("Del");
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
