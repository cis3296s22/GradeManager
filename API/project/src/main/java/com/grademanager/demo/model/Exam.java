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

@Entity
@Table(name="exams")
public class Exam {
    @Column(name="grade")
    private int grade;
    @Column(name="weight")
    public int weight = 30;
    @Column(name="name")
    private String name;

    @ManyToOne
    private Course course;

    public Exam(){}

    public Exam(String name, int grade){
        this.name = name;
        this.grade = grade;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getWeight(){
        return weight;
    }
    
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
}
