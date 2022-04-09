package com.grademanager.demo.controller;
import java.util.Optional;
import com.grademanager.demo.model.Quiz;
import com.grademanager.demo.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;

    @PostMapping("/createQuiz/{name}")
    public void createNewQuiz(@RequestBody Quiz quiz){
        quizService.createQuiz(quiz);
    }

    @PostMapping("/updateQuiz/{name}")
    public void updateQuiz(@RequestBody Quiz quiz, @PathVariable Integer grade){
        quizService.updateQuiz(quiz);
    }

    @GetMapping("{name}")
    public Quiz getQuiz(String name){
        Optional<Quiz> optionalQuiz = quizService.getQuiz(name);
        if(!optionalQuiz.isPresent()){
            String err = String.format("The quiz %s was not found", name);
            System.out.println(err);
        }
        return optionalQuiz.get();
    }

    @DeleteMapping("{name}")
    public void deleteQuiz(@PathVariable String name){
        quizService.deleteQuiz(name);
    }
}
