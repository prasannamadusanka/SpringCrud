package com.example.demo.service;
import java.util.List;
import com.example.demo.model.Tutorial;


import com.example.demo.model.Tutorial;

public interface TutorialService {
	public List<Tutorial> getTutorials();
	public String deleteTutorials(int id);
	public Tutorial addTutorial(Tutorial tutorial);
	public Tutorial findById(int id);
//	public Tutorial updateTutorial(int id , Tutorial tutorial);
}

