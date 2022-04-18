package com.grademanager.project;
import java.util.Optional;

// import com.grademanager.*;
import com.grademanager.demo.model.Exam;
import com.grademanager.demo.repository.ExamRepository;
import com.grademanager.demo.service.ExamService;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

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
        // exam.se
        // can't access the getter/setter id methods for exam (pr into main from keshav/refacotr)
    }

}
