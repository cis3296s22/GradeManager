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

    /**
     * @param assignment - an assignment object that would is to be saved in the assignmentRepository
     * @return assignment - the assignment object that is now saved in the assignmentRepository
     */
    public Assignment createAssignment(Assignment assignment){
        return assignmentRepository.save(assignment);
    }
    /**
     * @param id - the unique ID associated to the assignment object
     * @return an optional assignment object if found with the associated id
     */
    public Assignment getAssignment(Long id){        
        Optional<Assignment> optionalAssignment = assignmentRepository.findById(id);
        if(!optionalAssignment.isPresent()){
            String err = String.format("The Assignment %s was not found", id);
            
            System.out.println(err);
        }
        return optionalAssignment.get();
    }
    /**
     * @return list of assignment associated to the user
     */
    public List<Assignment> getAllAssignments(){
        List<Assignment> assignments = new ArrayList<>();
        assignmentRepository.findAll().forEach(assignments::add);
        return assignments;
    }
    

    // name, grade
    /**
     * @param assignment, id - the assignment object, the unique ID associated to the assignment object
     * @return the assignment object that is now saved in the assignmentRepository
     */
    public Assignment updateAssignment(Assignment assignment, Long id){
        if(this.getAssignment(id).getId() == id){
        // if(assignmentRepository.findById(id).isPresent()){
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
    /**
     * @param id - the unique ID associated to the assignment object
     */ 
    public void deleteAssignment(Long id) {
        assignmentRepository.deleteById(id);        
    }
}
