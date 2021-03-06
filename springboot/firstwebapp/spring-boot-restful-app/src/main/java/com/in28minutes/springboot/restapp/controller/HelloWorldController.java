package com.in28minutes.springboot.restapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.springboot.restapp.bean.HelloWorldBean;

@RestController
public class HelloWorldController {
	
	@Autowired
	MessageSource messageSource;
	
	
	/*
	 * @GetMapping(path="/hello-world-i18n") public String
	 * helloWorldi18n(@RequestHeader(name = "Accept-Language", required = false)
	 * Locale locale) { return messageSource.getMessage("good.morning.message",
	 * null, locale); }
	 * 
	 * Don't use Accept Language in request param, instead use LocaleContextHolder
	 */
	
	@GetMapping(path="/hello-world-i18n")
	public String helloWorldi18n() {
		return messageSource.getMessage("good.morning.message", null, LocaleContextHolder.getLocale());
	}
	
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
