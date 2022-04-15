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

    @GetMapping("{exam}")
    public ResponseEntity<Optional<Exam>> getExam(Long id){
        return ResponseEntity.ok(examService.getExam(id));
    }

    @PostMapping("/create")
    public ResponseEntity<Exam> createNewExam(@RequestBody Exam exam){
        return ResponseEntity.ok(examService.createExam(exam));
    }

    @PostMapping("/update")
    public void updateExam(@RequestBody Exam exam, @PathVariable Integer grade){
        examService.updateExam(exam);
    }

    @DeleteMapping("{name}")
    public void deleteExam(@PathVariable Long id){
        examService.deleteExam(id);
    }
}
