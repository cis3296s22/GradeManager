package com.grademanager.demo.service;
import com.grademanager.demo.model.*;
import com.grademanager.demo.repository.AssignmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
//@Log4j2
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
