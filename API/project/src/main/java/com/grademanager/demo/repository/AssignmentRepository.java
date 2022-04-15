package com.grademanager.demo.repository;

import java.util.Optional;
import com.grademanager.demo.model.Assignment;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AssignmentRepository extends JpaRepository<Assignment, Long> {

    Optional<Assignment> findByName(String name);

    void deleteByName(String name);
}
