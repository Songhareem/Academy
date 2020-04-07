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

@WebServlet("/PointController")
public class PointController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	PointService pointService;
	PointDTO pointDTO;
    
    public PointController() {
        super();
        pointDTO = new PointDTO();
        pointService = new PointService();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uri = request.getRequestURI();		
		String tmp[] = uri.split("/");
		String command = tmp[tmp.length - 1];
		
		try {
			if(command.equals("pointAdd")) {
				
				// Get일때 / Post일때
				String method = request.getMethod();
				if(method.equals("POST")) {
					
					System.out.println("pointAdd post");
					
					/*
					 * Enumeration<String> names = request.getParameterNames();
					 * while(names.hasMoreElements()) { System.out.println(names.nextElement()); }
					 *
					 * // name이 여러개일 때, getParameterValues("name명");
					 *
					 * String[] checks = request.getParameterValues("check"); for (String string :
					 * checks) { System.out.println("check : " + string); }
					 */
					
					// name이 단일일때 받는 것 getParameter("name명");
					pointDTO.setName(request.getParameter("name"));
					pointDTO.setNum(Integer.parseInt(request.getParameter("num")));
					pointDTO.setKor(Integer.parseInt(request.getParameter("kor")));
					pointDTO.setEng(Integer.parseInt(request.getParameter("eng")));
					pointDTO.setMath(Integer.parseInt(request.getParameter("math")));
					
					int result = pointService.pointAdd(pointDTO);
					
					String url = "../WEB-INF/views/result/result2.jsp";
					System.out.println("result : " + result);
					String msg = "fail";
					if(result > 0) {
						url = "../WEB-INF/views/result/result.jsp";
						msg = "success";
					}
					
					request.setAttribute("result", msg);
					
					RequestDispatcher view = request.getRequestDispatcher(url);
					view.forward(request, response);
					
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
		} catch(Exception e) {
			e.printStackTrace();
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
