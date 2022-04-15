package com.grademanager.demo.service;

import java.util.Optional;
import org.springframework.http.ResponseEntity;
import com.grademanager.demo.model.Course;
import com.grademanager.demo.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;


@Service
//@Log4j2
public class CourseService {

    @Autowired
    CourseRepository courseRepository;

    public Course createCourse(Course course){
        return courseRepository.save(course);
    }

    public Course getCourse(Integer id){
      Optional <Course> optionalCourse = courseRepository.findById(id);
        if(!optionalCourse.isPresent()){
            String err = String.format("The course having ID %s was not found", id);
            System.out.println(err);
        }
        return optionalCourse.get();
    }

    public List<Course> getAllCourses(){
        List<Course> courses = new ArrayList<>();
        courseRepository.findAll().forEach(courses::add);
        return courses;
    }

    public void deleteCourse(Long id){
        courseRepository.deleteById(id);
    }

    public Course updateCourse(Course course){
        return courseRepository.save(course);
    }
}
