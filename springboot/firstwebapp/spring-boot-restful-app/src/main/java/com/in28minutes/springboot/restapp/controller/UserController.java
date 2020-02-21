package com.in28minutes.springboot.restapp.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.in28minutes.springboot.restapp.bean.User;
import com.in28minutes.springboot.restapp.bean.exception.UserNotFound;
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
		User user = userService.findOne(userId);
		if(user == null) {
			throw new UserNotFound("User with Id " + userId + " Not Found");
		}
		return user;
	}
	
	@PostMapping(path = "/users")
	public ResponseEntity createUser(@RequestBody User user) {
		User newUser = userService.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newUser.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
}
