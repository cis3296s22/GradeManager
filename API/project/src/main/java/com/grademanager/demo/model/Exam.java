package com.grademanager.demo.model;

public class Final {
    private int grade;
    public int weight = 30;
    private String name;

    public Final(){}

    public Final(String name, int grade){
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
