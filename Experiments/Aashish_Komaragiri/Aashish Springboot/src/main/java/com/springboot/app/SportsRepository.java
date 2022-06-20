package com.springboot.app;

import org.springframework.data.repository.CrudRepository;

//interface created for postgresql repository
public interface SportsRepository extends CrudRepository<Player, Integer>{

}
