package com.in28minutes.springboot.web.springbootfirstwebapplication.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.in28minutes.springboot.web.springbootfirstwebapplication.model.Todo;
import com.in28minutes.springboot.web.springbootfirstwebapplication.service.TodoService;

@Controller
public class TodoController {
	
	@Autowired
	public TodoService todoService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, false));
	}
	
	@RequestMapping(value = "/all-todos.htm", method = RequestMethod.GET)
	public String getAllTodos(ModelMap model) {
		model.addAttribute("alltodos", todoService.getAllTodos());
		return "all-todos";
	}
	
	@RequestMapping(value = "/add-todo.htm", method = RequestMethod.GET)
	public String addTodos(ModelMap model) {
		model.addAttribute("todo", todoService.getDefaultTodo());
		return "save-todo";
	}
	
	@RequestMapping(value = "/save-todo.htm", method = RequestMethod.POST)
	public String saveTodo(ModelMap model,@Valid Todo todo,BindingResult valid) {
		if(valid.hasErrors()) {
			return "save-todo";
		}
		todoService.saveTodo( todo.getDescription());
		return "redirect:/all-todos.htm";
	}
	
	@RequestMapping(value = "/delete-todo.htm", method = RequestMethod.GET)
	public String deleteTodo(@RequestParam Long id) {
		todoService.deleteTodo(id);
		return "redirect:/all-todos.htm";
	}
	
	@RequestMapping(value = "/edit-todo.htm", method = RequestMethod.GET)
	public String editTodo(ModelMap model, @RequestParam Long id) {
		model.addAttribute("todo", todoService.getTodoById(id)) ;
		return "update-todo";
	}
	
	@RequestMapping(value = "/update-todo.htm", method = RequestMethod.POST)
	public String updateTodo(ModelMap model,@Valid Todo todo,BindingResult valid) {
		if(valid.hasErrors()) {
			return "update-todo";
		}
		todoService.updateTodo(todo);
		return "redirect:/all-todos.htm";
	}

	@RequestMapping("error.htm")
	public String exceptionTest() {
		throw new RuntimeException("Exception Test !!");
	}


}
