package com.grademanager.demo.model;

@Entity
@Table(name="assignments")
public class Assignment {
    @Column(name="grade")
    private int grade;
    @Column(name="name")
    private String name;
    @Column(name="weight")
    public int weight = 50;

    @ManyToOne
    private Course course;

    public Assignment(){}

    public Assignment(String name, int grade){
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
