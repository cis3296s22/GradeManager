package com.grademanager.demo.controller;

import com.google.common.base.Optional;
import com.grademanager.demo.model.Exam;
import com.grademanager.demo.repository.ExamRepository;
import com.grademanager.demo.service.ExamService;

import org.springframework.beans.factory.annotation.Autowired;
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

    // POSTS
    @PostMapping
    public void createNewExam(@RequestBody Exam exam){
        examService.createExam(exam);
    }

    @PostMapping
    public void updateExam(@RequestBody Exam exam, @PathVariable Integer grade){
        examService.updateExam(exam);
    }

    // GET
    @GetMapping
    public Exam getExam(String name){
        Optional<Exam> optionalExam = examService.getExam(name);
        if(!optionalExam.isPresent()){
            String err = String.format("The exam %s was not found", name);
            System.out.println(err);
        }
        return optionalExam.get();
    }

    // DELETE
    @DeleteMapping("{name}")
    public void deleteExam(@PathVariable String name){
        examService.deleteExam(name);
    }
}
