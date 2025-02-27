package com.telusko.SpringBootQuizeApp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class QuestionServices {
	@Autowired
	QuestionRepo repo;

	public ResponseEntity<List<Questions>> getAllQuestions(){
		try {
		return new ResponseEntity<>(repo.findAll(),HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(repo.findAll(),HttpStatus.BAD_REQUEST);
	}
	
	public ResponseEntity<List<Questions>> findByCategory(String Category){
		try {
		return new ResponseEntity<>(repo.findByCategory(Category),HttpStatus.OK);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(repo.findByCategory(Category),HttpStatus.BAD_REQUEST);
	}
	
	public ResponseEntity<String> add(Questions question) {
		repo.save(question);
		try {
		return new ResponseEntity<>("Sucess",HttpStatus.CREATED);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>("Sucess",HttpStatus.BAD_GATEWAY);
	}

}
