package com.grademanager.project;
import java.util.Optional;

import com.grademanager.demo.model.Exam;
import com.grademanager.demo.repository.ExamRepository;
import com.grademanager.demo.service.ExamService;

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

@RunWith(MockitoJUnitRunner.class)
public class ExamServiceTest {
    
    @Mock
    private static ExamRepository examRepository;

    @InjectMocks
    private static ExamService examService = new ExamService();

    private static Exam exam;

    @Test
    public void getExamByIdTest(){
        exam = new Exam();
        exam.setId(Long.valueOf(1));
        exam.setName("Final");
        exam.setGrade(45);
       
        Optional<Exam> examOptional = Optional.of(exam);

        Mockito.when(examRepository.findById(Long.valueOf(1))).thenReturn(examOptional);

        Exam retreivedExam = examService.getExam(Long.valueOf(1));
        Assert.assertEquals(exam,retreivedExam);    
    }

    @Test
    public void createExamTest(){
        exam = new Exam();
        exam.setId(Long.valueOf(1));
        exam.setName("Final");
        exam.setGrade(45);
    
        Mockito.when(examRepository.save(exam))
        .thenReturn(exam);

        Exam retrievedExam = examService.createExam(exam);
        Assert.assertEquals(exam, retrievedExam);       
    }

    @Test
    public void getAllExamsTest(){
        exam = new Exam();
        exam.setId(Long.valueOf(1));
        exam.setName("Final");
        exam.setGrade(45);

        Exam exam2 = new Exam();
        exam2.setId(Long.valueOf(1));
        exam2.setName("Final");
        exam2.setGrade(45);

        Exam exam3 = new Exam();
        exam3.setId(Long.valueOf(1));
        exam3.setName("Final");
        exam3.setGrade(45);

        List<Exam> exams = new ArrayList<>(Arrays.asList(
            exam, exam2, exam3
        ));

        // Exam exam6 = new Exam();
        // exam6.setId(Long.valueOf(1));
        // exam6.setName("Final");
        // exam6.setGrade(45);

        // Exam exam7 = new Exam();
        // exam7.setId(Long.valueOf(1));
        // exam7.setName("Final");
        // exam7.setGrade(45);

        // Exam exam8 = new Exam();
        // exam8.setId(Long.valueOf(1));
        // exam8.setName("Final");
        // exam8.setGrade(45);

        // List<Exam> exams2 = new ArrayList<>(Arrays.asList(
        //     exam6, exam7, exam8
        // ));
        Mockito.when(examRepository.findAll()).thenReturn(exams);

        List<Exam> retreivedExams = examService.getAllExams();
        Assert.assertEquals(exams, retreivedExams);

    }
    // deleteExam isn't returning anything
    // update Exam has two calls to examRepository?

    



}
