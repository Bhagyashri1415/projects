package com.telusko.SpringBootQuizeApp;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface QuestionRepo extends JpaRepository<Questions, Integer>{
	public List<Questions> findByCategory(String Category);
    @org.springframework.data.jpa.repository.Query(value="SELECT * FROM questions q WHERE q.category= :category ORDER BY RAND() LIMIT :numQ",nativeQuery=true)
	public List<Questions> findRandomQueBycategory(String category, int numQ);
}
