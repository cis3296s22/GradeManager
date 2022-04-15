package com.grademanager.demo.repository;

// import java.util.Optional;

import com.grademanager.demo.model.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

}
