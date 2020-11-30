package com.tia.task.repositories;

import org.springframework.data.repository.CrudRepository;

import com.tia.task.models.Priority;

public interface PriorityRepository extends CrudRepository<Priority, Long> {

}
