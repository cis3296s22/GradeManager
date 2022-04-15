package com.grademanager.demo.controller;
import org.springframework.http.ResponseEntity;
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

@RestController
@RequestMapping("api/v1/assignment")
public class AssignmentController{
    
    @Autowired
    private AssignmentService assignmentService;

    @GetMapping("{name}")
    public ResponseEntity<Assignment> getAssignment(@PathVariable String name){
        return ResponseEntity.ok(assignmentService.getAssignment(name));
    }

    @PostMapping("{name}")
    public ResponseEntity<Assignment> createNewAssignment(@RequestBody Assignment assignment){
         return ResponseEntity.ok(assignmentService.createAssignment(assignment));
    }

    @PostMapping("{id}")
    public ResponseEntity<Assignment> updateAssignment(@RequestBody Assignment assignment, @PathVariable Integer grade){
          return ResponseEntity.ok(assignmentService.updateAssignment(assignment, grade));
    }

    @DeleteMapping("{name}")
    public void deleteAssignment(@PathVariable String name){
        assignmentService.deleteAssignment(name);
    }
}