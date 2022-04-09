package com.grademanager.demo.controller;

import com.grademanager.demo.model.Assignment;
import com.grademanager.demo.service.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/assignment")
public class AssignmentController{
    
    @Autowired
    private AssignmentService assignmentService;

    // GET
    @GetMapping("{name}")
    public Assignment getAssignment(@PathVariable String name){
        Optional<Assignment> optionalAssignment = assignmentService.getAssignment(name);
        if(!optionalAssignment.isPresent()){
            String err = String.format("The Assignment %s was not found", name);
            
            System.out.println(err);
        }
        return optionalAssignment.get();
    }

    // POSTS
    @PostMapping("{name}")
    public void createNewAssignment(@RequestBody Assignment assignment){
        assignmentService.createAssignment(assignment);
    }

    @PostMapping("/updateAssignment/{name}")
    public void updateAssignment(@RequestBody Assignment assignment, @PathVariable Integer grade){
        
        assignmentService.updateAssignment(assignment, grade);
    }

    // DELETE
    @DeleteMapping("{name}")
    public void deleteAssignment(@PathVariable String name){
        assignmentService.deleteAssignment(name);
    }
}