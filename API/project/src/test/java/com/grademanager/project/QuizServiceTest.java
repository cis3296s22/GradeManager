package com.grademanager.project;
import java.util.Optional;

import com.grademanager.demo.model.Quiz;
import com.grademanager.demo.repository.QuizRepository;
import com.grademanager.demo.service.QuizService;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

@RunWith(MockitoJUnitRunner.class)
public class QuizServiceTest {

    @Mock
    private static QuizRepository quizRepository;

    @InjectMocks
    private static QuizService quizService = new QuizService();

    private static Quiz quiz1;

    @Test
    public void getQuizByIdTest() {
        quiz1 = new Quiz();
        quiz1.setId(Long.valueOf(1));
        quiz1.setName("Quiz 1");
        quiz1.setGrade(34);

        Optional<Quiz> quizOptional = Optional.of(quiz1);

        Mockito.when(quizRepository.findById(Long.valueOf(1))).thenReturn(quizOptional);

        Quiz retrievedQuiz = quizService.getQuiz(Long.valueOf(1));
        Assert.assertEquals(quiz1, retrievedQuiz);
    
    }
   @Test
   public void getAllQuizzes(){
        quiz1 = new Quiz();
        quiz1.setId(Long.valueOf(1));
        quiz1.setName("Quiz 1");
        quiz1.setGrade(34);

        Quiz quiz2 = new Quiz();
        quiz2.setId(Long.valueOf(2));
        quiz2.setName("Quiz 2");
        quiz2.setGrade(45);

        Quiz quiz3 = new Quiz();
        quiz3.setId(Long.valueOf(3));
        quiz3.setName("Quiz 3");
        quiz3.setGrade(56);


         List<Quiz> quizzes = new ArrayList<>(Arrays.asList(
            quiz1, quiz2, quiz3
        ));
        Mockito.when(quizRepository.findAll()).thenReturn(quizzes);

        List<Quiz>retrievedQuizzes = quizService.getAllQuizzes();
        Assert.assertEquals(quizzes, retrievedQuizzes);       
   }

   @Test
   public void createNewQuizTest(){
        quiz1 = new Quiz();
        quiz1.setId(Long.valueOf(1));
        quiz1.setName("Quiz 1");
        quiz1.setGrade(34);

        Mockito.when(quizRepository.save(quiz1))
        .thenReturn(quiz1);

        Quiz retrievedQuiz = quizService.createQuiz(quiz1);
        Assert.assertEquals(quiz1, retrievedQuiz);

   }

//    deletequiz doesn't return anything
// updatequiz uses the repository twice?





    
}
