package com.grademanager.demo.controller;
import com.grademanager.demo.model.*;
import com.grademanager.demo.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

// To Do: Add logger
//@Log4j2
@RestController
@RequestMapping("api/v1/Student")
public class  StudentController {

    @Autowired
    private StudentService studentService;
//DELETE
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
    }

//POSTS
    @PostMapping
    public void registerNewStudent(@RequestBody Student newStudent){
        studentService.createStudent(newStudent);
    }

    @PostMapping("/{id}")
    public void updateStudent(@RequestBody Student student, @PathVariable Long id){
        studentService.updateStudent(student);
    }

//GETS
    @GetMapping("{id}")
    public Student getStudent(Long studentId){
//        return studentService.getStudent(studentId);
        Optional<Student> optionalStudent =studentService.getStudent(studentId);
        if(!optionalStudent.isPresent()){
            String ErrMsg = String.format("The student having ID %s was not found", studentId);
            System.out.println(ErrMsg);  //log and throw exception instead?
        }
//        going to crash if student isn't returned bc exception isn't thrown above
        return optionalStudent.get();

    }


//    get student ID from email and password
//    @GetMapping("/{email}/{password}")  //probably will have to fix this
//    public Student getstudentWithEmailPassword(String email, String password){
//        return studentService.getstudentWithEmailPassword(email, password);
//    }




}
