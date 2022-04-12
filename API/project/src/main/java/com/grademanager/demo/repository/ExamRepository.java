package com.grademanager.demo.repository;

import com.grademanager.demo.model.Exam;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ExamRepository extends JpaRepository<Exam, Long> {

}
