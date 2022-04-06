package com.grademanager.demo.model;

public class Assignment {
    private int grade;
    private String name;
    public int weight = 50;

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
