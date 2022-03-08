package com.moon.tvshows.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.moon.tvshows.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	//JPA METHODs!!! advanced for filtering
	Optional<User> findByEmail(String email);
}
