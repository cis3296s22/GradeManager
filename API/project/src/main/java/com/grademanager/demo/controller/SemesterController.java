package com.grademanager.demo.controller;
import com.grademanager.demo.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("api/v1/student")
public class SemesterController {

    @PostMapping("/semester")
    public Integer semesterNumber(){
        return 0;
    }
}
