package com.in28minutes.springboot.web.springbootfirstwebapplication.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.in28minutes.springboot.web.springbootfirstwebapplication.model.Todo;

@Service
public class TodoService {
	
	@Autowired
	LoginService loginService;
	
	private static List<Todo> allToDos = new ArrayList<Todo>();
	
	static {
		allToDos.add(new Todo("Learn Java", 1L,"admin",new Date(),false));
		allToDos.add(new Todo("Learn Spring Boot", 2L,"dv",new Date(),false));
		allToDos.add(new Todo("Learn Data Structure", 3L,"admin",new Date(),false));
	}
	
	public List<Todo> getAllTodos() {
		String name = getLoggedInUserName();
		return allToDos.stream().filter( todo -> name.equals(todo.getUser())).collect(Collectors.toList());
	}

	private String getLoggedInUserName() {
		return loginService.getLoggedInUser();
	}
	
	public void saveTodo(String description) {
		String name = getLoggedInUserName();
		Todo todo = new Todo(description, getNextTodoId(), name, new Date(), false);
		allToDos.add(todo);
	}
	
	public void deleteTodo(Long id) {
		allToDos.removeIf(todo -> id == todo.getId());
	}
	
	private Long getNextTodoId () {
		return allToDos.stream().count()+1;
	}
	
	public Todo getDefaultTodo() {
		String name = getLoggedInUserName();
		return new Todo("", 0L, name, new Date(), false);
	}
	
	public Todo getTodoById(Long id) {
		return allToDos.stream().filter( todo -> id == todo.getId()).findFirst().orElse(null);
	}
	
	public void updateTodo(Todo todo) {
		Todo oldTodo = getTodoById(todo.getId());
		deleteTodo(todo.getId());
		todo.setDone(oldTodo.getDone());
		//todo.setTargetDate(oldTodo.getTargetDate());
		todo.setUser(oldTodo.getUser());
		allToDos.add(todo);
	}

}
