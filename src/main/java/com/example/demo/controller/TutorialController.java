package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.TutorialService;

import net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional;

import com.example.demo.Repository.TutorialRepository;
import com.example.demo.model.Tutorial;


@RestController
@RequestMapping("/api")
public class TutorialController {
	@Autowired
	TutorialService tutorialSevice;
	
	@Autowired
	TutorialRepository tutorialRepository;
	
	@GetMapping("/getall")
	public List<Tutorial> getTutorials(){
		return tutorialSevice.getTutorials();
	}
	
	@DeleteMapping("deletetutorial/{id}")
  	public void deleteTutorial(@PathVariable("id") int id ) {
    tutorialSevice.deleteTutorials(id);
  }
	
	@DeleteMapping("/tutorials")
	  public ResponseEntity<HttpStatus> deleteTutorial() {
	    try {
	      tutorialRepository.deleteAll();
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	
	@PostMapping("/add")
	public Tutorial addTutorials(@RequestBody Tutorial tutorial) {
		return tutorialSevice.addTutorial(tutorial);
		
	}
	
	@GetMapping("/findone/{id}")
	public ResponseEntity<Tutorial> findOneTutorial(@PathVariable("id") int id) {
		
		 java.util.Optional<Tutorial> tutorialData = tutorialRepository.findById(id);
		 
		 if (((java.util.Optional<Tutorial>) tutorialData).isPresent()) {
			 
		      return new ResponseEntity<>(tutorialData.get(), HttpStatus.OK);
		      
		    } else {
		    	
		      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		    }

	}
	
	@PutMapping("/tutorials/{id}")
	  public ResponseEntity<Tutorial> updateTutorial(@PathVariable("id") int id, @RequestBody Tutorial tutorial) {
	    java.util.Optional<Tutorial> tutorialData = tutorialRepository.findById(id);

	    if (tutorialData.isPresent()) {
	       Tutorial _tutorial = tutorialData.get();
	       _tutorial.setName(tutorial.getName());
	      return new ResponseEntity<>(tutorialRepository.save(_tutorial), HttpStatus.OK);
	    } else {
	    	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }


}
