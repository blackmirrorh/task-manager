package com.metaphorce.taskmanager.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	public Optional<Task> getById(@PathVariable int id) {
		return service.getNoteById(id);
	}
	
	@PostMapping("/new-task")
	public ResponseEntity<String> addNewTask(@RequestBody Task task) {
		return (service.addNewTask(task))
				? ResponseEntity.ok().body("")
				: ResponseEntity.badRequest().body("Estatus no válido");
	}
	
	@PutMapping("/update-task/{id}")
	public ResponseEntity<String> updateTask(@PathVariable int id, @RequestBody Task task) {
		return (service.updateTask(id, task))
				? ResponseEntity.ok().body("")
				: ResponseEntity.badRequest().body("Tarea no existe");
	}
	
	@DeleteMapping("/remove-task/{id}")
	public ResponseEntity<String> deleteTask(@PathVariable int id) {
		return (service.deleteTask(id))
				? ResponseEntity.ok().body("")
				: ResponseEntity.badRequest().body("Tarea no existe");
	}
}
