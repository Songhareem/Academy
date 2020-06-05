package com.song.mysql.config;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Configuration
public class MessageLocaleConfig implements WebMvcConfigurer {

	@Bean
	public LocaleResolver localeResolver() {
			
		// 세션 방식
		SessionLocaleResolver sr = new SessionLocaleResolver();
		sr.setDefaultLocale(Locale.KOREA);
		
		// 쿠키 방식
		CookieLocaleResolver cr = new CookieLocaleResolver();
		cr.setDefaultLocale(Locale.KOREA);
		cr.setCookieName("lang");
		
		return cr;
	}
	
	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor() {
		
		LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
		localeChangeInterceptor.setParamName("lang");
		return localeChangeInterceptor;
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
	
		registry.addInterceptor(localeChangeInterceptor())
		.addPathPatterns("/**");
	}
}
