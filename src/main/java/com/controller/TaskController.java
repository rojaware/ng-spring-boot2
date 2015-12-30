package com.controller;

import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.model.Task;
import com.repository.TaskRepository;

@RestController
@RequestMapping("/tasks")
public class TaskController {

  @Autowired
  private TaskRepository repo;
  
  @RequestMapping(method = RequestMethod.GET)
  public Iterable<Task> findTasks() {
	  Iterable<Task> list = repo.findAll();
	  System.out.println("test :: "+list);
    return list;
  }
  
  @RequestMapping(method = RequestMethod.POST)
  public Task addTask(@RequestBody Task task) {
    task.setId(null);
    return repo.save(task);
  }
  
  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
  public Task updateTask(@RequestBody Task updatedTask, @PathVariable Integer id) {
    updatedTask.setId(id);
    return repo.save(updatedTask);
  }
  
  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public void deleteItem(@PathVariable Integer id) {
    repo.delete(id);
  }
}
