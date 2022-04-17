package com.grademanager.demo.repository;
// import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.grademanager.demo.model.Quiz;

public interface QuizRepository extends JpaRepository<Quiz, Long> {
    

}
