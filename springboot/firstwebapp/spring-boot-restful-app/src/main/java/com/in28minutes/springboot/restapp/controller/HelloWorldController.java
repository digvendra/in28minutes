package com.in28minutes.springboot.restapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.springboot.restapp.bean.HelloWorldBean;

@RestController
public class HelloWorldController {
	
	@GetMapping(path="/hello-world")
	public String helloWorld() {
		return "Hello World";
	}
	
	@GetMapping(path="/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hi Pushkal");
	}
	
	@GetMapping(path="/hello-world-bean/{msg}")
	public HelloWorldBean helloWorldBeanPathVariable(@PathVariable String msg) {
		return new HelloWorldBean("Hi Pushkal " + msg );
	}

}
