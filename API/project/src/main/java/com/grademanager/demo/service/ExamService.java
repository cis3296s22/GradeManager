package com.grademanager.demo.service;

import java.util.ArrayList;
import java.util.List;

import com.google.common.base.Optional;
import com.grademanager.demo.model.Exam;
import com.grademanager.demo.repository.ExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.log4j.Log4j2;


@Service
@Log4j2
public class ExamService {

    @Autowired
    ExamRepository examRepository;

    public void createExam(Exam exam){
        ExamRepository.save(exam);
    }
    
    public void updateExam(Exam exam){
        ExamRepository.save(exam);

    }

    public void deleteExam(String name){
        ExamRepository.deleteByName(name);
    }

    public Optional<Exam> getExam(String name) {
        return examRepository.findByName(name);
    }

    public List<Exam> getAllExams(){
        List<Exam> exams = new ArrayList<>();
        examRepository.findAll().forEach(exams::add);
        return exams;
    }

}
