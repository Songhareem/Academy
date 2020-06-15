package com.song.s1.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.song.s1.interceptor.CustomInterceptor;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

	// WebMvcConfigurer spring boot 2.0 이후 나옴
	// WebMvcConfigurerAdapter랑 같음(deprecated 됨)
	
	@Autowired
	private CustomInterceptor customInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
				
		// admin interceptor
		registry.addInterceptor(customInterceptor)
		.addPathPatterns("/notice/*")
		.excludePathPatterns("/notice/noticeSelect")
		.excludePathPatterns("/notice/noticeList");

	}
}
