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

   /**
     * @param Semester - an Semester object that would is to be saved in the SemesterRepository
     * @return Semester - the Semester object that is now saved in the SemesterRepository
     */
    public Semester createSemester(Semester semester){
        return semesterRepository.save(semester);

    }
    /**
     * @param id - the unique ID associated to the Semester object
     */ 
    public void deleteSemester(Long id){
    //if semester is displaying in frontend should be able to delete sem without needing student id
        semesterRepository.deleteById(id);
    }

    /**
     * @param Semester, id - the Semester object, the unique ID associated to the Semester object
     * @return the Semester object that is now saved in the SemesterRepository
     */
    public void updateSemester(Semester semester){
        semesterRepository.save(semester);
    }

   /**
     * @param id - the unique ID associated to the Semester object
     * @return an optional Semester object if found with the associated id
     */
    public Semester getSemester(Long id){
        Optional<Semester> optionalSemester = semesterRepository.findById(id);
        if(!optionalSemester.isPresent()){
             String err = String.format("The semester %s was not found", id);            
            System.out.println(err);
        }
        return optionalSemester.get();

    }
    /**
     * @return list of assignment associated to the user
     */
    public List<Semester> getAllSemesters(){
        List<Semester> semesters = new ArrayList<>();
        semesterRepository.findAll().forEach(semesters::add);
        return semesters;

    }
}
