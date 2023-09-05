package com.metaphorce.taskmanager.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.http.ResponseEntity.HeadersBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.metaphorce.taskmanager.repositories.Task;
import com.metaphorce.taskmanager.services.TaskServices;

@RestController
public class TaskController {
	
	@Autowired
	private TaskServices service;

	@GetMapping("/")
	public String greetings() {
		return "Hi from Task Manager";
	}
	
	@GetMapping("/get-all-tasks")
	public Iterable<Task> getAllTasks() {
		return service.getAllNotes();
	}
	
	@GetMapping("/get-note-by-id/{id}")
	public Task getById(@PathVariable int id) {
		return service.getNoteById(id);
	}
	
	@PostMapping("/new-task")
	public ResponseEntity<String> addNewTask(@RequestBody Task task) {
		return (service.addNewTask(task))
				? ResponseEntity.ok().body("")
				: ResponseEntity.badRequest().body("Estatus no válido");
	}
	
	@PostMapping("/update-task/{id}")
	public ResponseEntity<String> updateTask(@PathVariable int id, @RequestBody Task task) {
		return (service.addNewTask(task))
				? ResponseEntity.ok().body("")
				: ResponseEntity.badRequest().body("Estatus no válido");
	}
}
