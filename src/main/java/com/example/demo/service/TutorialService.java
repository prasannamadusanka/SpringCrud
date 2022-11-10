package com.example.demo.service;
import java.util.List;
import com.example.demo.model.Tutorial;


import com.example.demo.model.Tutorial;

public interface TutorialService {
	public List<Tutorial> getTutorials();
	public String deleteTutorials(long id);
	public Tutorial addTutorial(Tutorial tutorial);
}

