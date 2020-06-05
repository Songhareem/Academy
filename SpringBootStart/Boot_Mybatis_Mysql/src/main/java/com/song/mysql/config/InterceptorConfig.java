package com.song.mysql.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.song.mysql.interceptor.AdminInterceptor;
import com.song.mysql.interceptor.CustomInterceptor;
import com.song.mysql.interceptor.MemberCheckInterceptor;
import com.song.mysql.interceptor.NoticeInterceptor;
import com.song.mysql.interceptor.QnaInterceptor;
import com.song.mysql.interceptor.WriterCheckInterceptor;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

	// WebMvcConfigurer spring boot 2.0 이후 나옴
	// WebMvcConfigurerAdapter랑 같음(deprecated 됨)
	
	@Autowired
	private CustomInterceptor customInterceptor;
	@Autowired
	private NoticeInterceptor noticeInterceptor;
	@Autowired
	private QnaInterceptor qnaInterceptor;
	
	@Autowired
	private AdminInterceptor adminInterceptor;
	@Autowired
	private MemberCheckInterceptor memberCheckInterceptor;
	@Autowired
	private WriterCheckInterceptor writerCheckInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		// Method Chaining
		// 적용할 interceptor 등록 
		//registry.addInterceptor(customInterceptor)
		// Interceptor을 사용할 URL 등록
		//.addPathPatterns("/notice/*")
		//.addPathPatterns("/member/*")
		// interceptor 에서 제외할 URL 등록
		//.excludePathPatterns("/notice/noticeList");
		
		// admin interceptor
//		registry.addInterceptor(adminInterceptor)
//		.addPathPatterns("/notice/*")
//		.excludePathPatterns("/notice/noticeSelect")
//		.excludePathPatterns("/notice/noticeList");
//		
//		registry.addInterceptor(memberCheckInterceptor)
//		.addPathPatterns("/qna/*")
//		.excludePathPatterns("/qna/qnaList");
//		
//		registry.addInterceptor(writerCheckInterceptor)
//		.addPathPatterns("/qna/qnaUpdate")
//		.addPathPatterns("/qna/qnaDelete");
//		
//		// notice interceptor
//		registry.addInterceptor(noticeInterceptor)
//		.addPathPatterns("/notice/*")
//		.excludePathPatterns("/notice/noticeSelect")
//		.excludePathPatterns("/notice/noticeList");
	}
}
