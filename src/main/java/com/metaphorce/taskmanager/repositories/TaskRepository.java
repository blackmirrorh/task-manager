package com.metaphorce.taskmanager.repositories;

import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<Task, Integer>{
	
	Iterable<Task> findAll();
	
	Task findById(int id);
}
