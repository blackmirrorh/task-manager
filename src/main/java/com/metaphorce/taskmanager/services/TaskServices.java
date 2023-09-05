package com.metaphorce.taskmanager.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metaphorce.taskmanager.repositories.Task;
import com.metaphorce.taskmanager.repositories.TaskRepository;

@Service
public class TaskServices {
	
	@Autowired
	private TaskRepository repository;

	public Iterable<Task> getAllNotes() {
		return repository.findAll(); 
	}
	
	public Task getNoteById(int id) {
		return repository.findById(id); 
	}
	
	public boolean addNewTask(Task task) {
		String status = task.getStatus(); 
		if(status.equals("pendiente") || status.equals("en progreso") || status.equals("completada")) {
			repository.save(task);
			return true;
		}
		return false;
	}
}
