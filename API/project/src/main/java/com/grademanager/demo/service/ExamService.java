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

    public void createExam(Exam exam){
        examRepository.save(exam);
    }
    
    public void updateExam(Exam exam){
        examRepository.save(exam);

    }

    public void deleteExam(Long id){
        examRepository.deleteById(id);
    }

    public Optional<Exam> getExam(Long id) {
        return examRepository.findById(id);
    }

    public List<Exam> getAllExams(){
        List<Exam> exams = new ArrayList<>();
        examRepository.findAll().forEach(exams::add);
        return exams;
    }

}
