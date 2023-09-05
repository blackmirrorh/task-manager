package com.metaphorce.taskmanager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TaskRepository extends JpaRepository<Task, Integer>{
	
	@Query("update tasks t set t.description = :description, t.status = :status WHERE t.id = :id")
	void save(@Param("id")int id, @Param("description")String description, @Param("status")String status);
}
