package com.grademanager.demo.controller;
import java.util.Optional;
import com.grademanager.demo.model.Quiz;
import com.grademanager.demo.service.QuizService;

// import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @PostMapping("/createQuiz")
    public void createNewQuiz(@RequestBody Quiz quiz){
        quizService.createQuiz(quiz);
    }

    @PostMapping("{id}")
    public ResponseEntity<Quiz> updateQuiz(@RequestBody Quiz quiz, @PathVariable Long id){
        return ResponseEntity.ok(quizService.updateQuiz(quiz, id));        
    }

    @GetMapping("{id}")
    public ResponseEntity<Optional<Quiz>> getQuiz(@PathVariable Long id){
       return ResponseEntity.ok(quizService.getQuiz(id));
    }



    @DeleteMapping("{id}")
    public void deleteQuiz(@PathVariable Long id){
        quizService.deleteQuiz(id);
    }
}
