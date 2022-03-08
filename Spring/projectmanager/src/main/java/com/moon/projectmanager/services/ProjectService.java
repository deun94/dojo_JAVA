package com.moon.projectmanager.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moon.projectmanager.models.Project;
import com.moon.projectmanager.models.User;
import com.moon.projectmanager.repositories.ProjectRepository;
import com.moon.projectmanager.repositories.UserRepository;

@Service
public class ProjectService {
	@Autowired
	private ProjectRepository projectRepo;
	@Autowired
	private UserRepository userRepo;
	
	//show all projects
	public List<Project> findAllProjects(){
		//use the repo to query the project table for all projects
		return (List<Project>)this.projectRepo.findAll();
	}
	
	//show my projects
//	public List<Project> findMyProjects(String uploader_id){
//		return (List<Project>)this.projectRepo.findByUploader_id();
//	}
	//create new project
	public Project createNewProject(Project project) {
		return this.projectRepo.save(project);
	}
	
		
	//get one project
	public Project getOneProject(Long id) {
		return this.projectRepo.findById(id).orElse(null);
	}
		
	//update one project
	public Project updateProject(Project project) {
		return this.projectRepo.save(project);
	}
		
	//delete one project
	public void deleteProject(Long id) {
		this.projectRepo.deleteById(id);
	}
	

}
