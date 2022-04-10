package com.grademanager.demo.model;
import javax.persistence.*;

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
