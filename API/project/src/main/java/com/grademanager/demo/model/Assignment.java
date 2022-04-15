package com.grademanager.demo.model;

import javax.persistence.*;
import javax.persistence.Id;


@Entity
@Table(name="assignments")
public class Assignment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //Assuming ID is auto incremented by database
    @Column(name="grade")
    private int grade;
    @Column(name="name")
    private String name;
    @Column(name="weight")
    public int weight = 50;


    @ManyToOne
    private Course course;

    public Assignment(){}

    public Assignment(int grade){
        this.grade = grade;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public double getWeight() {
        return 0;
    }
}
