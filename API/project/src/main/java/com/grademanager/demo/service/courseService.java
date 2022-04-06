package com.grademanager.demo.service;

import com.grademanager.demo.model.Course;
import com.grademanager.demo.repository.courseRepository;

import org.springframework.beans.factory.annotation.Autowired;

public class courseService {

    
    @Autowired
    courseRepository courseRepository;


    public Boolean deleteStudent(Long studentId){
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
