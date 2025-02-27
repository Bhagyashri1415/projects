package com.telusko.SpringBootQuizeApp;

import java.util.List;

import org.hibernate.annotations.ManyToAny;
import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Component
@Entity
public class Quiz {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int primaryKey;
	private String title;
	@ManyToMany(fetch = FetchType.EAGER)
	private List<Questions> questions;
	
	public Quiz() {
		
	}
	
	public Quiz(int primaryKey, String title, List<Questions> questions) {
		super();
		this.primaryKey = primaryKey;
		this.title = title;
		this.questions = questions;
	}
	public int getPrimaryKey() {
		return primaryKey;
	}
	public void setPrimaryKey(int primaryKey) {
		this.primaryKey = primaryKey;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<Questions> getQuestions() {
		return questions;
	}
	public void setQuestions(List<Questions> questions) {
		this.questions = questions;
	}
	@Override
	public String toString() {
		return "Quiz [primaryKey=" + primaryKey + ", title=" + title + ", questions=" + questions + "]";
	}
	
	
	
	

}
