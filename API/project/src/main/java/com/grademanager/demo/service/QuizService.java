package com.grademanager.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import com.grademanager.demo.model.Quiz;
import com.grademanager.demo.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
//@Log4j2
public class QuizService {

    @Autowired
    QuizRepository quizRepository;

    public void createQuiz(Quiz quiz) {
        quizRepository.save(quiz);
    }

    public void updateQuiz(Quiz quiz) {
        quizRepository.save(quiz);
    }

    public Optional<Quiz> getQuiz(String name) {
        return quizRepository.deleteByName(name);
    }

    public List<Quiz> getAllQuizzes(){
        List<Quiz> quizzes = new ArrayList<>();
        quizRepository.findAll().forEach(quizzes::add);
        return quizzes;
    }

    public void deleteQuiz(String name) {
        quizRepository.deleteByName(name);
    }
    
}
