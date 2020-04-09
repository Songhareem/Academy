package com.song.point;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/PointController")
public class PointController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    private PointService pointService;
    private ArrayList<PointDTO> pdtoList;
    private PointDTO pointDTO;
    
    public PointController() {
        super();
        pointService = new PointService();
        pdtoList = new ArrayList<PointDTO>();
        pointDTO = new PointDTO();
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
		
		try {
			switch(pathInfo) {
			
			case "/pointList":
				
				pdtoList.clear();
				pdtoList = pointService.pointList();
	
				request.setAttribute("list", pdtoList);
				url = "../WEB-INF/views/point/pointList.jsp";
				break;
			
			case "/pointSelect":
				System.out.println("pointSelect");
				pointDTO.setNum(Integer.parseInt(request.getParameter("num")));
				
				pointDTO = pointService.pointSelect(pointDTO);
				request.setAttribute("pdto", pointDTO);
				
				url = "../WEB-INF/views/point/pointSelect.jsp";
				break;
	
			case "/pointAdd":
				if(method.equals("POST")) {
					
					System.out.println("pointAdd Post");
					
					pointDTO.setName(request.getParameter("name"));
					pointDTO.setNum(Integer.parseInt(request.getParameter("num")));
					pointDTO.setKor(Integer.parseInt(request.getParameter("kor")));
					pointDTO.setEng(Integer.parseInt(request.getParameter("eng")));
					pointDTO.setMath(Integer.parseInt(request.getParameter("math")));
					
					int result = pointService.pointAdd(pointDTO);
					String msg = "점수 등록 실패";
					//responseMode="redirect";
					if(result > 0) {
						System.out.println("pointAdd success");
						//url = "./pointList";
						msg = "점수 등록 성공";
					} /*
						 * else { System.out.println("pointAdd fail"); //url = "./pointAdd"; }
						 */
					
					request.setAttribute("result", msg);
					request.setAttribute("url", "./pointList");
					url = "../WEB-INF/views/common/result.jsp";
					
				} else {
					System.out.println("pointAdd Get");
					url = "../WEB-INF/views/point/pointAdd.jsp";
				}
				break;
			
			case "/pointMod":
				System.out.println("pointMod");
				if(method.equals("POST")) {
					// 값을 재세팅 (NULL CHECK? => front에서 하는게 맞음)
					pointDTO.setName(request.getParameter("name"));
					pointDTO.setNum(Integer.parseInt(request.getParameter("num")));
					pointDTO.setKor(Integer.parseInt(request.getParameter("kor")));
					pointDTO.setEng(Integer.parseInt(request.getParameter("eng")));
					pointDTO.setMath(Integer.parseInt(request.getParameter("math")));
					
					int result = pointService.pointMod(pointDTO);
					/*
					 * responseMode = "redirect"; if(result > 0) { url = "./pointList"; } else { url
					 * = "./pointMod?num="+pointDTO.getNum(); }
					 */
					
					String msg = "점수 수정 실패";
					if(result > 0) {
						msg = "점수 수정 성공";
						request.setAttribute("url", "./pointSelect?num="+pointDTO.getNum());
					} else {
						request.setAttribute("url", "./pointList");
					}
					
					request.setAttribute("result", msg);
					url = "../WEB-INF/views/common/result.jsp";
					
				} else {
					// 값을 읽어서 줘야함
					pointDTO.setNum(Integer.parseInt(request.getParameter("num")));
					pointDTO = pointService.pointSelect(pointDTO);
					request.setAttribute("pdto", pointDTO);
					
					url = "../WEB-INF/views/point/pointMod.jsp";
				}
				break;
			
			case "/pointDel":
				System.out.println("pointDel");
				pointDTO.setNum(Integer.parseInt(request.getParameter("num")));
				int result = pointService.pointDel(pointDTO);
				if(result > 0) {
					System.out.println("pointDel success");
					url = "./pointList";
					responseMode = "redirect";
				}else {
					System.out.println("pointDel Fail");
				}
				
				break;
			
			default :
				System.out.println("point default pathInfo : " + pathInfo);
				break;
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	
		if(responseMode.equals("forward")) {
			RequestDispatcher view = request.getRequestDispatcher(url);
			view.forward(request, response);
		} else if(responseMode.equals("redirect")){
			response.sendRedirect(url);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
}
