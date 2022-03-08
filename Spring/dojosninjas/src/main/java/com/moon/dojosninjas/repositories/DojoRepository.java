package com.moon.dojosninjas.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.moon.dojosninjas.models.Dojo;

//make sure to annotate everything
@Repository
public interface DojoRepository extends CrudRepository<Dojo, Long> {

}
