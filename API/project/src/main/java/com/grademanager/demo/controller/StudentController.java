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

    /**
     * Handles the DELETE REQUEST for the Student Objects
     * @param id - the unique ID associated to the existing Student object
     */
    @DeleteMapping("/deleteStudent/{id}")
    public void deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
    }

    /**
     * Handles the POST REQUEST for the Student Objects
     * @param Student - an Student object to create a new Student object
     * @return a HTTP response with the status code, Student object, and header
     */
    @PostMapping("/createStudent")
    public ResponseEntity<Student> registerNewStudent(@RequestBody Student newStudent){
        return studentService.createStudent(newStudent);
    }

     /**
     * Handles the POST REQUEST for the Student Objects
     * @param Student - an Student object to update the existing object
     * @param id - the unique ID associated to the existing Student object
     * @return a HTTP response with the status code, Student object, and header
     */
    @PostMapping("{id}")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable Long id){
        return studentService.updateStudent(student, id);
    }

    /**
     * Handles the GET REQUESTS for the Student Objects
     * @param id - the unique ID associated to the specific Student object in the database 
     * @return a HTTP response with the status code, Student object, and header
     */
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




