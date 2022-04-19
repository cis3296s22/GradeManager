package com.grademanager.demo.service;

import com.grademanager.demo.model.Semester;
import com.grademanager.demo.repository.SemesterRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
//@Log4j2
public class SemesterService {
    
    @Autowired
    SemesterRepository semesterRepository;

    public Semester createSemester(Semester semester){
        return semesterRepository.save(semester);
    }
    public void deleteSemester(Long id){
    //if semester is displaying in frontend should be able to delete sem without needing student id
        semesterRepository.deleteById(id);
    }

    public void updateSemester(Semester semester){
        semesterRepository.save(semester);
    }

    public Semester getSemester(Long id){
        Optional<Semester> optionalSemester = semesterRepository.findById(id);
        if(!optionalSemester.isPresent()){
             String err = String.format("The semester %s was not found", id);            
            System.out.println(err);
        }
        return optionalSemester.get();
    }
    public List<Semester> getAllSemesters(){
        List<Semester> semesters = new ArrayList<>();
        semesterRepository.findAll().forEach(semesters::add);
        return semesters;

    }
}
