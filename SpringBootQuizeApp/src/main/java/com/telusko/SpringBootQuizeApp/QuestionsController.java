package com.telusko.SpringBootQuizeApp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/quize")
public class QuestionsController {
	
	@Autowired
	QuestionServices services;
	
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Questions>>getAllQuestions(){
		return services.getAllQuestions();
	}
	
	@GetMapping("/category/{category}")
	public ResponseEntity<List<Questions>>getByCategory(@PathVariable String category){
		return services.findByCategory(category);
	}
	
	@PostMapping("/add")
	public ResponseEntity<String> add(@RequestBody Questions question) {
		return services.add(question);
	}

	

}
