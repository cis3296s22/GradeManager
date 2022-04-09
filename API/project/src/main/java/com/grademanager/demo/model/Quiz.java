package com.grademanager.demo.model;
import javax.persistence.Id;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity //annotation specifies that this Java class is mapped to the database table.
@Table(name="quizzes")

public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name="grade")
    private int grade;
    @Column(name="name")
    private String name;
    @Column(name="weight")
    public int weight = 20;
}

