package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Tutorial;

@Repository
public interface TutorialRepository extends JpaRepository <Tutorial,Integer> {

}
