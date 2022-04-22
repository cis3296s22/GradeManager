package com.grademanager.demo.controller;
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

    /**
     * Handles the POST REQUEST for the Course Objects
     * @param assignment - an assignment object to create a new Quiz object
     * @return a HTTP response with the status code, Quiz object, and header
     */
    @PostMapping("/createQuiz")
    public Quiz createNewQuiz(@RequestBody Quiz quiz){
        return quizService.createQuiz(quiz);
    }

    /**
     * Handles the POST REQUEST for the Quiz Objects
     * @param assignment - an Quiz object to update the existing object
     * @param id - the unique ID associated to the existing Quiz object
     * @return a HTTP response with the status code, Quiz object, and header
     */
    @PostMapping("{id}")
    public ResponseEntity<Quiz> updateQuiz(@RequestBody Quiz quiz, @PathVariable Long id){
        return ResponseEntity.ok(quizService.updateQuiz(quiz, id));        
    }

    /**
     * Handles the GET REQUESTS for the Quiz Objects
     * @param id - the unique ID associated to the specific Quiz object in the database 
     * @return a HTTP response with the status code, Quiz object, and header
     */
    @GetMapping("{id}")
    public ResponseEntity<Quiz> getQuiz(@PathVariable Long id){
       return ResponseEntity.ok(quizService.getQuiz(id));
    }

    /**
     * Handles the DELETE REQUEST for the Quiz Objects
     * @param id - the unique ID associated to the existing Quiz object
     */
    @DeleteMapping("{id}")
    public void deleteQuiz(@PathVariable Long id){
        quizService.deleteQuiz(id);
    }
}
