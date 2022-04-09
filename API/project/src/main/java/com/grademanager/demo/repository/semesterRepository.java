package com.grademanager.demo.repository;

import com.grademanager.demo.model.Semester;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SemesterRepository extends JpaRepository<Semester, Long> {
    
}
