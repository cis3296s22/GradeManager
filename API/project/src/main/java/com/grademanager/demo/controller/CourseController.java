package com.grademanager.demo.controller;
import java.util.Optional;

import com.grademanager.demo.model.Course;
import com.grademanager.demo.service.CourseService;
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
    CourseService courseService;

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

    @PostMapping
    public void createNewCourse(@RequestBody Course course){
        courseService.createCourse(course);
    }

    @PostMapping("/{id}")
    public void updateCourse(@RequestBody Course course, @PathVariable Long id){
        courseService.updateCourse(course);
    }

    @DeleteMapping("{id}")
    public void deleteCourse(@PathVariable Long id){
        courseService.deleteCourse(id);

    }
}
