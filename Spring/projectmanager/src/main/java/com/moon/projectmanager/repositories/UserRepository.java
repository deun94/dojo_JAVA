package com.moon.projectmanager.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.moon.projectmanager.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	//JPA METHODs!!! advanced for filtering
	Optional<User> findByEmail(String email);
	
}
