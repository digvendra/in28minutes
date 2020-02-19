package com.in28minutes.springboot.restapp.springbootrestfulapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.in28minutes.springboot.restapp")
public class SpringBootRestfulAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestfulAppApplication.class, args);
	}

}
