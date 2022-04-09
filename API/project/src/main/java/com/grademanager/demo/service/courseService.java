package com.grademanager.demo.service;

import com.grademanager.demo.model.Course;
import com.grademanager.demo.repository.CourseRepository;

import org.springframework.beans.factory.annotation.Autowired;

public class courseService {

    
    @Autowired
    CourseRepository courseRepository;


    public Boolean deleteCourse(Long studentId){
        Boolean success = false;
    
        try{
            if(courseRepository.findById(studentId).isPresent()){
                courseRepository.deleteById(studentId);
                success = true;
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    return success;
    }

    
}
