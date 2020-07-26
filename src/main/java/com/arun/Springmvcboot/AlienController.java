package com.arun.Springmvcboot;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.arun.Springmvcboot.model.Alien;

//REST api

@RestController
public class AlienController {

	
	public AlienController() {
		// TODO Auto-generated constructor stub
	}
	
	
	@Autowired
	AlienRepo repo;
	
	
	
	@GetMapping("aliens")
	public List<Alien> getAliens() {
		List<Alien> aliens = repo.findAll();
		System.out.println(aliens);
		return aliens;
	}
	
	@GetMapping("alien/{aid}")
	public Alien getAlien(@PathVariable("aid") int aid) {
		Alien alien = repo.findById(aid).orElse(new Alien(0,""));
		return alien;
	}
	
	@PostMapping(path= "alien", consumes= {"application/json"})
	public Alien addAlien(@RequestBody Alien alien ) {
		repo.save(alien);
		return alien;
	}
}
