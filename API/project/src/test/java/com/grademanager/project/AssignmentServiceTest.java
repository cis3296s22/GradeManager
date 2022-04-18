package com.grademanager.project;

import java.util.Arrays;
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

import java.util.List;
import java.util.ArrayList;


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

    @Test
    public void getAllAssignmentsTest(){
        Assignment assignment1 = new Assignment();
        assignment1.setId(Long.valueOf(1));
        assignment1.setName("Homework 1");
        assignment1.setGrade(50);

        Assignment assignment2 = new Assignment();
        assignment2.setId(Long.valueOf(2));
        assignment2.setName("Homework 2");
        assignment2.setGrade(60);

        Assignment assignment3 = new Assignment();
        assignment3.setId(Long.valueOf(2));
        assignment3.setName("Homework 3");
        assignment3.setGrade(78);

        List<Assignment> assignments = new ArrayList<>(Arrays.asList(
            assignment1, assignment2, assignment3
        ));
        
        Mockito.when(assignmentRepository.findAll()).thenReturn(assignments);

        List<Assignment> retrieveAssignments = assignmentService.getAllAssignments();
        Assert.assertEquals(assignments, retrieveAssignments);
    }

    // DELETE ASSIGNMENT DOESN'T RETURN ANYTHING

    
    // @Test
    // public void updateAssignmentTest(){
    //     Assignment assignment1 = new Assignment();
    //     assignment1.setId(Long.valueOf(1));
    //     assignment1.setName("Homework 1");
    //     assignment1.setGrade(50);

    //     Mockito.when(assignmentRepository.save(assignment1)).thenReturn(assignment1);

    //     Assignment assignment = assignmentService.updateAssignment(assignment1, Long.valueOf(1));
    //     Assert.assertNotEquals(assignment1, assignment);
    // }
    



    
}
