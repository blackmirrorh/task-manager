package com.metaphorce.taskmanager.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Optional;

import com.metaphorce.taskmanager.repositories.Task;
import com.metaphorce.taskmanager.repositories.TaskRepository;

public class TaskServicesTest {
	
	@Mock
	TaskRepository repository = mock(TaskRepository.class);
	
	@InjectMocks
	TaskServices services = new TaskServices();
	
	@BeforeEach
	public void setup() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	public void testAddNewTaskInvalidStatus() {
		Task task = new Task();
		task.setId(1);
		task.setDescription("A new task");
		task.setStatus("nothing");
		
		Assertions.assertFalse(services.addNewTask(task));
	}
	
	@Test
	public void testAddNewTaskValidStatus() {
		Task task = new Task();
		task.setId(1);
		task.setDescription("A new task");
		task.setStatus("pendiente");
		
		when(repository.save(task)).thenReturn(null);
		
		Assertions.assertTrue(services.addNewTask(task));
	}
	
	@Test
	public void testUpdateTaskIdNotPresent() {		
		when(repository.findById(anyInt())).thenReturn(Optional.empty());
		
		Assertions.assertFalse(services.updateTask(1, new Task()));
	}
	
	@Test
	public void testUpdateTaskIdPresent() {		
		when(repository.findById(anyInt())).thenReturn(Optional.empty());
		
		Assertions.assertFalse(services.updateTask(1, new Task()));
	}

}
