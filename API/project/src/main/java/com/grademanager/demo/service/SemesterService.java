package com.grademanager.demo.service;

import com.grademanager.demo.model.Semester;
import com.grademanager.demo.repository.semesterRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.log4j.Log4j2;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class SemesterService {
    
    @Autowired
    semesterRepository semesterRepository;

    public void createSemester(Semester semester){
        semesterRepository.save(semester);
    }

//    Delete
    public void deleteSemester(Integer id){
    //if semester is displaying in frontend should be able to delete sem without needing student id
        semesterRepository.deleteById(id);
    }

    public void updateSemester(Semester semester){
        semesterRepository.save(semester);
    }

    public Optional<Semester> getSemester(Integer id){
        return semesterRepository.findById(id);
    }
    public List<Semester> getAllSemesters(){
        List<Semester> semesters = new ArrayList<>();
        semesterRepository.findAll().forEach(semesters::add);
        return semesters;

    }
}
