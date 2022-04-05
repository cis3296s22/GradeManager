package com.grademanager.demo.model;

public class Quiz {
    private int grade;
    private String name;
    public int weight = 20;

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
