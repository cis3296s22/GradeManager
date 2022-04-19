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
    
    /**
     * @param Student - an Student object that would is to be saved in the StudentRepository
     * @return Student - the Student object that is now saved in the StudentRepository
     */
    public ResponseEntity<Student> createStudent(Student student) {
        return ResponseEntity.ok(studentRepository.save(student));
    }

    /**
     * @param id - the unique ID associated to the Student object
     */ 
    public void deleteStudent(Long studentId) {
        studentRepository.deleteById(studentId);
    }
    /**
     * @param Student, id - the Student object, the unique ID associated to the Student object
     * @return the Student object that is now saved in the StudentRepository
     */
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
    }    

    

//unfinished
//    public Student getstudentWithEmailPassword(String email, String password){
//        Student matchingStudent = (Student) studentRepository.findAll().stream().filter(student -> student.getEmail().equals(email));
////        check if password matches?
//        return new Student("firstname", "lastname", 80, "string", LocalDate.of(2011, 12, 12));
//    }


    /**
     * @return list of Student associated to the user
     */
    public ResponseEntity<List<Student>> getAllStudents(){
        List<Student> students = new ArrayList<>();
        studentRepository.findAll().forEach(students::add);
        return ResponseEntity.ok(students);
    }
}
