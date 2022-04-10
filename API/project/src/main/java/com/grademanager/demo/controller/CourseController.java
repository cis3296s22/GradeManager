package com.grademanager.demo.controller;
import java.util.Optional;

import com.grademanager.demo.model.Course;
import com.grademanager.demo.service.courseService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/course")
public class CourseController {

    @Autowired
    courseService courseService;

    //GET
    @GetMapping("{course}")
    public Course getCourse(Integer id){
        Optional <Course> optionalCourse = courseService.getCourse(id);
        if(!optionalCourse.isPresent()){
            String err = String.format("The course having ID %s was not found", id);
            System.out.println(err);
        }
        return optionalCourse.get();
    }

    // POST
    @PostMapping
    public void createNewCourse(@RequestBody Course course){
        courseService.createCourse(course);
    }

    @PostMapping("/{id}")
    public void updateCourse(@RequestBody Course course, @PathVariable Integer id){
        courseService.updateCourse(course);
    }

    // DELETE
    @DeleteMapping("{id}")
    public void deleteCourse(@PathVariable Integer id){
        courseService.deleteCourse(id);

    }
}
