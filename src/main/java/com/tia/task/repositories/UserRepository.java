package com.tia.task.repositories;

import org.springframework.data.repository.CrudRepository;

import com.tia.task.models.User;

public interface UserRepository extends CrudRepository<User, Long> {
	User findByEmail(String email);
}
