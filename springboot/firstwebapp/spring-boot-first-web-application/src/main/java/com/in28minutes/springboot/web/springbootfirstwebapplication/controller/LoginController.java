package com.in28minutes.springboot.web.springbootfirstwebapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.in28minutes.springboot.web.springbootfirstwebapplication.service.LoginService;

@Controller
public class LoginController {

	@Autowired
	LoginService loginService;
	
	@RequestMapping(value = "/")
	public String welcomeMessage( ModelMap model) {
		model.put("username", loginService.getLoggedInUser());
		return "welcome";
	}
	
	//@RequestMapping("/login")
	//@ResponseBody
	public String login() {
		return "login";
	}
}
