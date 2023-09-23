package com.in28minutes.rest.webservices.restfulwebservices.todo;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoJpaResource {
	
	private TodoService todoService;
	private TodoRepository repository;

	public TodoJpaResource (TodoService todoService, TodoRepository repository) {
		this.todoService = todoService;
		this.repository = repository;
	}
	
	@GetMapping("/users/{username}/todos")
	public List<Todo> retrieveTodos(@PathVariable String username) {
		return repository.findByUsername(username);
	}
	
	@GetMapping("/users/{username}/todos/{id}")
	public Todo retrieveTodo (@PathVariable String username, @PathVariable int id) {
		return repository.findById(id).get();
	}
	
	@DeleteMapping("/users/{username}/todos/{id}")
	public ResponseEntity<Void> deleteTodo(@PathVariable String username, @PathVariable int id) {
		repository.deleteById(id);
		
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/users/{username}/todos/{id}")
	public Todo updateTodo(@PathVariable String username, @PathVariable int id, @RequestBody Todo todo) {
		repository.save(todo);
		return todo;
	}
	
	@PostMapping("/users/{username}/todos") 
	public ResponseEntity<Todo> createTodo(@PathVariable String username, 
			@RequestBody Todo todo) {
		todo.setUsername(username);
		todo.setId(null);
		
		return new ResponseEntity<>(repository.save(todo), HttpStatus.CREATED);
	}
	
}
