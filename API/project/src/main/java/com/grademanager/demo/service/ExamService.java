package com.grademanager.demo.service;

import java.util.ArrayList;
import java.util.List;

import java.util.Optional;
import com.grademanager.demo.model.Exam;
import com.grademanager.demo.repository.ExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
//@Log4j2
public class ExamService {

    @Autowired
    ExamRepository examRepository;

    /**
     * @param Exam - an Exam object that would is to be saved in the ExamRepository
     * @return Exam - the Exam object that is now saved in the ExamRepository
     */
    public Exam createExam(Exam exam){
        return examRepository.save(exam);
    }
    /**
     * @param Exam, id - the Exam object, the unique ID associated to the Exam object
     * @return the Exam object that is now saved in the ExamRepository
     */
    public Exam updateExam(Exam exam, Long id){
        if(examRepository.findById(id).isPresent()){
            Exam oldExam = examRepository.findById(id).get();

            Integer grade =  (exam.getGrade() != null) ? exam.getGrade() : oldExam.getGrade();
            exam.setGrade(grade);

            String name = (exam.getName() != null) ? exam.getName() : oldExam.getName();
            exam.setName(name);

            exam.setId(id);
            
        }   
        // rn if the exam isn't present, a new exam is created
        return examRepository.save(exam);

    }

    /**
     * @param id - the unique ID associated to the Exam object
     */ 
    public void deleteExam(Long id){
        examRepository.deleteById(id);
    }

    /**
     * @param id - the unique ID associated to the Exam object
     * @return an optional Exam object if found with the associated id
     */
    public Optional<Exam> getExam(Long id) {
        return examRepository.findById(id);
    }

    /**
     * @return list of Exam associated to the user
     */
    public List<Exam> getAllExams(){
        List<Exam> exams = new ArrayList<>();
        examRepository.findAll().forEach(exams::add);
        return exams;
    }

}
