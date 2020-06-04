package com.song.mysql;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomErrorController implements ErrorController {

	@RequestMapping(value = "/error")
	public ModelAndView handleError(HttpServletRequest request) {
		Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
		ModelAndView mv = new ModelAndView();
		if (status != null) {
			int statusCode = Integer.valueOf(status.toString());
			if (statusCode == HttpStatus.NOT_FOUND.value()) {
				
				mv.setViewName("error/404");
			}
			if (statusCode == HttpStatus.FORBIDDEN.value()) {
				
				mv.setViewName("error/500");
			}
		}
		return mv;
	}

	@Override
	public String getErrorPath() {
		return "/error";
	}
}

