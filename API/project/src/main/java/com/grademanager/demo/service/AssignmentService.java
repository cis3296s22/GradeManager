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

    public Assignment createAssignment(Assignment assignment){
        return assignmentRepository.save(assignment);
    }
    
    public Assignment getAssignment(Long id){        
        Optional<Assignment> optionalAssignment = assignmentRepository.findById(id);
        if(!optionalAssignment.isPresent()){
            String err = String.format("The Assignment %s was not found", id);
            
            System.out.println(err);
        }
        return optionalAssignment.get();
    }

    public List<Assignment> getAllAssignments(){
        List<Assignment> assignments = new ArrayList<>();
        assignmentRepository.findAll().forEach(assignments::add);
        return assignments;
    }


// name, grade
    public Assignment updateAssignment(Assignment assignment, Long id){
        if(assignmentRepository.findById(id).isPresent()){
            Assignment oldAssignment = assignmentRepository.findById(id).get();
            
            String name = (assignment.getName() != null) ? assignment.getName() : oldAssignment.getName();
            oldAssignment.setName(name);

            Integer grade = (assignment.getGrade() != null) ? assignment.getGrade() : oldAssignment.getGrade();
            oldAssignment.setGrade(grade);


            assignment.setId(id);
        }
        return assignmentRepository.save(assignment);
    }

    // Could delete by entity
    public void deleteAssignment(Long id) {
        assignmentRepository.deleteById(id);        
    }
}
