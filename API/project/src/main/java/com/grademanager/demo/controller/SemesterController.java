package com.grademanager.demo.controller;
import com.grademanager.demo.model.*;
import com.grademanager.demo.service.SemesterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("api/v1/semester")
public class SemesterController {

    @Autowired
    private SemesterService semesterService;

    /**
     * Handles the DELETE REQUEST for the Semester Objects
     * @param id - the unique ID associated to the existing Semester object
     */
    @DeleteMapping("{id}")
    public void deleteSemester(@PathVariable Long id){
        semesterService.deleteSemester(id);
    }

    /**
     * Handles the POST REQUEST for the Semester Objects
     * @param assignment - an assignment object to create a new Semester object
     * @return a HTTP response with the status code, Semester object, and header
     */
    @PostMapping("/createNewSem/{id}")
    public void createNewSemester(@RequestBody Semester semester){
        semesterService.createSemester(semester);
    }

    /**
     * Handles the POST REQUEST for the Semester Objects
     * @param assignment - an Semester object to update the existing object
     * @param id - the unique ID associated to the existing Semester object
     * @return a HTTP response with the status code, Semester object, and header
     */
    @PostMapping("/updateSem/{id}")
    public void updateSemester(@RequestBody Semester semester, @PathVariable Integer id){
//        NEED TO UPDATE ASSOCIATED SERVICE FUNCTION
        semesterService.updateSemester(semester);
    }

    /**
     * Handles the GET REQUESTS for the Semester Objects
     * @param id - the unique ID associated to the specific Semester object in the database 
     * @return a HTTP response with the status code, Semester object, and header
     */
    @GetMapping("{semester}")
    public Semester getSemester(Long id){
        Semester semester = semesterService.getSemester(id);       
        // going to crash if semester isn't returned bc exception isn't thrown above
        return semester;
    }

}
