package com.grademanager.demo.service;

import com.grademanager.demo.model.Semester;
import com.grademanager.demo.repository.semesterRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class semesterService {
    
    @Autowired
    semesterRepository SemesterRepository;

    // public Boolean deleteSemester(Long studentId){
    //     Boolean success = false;
    //     try {
    //         if (semesterRepository.findById(studentId).isPresent()) {
    //             semesterRepository.deleteById(studentId);
    //             success = true;
    //         }
    //     } catch (Exception e) {
    //         e.printStackTrace();
    //     }
    //     return success;
    // }
}
