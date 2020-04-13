package com.song.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/EncodingFilter")
public class EncodingFilter implements Filter {

	private String enc;
	
    public EncodingFilter() {
        
    }

    // Filter 객체 소멸시 실행 (Filter는 서버가 꺼질 때 소멸)
	public void destroy() {
		
	}

	// 
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	
		// req 발생시 실행하는 구간
		request.setCharacterEncoding(enc);
		System.out.println("Encoding Filter In");
		
		
		// 다음 필터가 있다면 필터로 전달, 없다면 Servlet으로 전달
		chain.doFilter(request, response);
		
		// res 발생시 실행하는 구간
		response.setCharacterEncoding("UTF-8");
		System.out.println("Encoding Filter Out");
	}

	// init : 객체 생성 이후, 초기화 메서드
	public void init(FilterConfig fConfig) throws ServletException {
		enc = fConfig.getInitParameter("enc");
	}

}
