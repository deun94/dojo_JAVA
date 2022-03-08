package com.moon.dojosninjas.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.moon.dojosninjas.models.Ninja;

@Repository
//we need to specify model to get the right CRUD 
public interface NinjaRepository extends CrudRepository<Ninja, Long> {

}
