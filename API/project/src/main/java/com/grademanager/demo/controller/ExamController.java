package com.grademanager.demo.controller;
import java.util.Optional;
import com.grademanager.demo.model.Exam;
import com.grademanager.demo.service.ExamService;
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
@RequestMapping("api/v1/exam")
public class ExamController {
    
    @Autowired
    private ExamService examService;

    /**
     * Handles the GET REQUESTS for the Exam Objects
     * @param id - the unique ID associated to the specific exam object in the database 
     * @return a HTTP response with the status code, exam object, and header
     */
    @GetMapping("{id}")
    public ResponseEntity<Optional<Exam>> getExam(@PathVariable Long id){
        return ResponseEntity.ok(examService.getExam(id));
    }

    /**
     * Handles the POST REQUEST for the Exam Objects
     * @param assignment - an assignment object to create a new Exam object
     * @return a HTTP response with the status code, Exam object, and header
     */
    @PostMapping("/create")
    public ResponseEntity<Exam> createNewExam(@RequestBody Exam exam){
        return ResponseEntity.ok(examService.createExam(exam));
    }

    /**
     * Handles the POST REQUEST for the Exam Objects
     * @param assignment - an Exam object to update the existing object
     * @param id - the unique ID associated to the existing Exam object
     * @return a HTTP response with the status code, Exam object, and header
     */
    @PostMapping("{id}")
    public ResponseEntity<Exam> updateExam(@RequestBody Exam exam, @PathVariable Long id){
        return ResponseEntity.ok(examService.updateExam(exam, id));
    }

    /**
     * Handles the DELETE REQUEST for the Exam Objects
     * @param id - the unique ID associated to the existing Exam object
     */
    @DeleteMapping("{id}")
    public void deleteExam(@PathVariable Long id){
        examService.deleteExam(id);
    }
}
