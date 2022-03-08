package com.moon.tvshows.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moon.tvshows.models.Show;
import com.moon.tvshows.models.User;
import com.moon.tvshows.repositories.ShowRepository;
import com.moon.tvshows.repositories.UserRepository;

@Service
public class ShowService {

		@Autowired
		private ShowRepository showRepo;
		@Autowired
		private UserRepository userRepo;
		
		//show all shows
		public List<Show> findAllShows(){
			//use the repo to query the project table for all projects
			return (List<Show>)this.showRepo.findAll();
		}
		
		//show my projects
//		public List<Project> findMyProjects(String uploader_id){
//			return (List<Project>)this.projectRepo.findByUploader_id();
//		}
		//create new show
		public Show createNewShow(Show show) {
			return this.showRepo.save(show);
		}
		
			
		//get one show
		public Show getOneShow(Long id) {
			return this.showRepo.findById(id).orElse(null);
		}
			
		//update one show
		public Show updateShow(Show show) {
			//black belt checking to see if the title is present

			return this.showRepo.save(show);
		}
			
		//delete one show
		public void deleteShow(Long id) {
			this.showRepo.deleteById(id);
		}
		
		//add a user to rate the show
		
		public void rateShow(Long userId, Long showId) {
			Show show = this.showRepo.findById(showId).orElse(null);
			User user = this.userRepo.findById(userId).orElse(null);
			
			//get yser who rated the show
			show.getUsersRated().add(user);
			//save 
			this.showRepo.save(show);
		}
		



}
