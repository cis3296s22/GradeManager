package com.grademanager.demo.service;
import com.grademanager.demo.model.Student;
import com.grademanager.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
//@Log4j2
public class StudentService {

    @Autowired
    StudentRepository studentRepository;
    
    public ResponseEntity<Student> createStudent(Student student) {
        return ResponseEntity.ok(studentRepository.save(student));
    }

    public void deleteStudent(Long studentId) {
        studentRepository.deleteById(studentId);
    }
    public ResponseEntity<Student> updateStudent(Student student, Long id) {
//        don't need to send the id in because save will update student
//        based on student info (which already includes id)


        if(studentRepository.findById(id).isPresent()){
            Student oldStudent = studentRepository.findById(id).get();
            

            String firstName =  (student.getFirstName() != null) ? student.getFirstName() : oldStudent.getFirstName();
            oldStudent.setFirstName(firstName);

            String lastName = (student.getLastName() != null) ? student.getLastName() : oldStudent.getLastName();
            oldStudent.setLastName(lastName);

            String email = (student.getEmail() != null) ? student.getEmail() : oldStudent.getEmail();
            oldStudent.setEmail(email);

            // unable to change password and birthday
            // LocalDate birthday = (student.getBirthday() != null) ? student.getBirthday() : oldStudent.getBirthday();
            // oldStudent.setBirthday(birthday);

            Integer age = (student.getAge() != null) ? student.getAge() : oldStudent.getAge();
            oldStudent.setAge(age);

            student.setStudentId(id);
        }
        
        return ResponseEntity.ok(studentRepository.save(student));
    }

    public  ResponseEntity<Student> getStudent(Long studentId) {
        return ResponseEntity.ok(studentRepository.findById(studentId).get());
    }

    

//unfinished
//    public Student getstudentWithEmailPassword(String email, String password){
//        Student matchingStudent = (Student) studentRepository.findAll().stream().filter(student -> student.getEmail().equals(email));
////        check if password matches?
//        return new Student("firstname", "lastname", 80, "string", LocalDate.of(2011, 12, 12));
//    }

    public ResponseEntity<List<Student>> getAllStudents(){
        List<Student> students = new ArrayList<>();
        studentRepository.findAll().forEach(students::add);
        return ResponseEntity.ok(students);
    }
}
