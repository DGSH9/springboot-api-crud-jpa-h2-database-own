package com.dgsh.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dgsh.springboot.model.Tutorial;

@Repository
public interface TutorialRepository extends JpaRepository<Tutorial, Long>{

	
	
	
}
