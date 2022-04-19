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

    public Exam createExam(Exam exam){
        return examRepository.save(exam);
    }
    
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

    public void deleteExam(Long id){
        examRepository.deleteById(id);
    }

    public Exam getExam(Long id) {
        Optional<Exam> optionalExam = examRepository.findById(id);
        if(!optionalExam.isPresent()){
            String err = String.format("The exam %s was not found", id);
            
            System.out.println(err);
        }
        return optionalExam.get();
    }

    public List<Exam> getAllExams(){
        List<Exam> exams = new ArrayList<>();
        examRepository.findAll().forEach(exams::add);
        return exams;
    }

}
