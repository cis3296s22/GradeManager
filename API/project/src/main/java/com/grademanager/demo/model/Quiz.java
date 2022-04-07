package com.grademanager.demo.model;

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

    public Quiz(String name,int grade) {
        this.name = name;
        this.grade = grade;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade){
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
