package com.in28minutes.springboot.restapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.springboot.restapp.bean.User;
import com.in28minutes.springboot.restapp.dao.UserDaoService;

@RestController
public class UserController {

	@Autowired
	private UserDaoService userService;
	
	@GetMapping(path = "/users")
	public List<User> getAllUsers() {
		return userService.findAll();
	}
	
	@GetMapping(path = "/users/{userId}")
	public User getUser(@PathVariable Integer userId) {
		return userService.findOne(userId);
	}
	
	@PostMapping(path = "/users")
	public void createUser(@RequestBody User user) {
		userService.save(user);
	}
}
