package com.grademanager.demo.service;
import com.grademanager.demo.model.*;
import com.grademanager.demo.repository.AssignmentRepository;
import com.grademanager.demo.repository.StudentRepository;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class AssignmentService {

    @Autowired
    AssignmentRepository assignmentRepository;

    public void createAssignment(Assignment assignment){
        assignmentRepository.save(assignment);
    }
    
    public Optional<Assignment> getAssignment(String name){
        return assignmentRepository.findByName(name);
    }

    public List<Assignment> getAllAssignments(){
        List<Assignment> assignments = new ArrayList<>();
        assignmentRepository.findAll().forEach(assignments::add);
        return assignments;
    }

    public void updateAssignment(Assignment assignment, Integer grade){
        assignmentRepository.save(assignment);
    }

    public void deleteAssignment(String name) {
        assignmentRepository.deleteByName(name);
    }
}
