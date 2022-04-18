package com.grademanager.project;

import java.util.Optional;

// import com.grademanager.*;
import com.grademanager.demo.model.Assignment;
import com.grademanager.demo.repository.AssignmentRepository;
import com.grademanager.demo.service.AssignmentService;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class AssignmentServiceTest {
    
    @Mock
    private static AssignmentRepository assignmentRepository;

    @InjectMocks
    private static AssignmentService assignmentService = new AssignmentService();

    private static Assignment assignment;

    @Test
    public void getAssignmentByIdTest(){
        assignment = new Assignment();
        assignment.setId(Long.valueOf(1));
        assignment.setName("Homework 1");
        assignment.setGrade(50);

        Optional<Assignment> assignment1 = Optional.of(assignment);
        
        Mockito.when(assignmentRepository.findById(Long.valueOf(1))).thenReturn(assignment1);

        Assignment retrievedAssignmnet = assignmentService.getAssignment(Long.valueOf(1));
        Assert.assertEquals(assignment, retrievedAssignmnet);

    }

    @Test
    public void createAssignmentTest(){
        assignment = new Assignment();
        assignment.setId(Long.valueOf(1));
        assignment.setName("Homework 1");
        assignment.setGrade(50);

        Mockito.when(assignmentRepository.save(assignment)).thenReturn(assignment);

        Assignment retrievedAssignmnet = assignmentService.createAssignment(assignment);
        Assert.assertEquals(assignment, retrievedAssignmnet);

    }

    // DELETE ASSIGNMENT DOESN'T RETURN ANYTHING
    
    


    
}
