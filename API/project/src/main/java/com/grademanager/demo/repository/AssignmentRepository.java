package com.grademanager.demo.repository;
import com.grademanager.demo.model.Assignment;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AssignmentRepository extends JpaRepository<Assignment, Long> {

   
}
