package com.grademanager.demo.repository;

import java.util.Optional;
import com.grademanager.demo.model.Assignment;
import com.grademanager.demo.model.Student;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AssignmentRepository{

    Optional<Assignment> findByName(String name);

	Student save(Assignment assignment);

    Iterable<Assignment> findAll();

    void deleteByName(String name);
}
