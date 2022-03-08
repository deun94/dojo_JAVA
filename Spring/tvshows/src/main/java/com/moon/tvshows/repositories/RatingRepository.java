package com.moon.tvshows.repositories;

import org.springframework.data.repository.CrudRepository;

import com.moon.tvshows.models.Rating;

public interface RatingRepository extends CrudRepository<Rating, Long> {

}
