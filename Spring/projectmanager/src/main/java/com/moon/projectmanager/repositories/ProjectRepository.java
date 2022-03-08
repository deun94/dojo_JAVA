package com.moon.projectmanager.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.moon.projectmanager.models.Project;
import com.moon.projectmanager.models.User;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {
	
//	//for finding projects with uploader
//	List<Project> findByUploader(User uploader);
	//don't need this just do if statement to equal the logged in user id
}
