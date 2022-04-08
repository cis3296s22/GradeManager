package com.grademanager.demo.repository;

import com.grademanager.demo.model.Student;

import org.springframework.data.jpa.repository.JpaRepository;

public interface semesterRepository extends JpaRepository<Student,Long> {
    
}
