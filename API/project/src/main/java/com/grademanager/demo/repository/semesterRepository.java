package com.grademanager.demo.repository;

import com.grademanager.demo.model.Semester;
import com.grademanager.demo.model.Student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface semesterRepository extends JpaRepository<Semester, Integer> {
    
}
