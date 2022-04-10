package com.grademanager.demo.repository;

import com.google.common.base.Optional;
import com.grademanager.demo.model.Exam;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ExamRepository {

    static void deleteByName(String name) {
    }

    static void save(Exam exam) {
    }

    static void deleteExam(String name) {
    }

    Optional<Exam> findByName(String name);

    Iterable<Exam> findAll();
    
}
