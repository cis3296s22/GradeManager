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

    @DeleteMapping("{id}")
    public void deleteSemester(@PathVariable Long id){
        semesterService.deleteSemester(id);
    }

    @PostMapping("/createNewSem/{id}")
    public void createNewSemester(@RequestBody Semester semester){
        semesterService.createSemester(semester);
    }

    @PostMapping("/updateSem/{id}")
    public void updateSemester(@RequestBody Semester semester, @PathVariable Integer id){
//        NEED TO UPDATE ASSOCIATED SERVICE FUNCTION
        semesterService.updateSemester(semester);
    }

    @GetMapping("{semester}")
    public Semester getSemester(Long id){
        Optional<Semester> optionalSemester = semesterService.getSemester(id);
        if(!optionalSemester.isPresent()){
            String ErrMsg = String.format("The semester having ID %s was not found", id);
//            USE LOGGER? and throw an exception?
            System.out.println(ErrMsg);
        }
        // going to crash if semester isn't returned bc exception isn't thrown above
        return optionalSemester.get();
    }

}
