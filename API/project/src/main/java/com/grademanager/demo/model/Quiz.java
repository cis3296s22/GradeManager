package com.grademanager.demo.model;

public class Quiz {
    private int grade;

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
