package com.moon.dojosninjas.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.moon.dojosninjas.models.Dojo;
import com.moon.dojosninjas.models.Ninja;
import com.moon.dojosninjas.repositories.DojoRepository;
import com.moon.dojosninjas.repositories.NinjaRepository;

//need to annotate
//service is the methods
@Service
public class AppService {
	
	private final DojoRepository dojoRepo;
	private final NinjaRepository ninjaRepo;
	//initialize
		//source- generate constructor using field
	public AppService(DojoRepository dojoRepo, NinjaRepository ninjaRepo) {
		
		this.dojoRepo = dojoRepo;
		this.ninjaRepo = ninjaRepo;
	}
	
	//==============create methods
	
	public Dojo createDojo(Dojo d) {
		return this.dojoRepo.save(d);
	}
	//=====================GET ALL DOJO==========
		//since you need to specify to which dojo you want to add
	public List<Dojo> getAllDojo(){
		return (List<Dojo>)this.dojoRepo.findAll();
	}
	
	public Ninja createNinja(Ninja n) {
		return this.ninjaRepo.save(n);
	}
	
	//show one dojo and ninjas attached to ti
	public Dojo getOneDojo(Long id) {
		return this.dojoRepo.findById(id).orElse(null);
	}
}
