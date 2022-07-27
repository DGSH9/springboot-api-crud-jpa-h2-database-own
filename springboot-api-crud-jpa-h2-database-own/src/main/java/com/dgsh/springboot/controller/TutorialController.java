package com.dgsh.springboot.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dgsh.springboot.model.Tutorial;
import com.dgsh.springboot.repository.TutorialRepository;

@CrossOrigin(origins = "http://localhost:8084")

@RestController
@RequestMapping("/api")
public class TutorialController {
	
	
	@Autowired
	private TutorialRepository tutorialRepository;
	
	
	//Creating Data
	@PostMapping("/tutorials")
	public Tutorial createTutorial(@RequestBody Tutorial tutorial1){
		Tutorial tutorial2 = tutorialRepository
				.save(new Tutorial(tutorial1.getTitle(),tutorial1.getDescription(),false));
		return tutorial2;
	}
	
	
	//Display all data
	@GetMapping("/tutorials")
	public List<Tutorial> findAllTutorials(){
		List<Tutorial> tutorials = new ArrayList<>();
		tutorialRepository.findAll().forEach(tutorials::add);
		return tutorials;
		
		//return tutorialRepository.findAll();
	}
	
	
	//Display By Id
	@GetMapping("/tutorials/{id}")
	public Tutorial findByIdTutorial(@PathVariable("id") long id) {
		Tutorial tutorial = tutorialRepository.findById(id).get();
		return tutorial;
	}
	
	//Delete by Id
	@DeleteMapping("/tutorials/{id}")
	public String deleteByIdTutorial(@PathVariable("id") long id) {
		String string1="done.."; 
		
		tutorialRepository.deleteById(id);
		return string1;
	}
	
	
	//Delete All
	@DeleteMapping("/tutorials")
	public String deleteAllTutorials() {
		String s2 = "deleted success";
		tutorialRepository.deleteAll();
		return s2;
	}
	
	//Update
	@PutMapping("/tutorials/{id}")
	public Optional<Tutorial> updateTutorials(@PathVariable("id") long id,@RequestBody Tutorial tutorial){
		Optional<Tutorial> tutorialData = tutorialRepository.findById(id);
		
		Tutorial tutorial2 = tutorialData.get();
		tutorial2.setTitle("Title changed");
		tutorial2.setDescription("Description changed");
		tutorial2.setPublished(true);
		
		tutorialRepository.save(tutorial2); 
		return tutorialData;
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
