package com.in28minutes.springboot.restapp.springbootrestfulapp;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import net.bytebuddy.asm.Advice.Local;

@SpringBootApplication
@ComponentScan("com.in28minutes.springboot.restapp")
public class SpringBootRestfulAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestfulAppApplication.class, args);
	}
	
	/*
	 * @Bean public LocaleResolver localeResolver() { SessionLocaleResolver local =
	 * new SessionLocaleResolver(); local.setDefaultLocale(Locale.US); return local;
	 * }
	 * 
	 * new approach is below to use AcceptHeaderLocaleResolver...so we don't need to fetch header in controller method
	 */
	
	@Bean
	public LocaleResolver localeResolver()
	{
		AcceptHeaderLocaleResolver localeResolver = new AcceptHeaderLocaleResolver();
		localeResolver.setDefaultLocale(Locale.US);
		return localeResolver;
	}
	
	
	/*
	 * Alternative is to configure it in application.properties
	 * spring.messages.basename = message
	 * 
	 * @Bean public ResourceBundleMessageSource messageSource() {
	 * ResourceBundleMessageSource source = new ResourceBundleMessageSource();
	 * source.setBasename("message"); return source; }
	 */
	/*
	 * @Bean public ResourceBundleMessageSource messageSource() {
	 * ResourceBundleMessageSource source = new ResourceBundleMessageSource();
	 * source.setBasename("message"); return source; }
	 */

}
