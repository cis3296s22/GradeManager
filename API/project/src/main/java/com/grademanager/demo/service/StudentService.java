package com.grademanager.demo.service;
import com.grademanager.demo.model.Student;
import com.grademanager.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.Optional;

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

    public ResponseEntity<Student> getStudent(Long id){
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if(!optionalStudent.isPresent()){
            String err = String.format("The student %s was not found", id);
            System.out.println(err);
        }
        // not actuall handling when there is no student (use response entity )
        return ResponseEntity.ok(optionalStudent.get());
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
            student.setFirstName(firstName);

            String lastName = (student.getLastName() != null) ? student.getLastName() : oldStudent.getLastName();
            student.setLastName(lastName);

            String email = (student.getEmail() != null) ? student.getEmail() : oldStudent.getEmail();
            student.setEmail(email);

            // unable to change password and birthday rn
            // LocalDate birthday = (student.getBirthday() != null) ? student.getBirthday() : oldStudent.getBirthday();
            // oldStudent.setBirthday(birthday);

            Integer age = (student.getAge() != null) ? student.getAge() : oldStudent.getAge();
            student.setAge(age);

            student.setStudentId(id);
        }

        return ResponseEntity.ok(studentRepository.save(student));
        
    }



    public ResponseEntity<List<Student>> getAllStudents(){
        List<Student> students = new ArrayList<>();
        studentRepository.findAll().forEach(students::add);
        return ResponseEntity.ok(students);
    }
}
