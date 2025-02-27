package com.telusko.SpringBootQuizeApp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class QuizService {
	
	@Autowired
	QuizRepo quizrepo;
	
	@Autowired
	QuestionRepo queRepo;
	

	public ResponseEntity<String> crateQuiz(String category, int numQ, String title) {
		List<Questions> quest=queRepo.findRandomQueBycategory(category,numQ);
		Quiz quiz=new Quiz();
		quiz.setTitle(title);
		quiz.setQuestions(quest);
		quizrepo.save(quiz);
		
		return new ResponseEntity<>("Success",HttpStatus.CREATED);
		
		
	}


	public ResponseEntity<List<QuestionWrapper>> getquizQuestionsById(Integer id) {
		// TODO Auto-generated method stub
		Optional<Quiz> quiz= quizrepo.findById(id);
		List<Questions> questionsFromDB=quiz.get().getQuestions();
		List<QuestionWrapper> questionForUser=new ArrayList<>();
		for(Questions q:questionsFromDB) {
			QuestionWrapper wrapper=new QuestionWrapper(q.getId(), q.getQuestionTitle(), q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4());
			questionForUser.add(wrapper);
		}
		return new ResponseEntity<>(questionForUser,HttpStatus.OK);
	}


	public ResponseEntity<Integer> calculateResult(int id, List<Response> responses) {
		Quiz quiz=quizrepo.findById(id).get();
//		System.out.println(quiz);
		List<Questions> question=quiz.getQuestions();
		int right=0;
		int i=0;
		for(Response response:responses) {
			if(response.getResponse().equals(question.get(i).getRightAnswer())) {
				right++;
			}
			i++;
		}
		return new ResponseEntity<>(right,HttpStatus.OK);
	}
	

}
