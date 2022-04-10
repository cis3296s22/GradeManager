package com.grademanager.demo.service;
import com.grademanager.demo.model.*;
import com.grademanager.demo.repository.StudentRepository;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@Log4j2
public class StudentService {

    @Autowired
    StudentRepository studentRepository;
    
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public void deleteStudent(long studentId) {
        studentRepository.deleteById(studentId);
    }
    public Student updateStudent(Student student) {
//        don't need to send the id in because save will update student
//        based on student info (which already includes id)
        return studentRepository.save(student);
    }

    public Student getStudent(Long studentId) {
        return studentRepository.findById(studentId).get();

    }

//unfinished
    public Student getstudentWithEmailPassword(String email, String password){
        Student matchingStudent = (Student) studentRepository.findAll().stream().filter(student -> student.getEmail().equals(email));
//        check if password matches?
        return new Student("firstname", "lastname", 80, "string", LocalDate.of(2011, 12, 12));
    }

    public List<Student> getAllStudents(){
        List<Student> students = new ArrayList<>();
        studentRepository.findAll().forEach(students::add);
        return students;
    }
}
