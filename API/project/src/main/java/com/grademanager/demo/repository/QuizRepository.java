package com.grademanager.demo.repository;

import java.util.Optional;

import com.grademanager.demo.model.Quiz;

public interface QuizRepository {

    public void save(Quiz quiz);

    public Optional<Quiz> deleteByName(String name);

    public Iterable<Quiz> findAll();

    
    
}
