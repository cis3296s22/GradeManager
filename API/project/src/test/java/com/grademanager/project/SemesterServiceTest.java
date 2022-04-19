package com.grademanager.project;
import java.util.Optional;

import com.grademanager.demo.repository.SemesterRepository;
import com.grademanager.demo.service.SemesterService;
import com.grademanager.demo.model.Semester;
import com.grademanager.demo.model.Student;

import java.util.Arrays;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;


@RunWith(MockitoJUnitRunner.class)
public class SemesterServiceTest {
    @Mock
    private static SemesterRepository semesterRepository;
    
    @InjectMocks
    private static SemesterService semesterService = new SemesterService();

    private static Semester semester;

    @Test
    public void getSemesterById(){
        semester = new Semester();
        semester.setId(Long.valueOf(1));
        semester.setName("Fall 2019");
        semester.setNumber(1);

        Student student3 = new Student();
        student3.setFirstName("Johnny");
        student3.setLastName("Appleseed");
        student3.setAge(45);
        student3.setBirthday(LocalDate.of(1977, 1, 1));
        student3.setEmail("email@gmail.com");
        student3.setStudentId(Long.valueOf(6789));
        
        semester.setStudent(student3);
        
        Optional<Semester> optionalSemester = Optional.of(semester);
        Mockito.when(semesterRepository.findById(Long.valueOf(1)))
        .thenReturn(optionalSemester);

        Semester retrievedSemester = semesterService.getSemester(Long.valueOf(1));
        Assert.assertEquals(semester, retrievedSemester);        
    }

    @Test
    public void createSemesterTest(){
        semester = new Semester();
        semester.setId(Long.valueOf(1));
        semester.setName("Fall 2019");
        semester.setNumber(1);

        Mockito.when(semesterRepository.save(semester))
        .thenReturn(semester);
        Semester retrievedSemester = semesterService.createSemester(semester);
        Assert.assertEquals(semester, retrievedSemester);        
    }   
    @Test
    public void getAllSemestersTest(){
        Semester semester1 = new Semester();
        semester1.setId(Long.valueOf(1));
        semester1.setName("Fall 2019");
        semester1.setNumber(1);

        Semester semester2 = new Semester();
        semester2.setId(Long.valueOf(1));
        semester2.setName("Fall 2019");
        semester2.setNumber(1);

        Semester semester3 = new Semester();
        semester3.setId(Long.valueOf(1));
        semester3.setName("Fall 2019");
        semester3.setNumber(1);
        
        List<Semester> semesters = new ArrayList<>(Arrays.asList(
            semester1, semester2, semester3
        ));

        Mockito.when(semesterRepository.findAll())
        .thenReturn(semesters);

        List<Semester> retrieveSemesters = semesterService.getAllSemesters();
        Assert.assertEquals(semesters, retrieveSemesters);
        

    }

    
}
