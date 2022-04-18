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
public class QuizService  {

    @Autowired
    QuizRepository quizRepository;

    public void createQuiz(Quiz quiz) {
        quizRepository.save(quiz);
    }

    public void updateQuiz(Quiz quiz) {
        quizRepository.save(quiz);
    }

    public Optional<Quiz> getQuiz(Long id) {
       return quizRepository.findById(id);
    }

    public List<Quiz> getAllQuizzes(){
        List<Quiz> quizzes = new ArrayList<>();
        quizRepository.findAll().forEach(quizzes::add);
        return quizzes;
    }

    public void deleteQuiz(Long id) {
        quizRepository.deleteById(id);
    }

    public Quiz updateQuiz(Quiz quiz, Long id){
        if(quizRepository.findById(id).isPresent()){
            Quiz oldQuiz = quizRepository.findById(id).get();

            Integer grade = (quiz.getGrade() != null) ? quiz.getGrade() : oldQuiz.getGrade();
            quiz.setGrade(grade);

            String name = (quiz.getName() != null) ? quiz.getName() : oldQuiz.getName();
            quiz.setName(name);

            quiz.setId(id);
        }

        return quizRepository.save(quiz);
    }
    
}
