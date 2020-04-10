package com.song.notice;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/NoticeController")
public class NoticeController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private NoticeService noticeService;
	private ArrayList<NoticeDTO> ndtoList;
	private NoticeDTO noticeDTO;
	
    public NoticeController() {
        super();
        noticeService = new NoticeService();
        ndtoList = new ArrayList<NoticeDTO>();
        noticeDTO = new NoticeDTO();
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
		
		// msg 변수
		String msg = "";
		
		// result 변수
		int result = 0;
		
		try {
			switch(pathInfo) {
			
			case "/noticeAdd":
				System.out.println("noticeAdd");
				
				if(method.equals("POST")) {
					noticeDTO.setSubtitle(request.getParameter("subtitle"));
					noticeDTO.setContent(request.getParameter("content"));
					
					result = noticeService.noticeAdd(noticeDTO);
					if(result > 0) {
						System.out.println("noticeAdd success");
						responseMode = "redirect";
						url = "./noticeList";
					} else {
						msg = "공지 추가 실패";
						request.setAttribute("result", msg);
						request.setAttribute("url", "./noticeList");
						url = "../WEB-INF/views/common/result.jsp";
					}
					
				} else {
					url="../WEB-INF/views/notice/noticeAdd.jsp";
				}
				break;
				
			case "/noticeList":
				System.out.println("noticeList");
				
				ndtoList.clear();
				ndtoList = noticeService.noticeList();
				
				request.setAttribute("list", ndtoList);
				url="../WEB-INF/views/notice/noticeList.jsp";
				break;
				
			case "/noticeSelect":
				System.out.println("noticeSelect");

				noticeDTO.setId(Integer.parseInt((String)request.getParameter("id")));

				//update로 views++ 기능 추가
				
				noticeDTO = noticeService.noticeSelect(noticeDTO);
				noticeDTO.setViews(noticeDTO.getViews() + 1);
				result = noticeService.noticeMod(noticeDTO);
				if(result == 0) {
					// 로그를 남기나?
					System.out.println("views count err");
				}
				
				if(noticeDTO != null) {
					request.setAttribute("ndto", noticeDTO);
					url="../WEB-INF/views/notice/noticeSelect.jsp";
				} else {
					msg = "조회글이 없습니다!";
					request.setAttribute("result", msg);
					request.setAttribute("url", "./noticeList");
					url = "../WEB-INF/views/common/result.jsp";
				}
				break;
				
			case "/noticeMod":
				System.out.println("noticeMod");
				
				if(method.equals("POST")) {
					noticeDTO.setId(Integer.parseInt((String)request.getParameter("id")));
					noticeDTO.setSubtitle(request.getParameter("subtitle"));
					noticeDTO.setName(request.getParameter("name"));	
					noticeDTO.setContent(request.getParameter("content"));
					noticeDTO.setViews(Integer.parseInt((String)request.getParameter("views")));
					
					result = noticeService.noticeMod(noticeDTO);
					if(result > 0) {
						responseMode = "redirect";
						url = "./noticeList";
					} else {
						msg = "공지 수정 실패";
						request.setAttribute("result", msg);
						request.setAttribute("url", "./noticeList");
						url = "../WEB-INF/views/common/result.jsp";
					}
					
				} else {
					// 값을 읽어서 줘야함
					noticeDTO.setId(Integer.parseInt(request.getParameter("id")));
					noticeDTO = noticeService.noticeSelect(noticeDTO);
					request.setAttribute("ndto", noticeDTO);
					
					url="../WEB-INF/views/notice/noticeMod.jsp";
				}
				break;
				
			case "/noticeDel":
				System.out.println("noticeDel");
				
				noticeDTO.setId(Integer.parseInt(request.getParameter("id")));
				
				result = noticeService.noticeDel(noticeDTO);
				if(result > 0) {	
					responseMode = "redirect";
					url = "./noticeList";
				}else {
					msg = "공지 삭제 실패";
					request.setAttribute("result", msg);
					request.setAttribute("url", "./noticeList");
					url = "../WEB-INF/views/common/result.jsp";
				}
				
				break;
			
			default :
				System.out.println("pathInfo : "+pathInfo);
				break;
			}
			
			if(responseMode.equals("forward")) {
				RequestDispatcher view = request.getRequestDispatcher(url);
				view.forward(request, response);
			} else {
				response.sendRedirect(url);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
