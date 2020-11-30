package com.tia.task.repositories;

import org.springframework.data.repository.CrudRepository;

import com.tia.task.models.Task;

public interface TaskRepository extends CrudRepository<Task, Long> {

}
