package com.moon.tvshows.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.moon.tvshows.models.Show;

@Repository
public interface ShowRepository extends CrudRepository<Show, Long> {
	//JPA Methods advanced for filtering
	Optional<Show> findByTitle(String title);

}
