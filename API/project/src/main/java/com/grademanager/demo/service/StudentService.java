package com.grademanager.demo.service;
import com.grademanager.demo.model.*;
import com.grademanager.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
//@Log4j2
public class StudentService {

    @Autowired
    StudentRepository studentRepository;
    
    public void createStudent(Student student) {
        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
        studentRepository.deleteById(studentId);
    }
    public void updateStudent(Student student) {
//        don't need to send the id in because save will update student
//        based on student info (which already includes id)
        studentRepository.save(student);
    }

    public Optional<Student> getStudent(Long studentId) {
        return studentRepository.findById(studentId);

    }

//unfinished
//    public Student getstudentWithEmailPassword(String email, String password){
//        Student matchingStudent = (Student) studentRepository.findAll().stream().filter(student -> student.getEmail().equals(email));
////        check if password matches?
//        return new Student("firstname", "lastname", 80, "string", LocalDate.of(2011, 12, 12));
//    }

    public List<Student> getAllStudents(){
        List<Student> students = new ArrayList<>();
        studentRepository.findAll().forEach(students::add);
        return students;
    }
}
