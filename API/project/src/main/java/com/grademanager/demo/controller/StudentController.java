package com.grademanager.demo.controller;
import com.grademanager.demo.model.*;
import com.grademanager.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// To Do: Add logger
//@Log4j2
@RestController
@RequestMapping("api/v1/Student")
public class  StudentController {

    @Autowired
    private StudentService studentService;

    @DeleteMapping("/deleteStudent/{id}")
    public void deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
    }

    @PostMapping("/createStudent")
    public ResponseEntity<Student> registerNewStudent(@RequestBody Student newStudent){
        return studentService.createStudent(newStudent);
    }

    @PostMapping("{id}")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable Long id){
        return studentService.updateStudent(student, id);
    }

    @GetMapping("/getStudent")
    public ResponseEntity<Student> getStudent(Long studentId){
        return studentService.getStudent(studentId);
        }

    }

//    get student ID from email and password
//    @GetMapping("/{email}/{password}")  //probably will have to fix this
//    public Student getstudentWithEmailPassword(String email, String password){
//        return studentService.getstudentWithEmailPassword(email, password);
//    }




