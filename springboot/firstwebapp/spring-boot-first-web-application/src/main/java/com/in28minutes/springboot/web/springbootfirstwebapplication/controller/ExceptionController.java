package com.in28minutes.springboot.web.springbootfirstwebapplication.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller("error")
public class ExceptionController {
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handleExcetion(HttpServletRequest req, Exception exc) {
		ModelAndView model = new ModelAndView();
		model.addObject("error", exc.getStackTrace());
		model.addObject("url", req.getRequestURL());
		model.setViewName("error");
		return model;
	}
}
