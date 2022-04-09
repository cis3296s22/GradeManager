package com.grademanager.demo.model;

import java.time.LocalDate;
import java.util.UUID;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.persistence.Id;
import java.io.File;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeoutException;

@Entity //annotation specifies that this Java class is mapped to the database table.
@Table(name="quizzes")
public class Quiz {
    @Column(name="grade")
    private int grade;
    @Column(name="name")
    private String name;
    @Column(name="weight")
    public int weight = 20;

    @ManyToOne
    private Course course;

    public Quiz() {}

    public Quiz(int grade) {
        this.grade = grade;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade){
        this.grade = grade;
    }

    public double getWeight() {
        return 0;
    }
}
