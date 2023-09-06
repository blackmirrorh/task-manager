package com.metaphorce.taskmanager.services;

import java.util.Optional;

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
	
	public Optional<Task> getNoteById(int id) {
		return repository.findById(id); 
	}
	
	public boolean addNewTask(Task task) {
		if(validateStatus(task.getStatus())) {
			repository.save(task);
			return true;
		}
		return false;
	}
	
	public boolean updateTask(int id, Task task) {
		Optional<Task> optionalEntity = repository.findById(id);
		if(optionalEntity.isPresent()) {
			Task oldTask = optionalEntity.get();
			if(validateStatus(task.getStatus())) {
				oldTask.setDescription(task.getDescription());
				oldTask.setStatus(task.getStatus());
				repository.save(oldTask);
				return true;
			}			
		}
		return false;
	}
	
	public boolean deleteTask(int id) {
		Optional<Task> optionalEntity = repository.findById(id);
		if(optionalEntity.isPresent()) {
			repository.deleteById(id);
			return true;
		}
		return false;
	}
	
	private boolean validateStatus(String status) {
		return (status.equals("pendiente") || status.equals("en progreso") || status.equals("completada")) ? true : false;
	}
}
