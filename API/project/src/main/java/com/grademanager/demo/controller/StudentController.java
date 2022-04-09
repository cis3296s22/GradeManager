package com.grademanager.demo.controller;
import com.grademanager.demo.model.*;
import com.grademanager.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

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

    @PostMapping("/updateStudent")
    public void updateStudent(@RequestBody Student student, @PathVariable Long id){
        studentService.updateStudent(student);
    }

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
