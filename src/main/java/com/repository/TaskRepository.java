package com.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.model.Task;


public interface TaskRepository extends CrudRepository<Task, Integer> {

	Iterable<Task> findByTaskArchived(@Param("archivedfalse") int taskArchivedFalse);
	Iterable<Task> findByTaskStatus(@Param("status") String taskStatus);

}
