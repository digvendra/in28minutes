package com.in28minutes.springboot.web.springbootfirstwebapplication.service;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

	public String getLoggedInUser() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(principal instanceof UserDetails)
		{
			return ((UserDetails)principal).getUsername();
		}
		return principal.toString();
	}
}
