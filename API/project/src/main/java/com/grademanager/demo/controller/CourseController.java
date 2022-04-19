package com.grademanager.demo.controller;

import com.grademanager.demo.model.Course;
import com.grademanager.demo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    public CourseController(CourseService courseService){
        this.courseService = courseService;

    }
    /**
     * Handles the GET REQUESTS for the Course Objects
     * @param id - the unique ID associated to the specific course object in the database 
     * @return a HTTP response with the status code, course object, and header
     */
    @GetMapping("{id}")
    public ResponseEntity<Course> getCourse(@PathVariable Long id){
        return ResponseEntity.ok(courseService.getCourse(id));
    }

    /**
     * Handles the POST REQUEST for the Course Objects
     * @param assignment - an assignment object to create a new course object
     * @return a HTTP response with the status code, course object, and header
     */
    @PostMapping("/create")
    public ResponseEntity<Course> createNewCourse(@RequestBody Course course){
        return ResponseEntity.ok(courseService.createCourse(course));
    }

    /**
     * Handles the POST REQUEST for the Course Objects
     * @param assignment - an course object to update the existing object
     * @param id - the unique ID associated to the existing course object
     * @return a HTTP response with the status code, course object, and header
     */
    @PostMapping("/{id}")
    public ResponseEntity<Course> updateCourse(@RequestBody Course course, @PathVariable Long id){
        return ResponseEntity.ok(courseService.updateCourse(course, id));
    }

    /**
     * Handles the DELETE REQUEST for the Course Objects
     * @param id - the unique ID associated to the existing course object
     */
    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable Long id){
        courseService.deleteCourse(id);
    }
}
