package com.grademanager.demo.service;

import java.util.Optional;
import com.grademanager.demo.model.Course;
import com.grademanager.demo.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.log4j.Log4j2;
import java.util.ArrayList;
import java.util.List;


@Service
@Log4j2
public class courseService {

    @Autowired
    CourseRepository courseRepository;

    public void createCourse(Course course){
        courseRepository.save(course);
    }

    public Optional<Course> getCourse(Integer id){
        return courseRepository.findById(id);
    }

    public List<Course> getAllCourses(){
        List<Course> courses = new ArrayList<>();
        courseRepository.findAll().forEach(courses::add);
        return courses;
    }

    public void deleteCourse(Integer id){
        courseRepository.deleteById(id);
    }

    public void updateCourse(Course course){
        courseRepository.save(course);
    }
}