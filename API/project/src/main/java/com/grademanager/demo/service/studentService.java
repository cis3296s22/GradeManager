package com.grademanager.demo.service;
import com.grademanager.demo.model.*;
import com.grademanager.demo.repository.StudentRepository;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Log4j2
public class studentService {

    @Autowired
    StudentRepository studentRepository;
    
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public Boolean deleteStudent(Long studentId) {
        Boolean success = false;
        try {
            if (studentRepository.findById(studentId).isPresent()) {
                studentRepository.deleteById(studentId);
                success = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return success;
    }
    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student getStudent(Long studentId) {
        return studentRepository.findById(studentId).get();
    }
}
