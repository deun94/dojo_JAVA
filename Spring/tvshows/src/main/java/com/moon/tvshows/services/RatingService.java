package com.moon.tvshows.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moon.tvshows.models.Rating;

import com.moon.tvshows.repositories.RatingRepository;

@Service
public class RatingService {

	@Autowired
	private RatingRepository ratingRepo;
	
	public Rating createRate(Rating rating) {
		//black belt checking to see if the title is present

		return this.ratingRepo.save(rating);
	}
		
}
