package com.grademanager.demo.controller;
import com.grademanager.demo.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
// To Do: Add logger
@Log4j2
@RestController
@RequestMapping("api/v1/Student")
public class StudentController {

    
//@PostMapping("/createStudent")
//public ResponseEntity<Student> createStudent(@RequestBody Student student) {
  //  return new Student();
//}
@PostMapping("/age")
public Integer age(@RequestBody Id studentId) {
    return 0;
  }
}
