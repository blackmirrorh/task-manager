package com.metaphorce.taskmanager.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.metaphorce.taskmanager.repositories.Task;
import com.metaphorce.taskmanager.repositories.TaskRepository;

public class TestTaskServices {
	
	TaskRepository repository = Mockito.mock(TaskRepository.class);
	TaskServices services = new TaskServices();
	
	@Test
	public void testAddNewTaskInvalidStatus() {
		Task task = new Task();
		task.setId(1);
		task.setDescription("A new task");
		task.setStatus("nothing");
		
		Assertions.assertFalse(services.addNewTask(task));
	}

}
