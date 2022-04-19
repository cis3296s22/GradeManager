package com.grademanager.project;
import java.util.Optional;

import com.google.auth.oauth2.IdTokenProvider.Option;
import com.grademanager.demo.model.Student;
import com.grademanager.demo.repository.StudentRepository;
import com.grademanager.demo.service.StudentService;

import java.util.Arrays;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;
import java.time.LocalDate;
import java.util.ArrayList;

@RunWith(MockitoJUnitRunner.class)
public class StudentServiceTest {
    @Mock
    private static StudentRepository studentRepository;

    @InjectMocks
    private static StudentService studentService;

    private static Student student1;



    @Test
    public void getStudentByIdTest(){
        student1 = new Student();
        student1.setFirstName("John");
        student1.setLastName("Water");
        student1.setAge(23);
        student1.setBirthday(LocalDate.of(1999, 1, 1));
        student1.setEmail("email@gmail.com");
        student1.setStudentId(Long.valueOf(6789));

       

        Optional<Student> optionalStudent = Optional.of(student1);

        Mockito.when(studentRepository.findById(Long.valueOf(6789))).thenReturn(optionalStudent);
        
        Student retrieveStudent = studentService.getStudent(Long.valueOf(6789)).getBody();
        Assert.assertEquals(student1, retrieveStudent);    
    }

    @Test
    public void createStudentTest(){
        student1 = new Student();
        student1.setFirstName("John");
        student1.setLastName("Water");
        student1.setAge(23);
        student1.setBirthday(LocalDate.of(1999, 1, 1));
        student1.setEmail("email@gmail.com");
        student1.setStudentId(Long.valueOf(6789));

        Mockito.when(studentRepository.save(student1))
        .thenReturn(student1);

        Student retrievedStudent = studentService.createStudent(student1).getBody();
        Assert.assertEquals(student1, retrievedStudent);        
    }

    @Test
    public void getAllStudents(){
        student1 = new Student();
        student1.setFirstName("John");
        student1.setLastName("Water");
        student1.setAge(23);
        student1.setBirthday(LocalDate.of(1999, 1, 1));
        student1.setEmail("email@gmail.com");
        student1.setStudentId(Long.valueOf(6789));

        Student student2 = new Student();
        student2.setFirstName("Katie");
        student2.setLastName("Sharara");
        student2.setAge(89);
        student2.setBirthday(LocalDate.of(1933, 1, 1));
        student2.setEmail("email@gmail.com");
        student2.setStudentId(Long.valueOf(6789));

        Student student3 = new Student();
        student3.setFirstName("Johnny");
        student3.setLastName("Appleseed");
        student3.setAge(45);
        student3.setBirthday(LocalDate.of(1977, 1, 1));
        student3.setEmail("email@gmail.com");
        student3.setStudentId(Long.valueOf(6789));

        List<Student> students = new ArrayList<>(Arrays.asList(
            student1, student2, student3
        ));

        Mockito.when(studentRepository.findAll()).thenReturn(students);
        List<Student> retrievedStudents = studentService.getAllStudents().getBody();
        Assert.assertEquals(students, retrievedStudents);
    }

    // delete
    // update
    
}
