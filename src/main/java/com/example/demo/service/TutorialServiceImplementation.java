package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.TutorialRepository;
import com.example.demo.model.Tutorial;

@Service
public class TutorialServiceImplementation implements TutorialService {

	@Autowired
	private TutorialRepository tutorialRepository;
	
	@Override
	public List<Tutorial> getTutorials() {
		// TODO Auto-generated method stub
		return tutorialRepository.findAll();
	}

	@Override
	public String deleteTutorials(long id) {
		// TODO Auto-generated method stub
		tutorialRepository.deleteById((int) id);
		return "okay";
	}

	@Override
	public Tutorial addTutorial(Tutorial tutorial) {
		// TODO Auto-generated method stub
		return tutorialRepository.save(tutorial);
	}

}
