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
// import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/assignment")
public class AssignmentController{
    
    @Autowired
    private AssignmentService assignmentService;

    /**
     * Handles the GET REQUESTS for the Assignment Objects
     * @param id - the unique ID associated to the specific assignment object in the database 
     * @return a HTTP response with the status code, assignment object, and header
     */
    @GetMapping("{id}")
    public ResponseEntity<Assignment> getAssignment(@PathVariable Long id){
        return ResponseEntity.ok(assignmentService.getAssignment(id));
    }

    /**
     * Handles the POST REQUEST for the Assignment Objects
     * @param assignment - an assignment object to create a new assignment object
     * @return a HTTP response with the status code, assignment object, and header
     */
    @PostMapping("/create")
    public ResponseEntity<Assignment> createNewAssignment(@RequestBody Assignment assignment){
         return ResponseEntity.ok(assignmentService.createAssignment(assignment));
    }
    /**
     * Handles the POST REQUEST for the Assignment Objects
     * @param assignment - an assignment object to update the existing object
     * @param id - the unique ID associated to the existing assignment object
     * @return a HTTP response with the status code, assignment object, and header
     */
    @PostMapping("{id}")
    public ResponseEntity<Assignment> updateAssignment(@RequestBody Assignment assignment, @PathVariable Long id){
          return ResponseEntity.ok(assignmentService.updateAssignment(assignment, id));
    }

    /**
     * Handles the DELETE REQUEST for the Assignment Objects
     * @param id - the unique ID associated to the existing assignment object
     */
    @DeleteMapping("{id}")
    public void deleteAssignment(@PathVariable Long id){
        assignmentService.deleteAssignment(id);
    }
}