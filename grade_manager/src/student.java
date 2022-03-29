package com.example.grade.student;

import java.time.LocalDate;

public class Student {

    private String name;
    private int id;
    private int age;
    private String email;
    private LocalDate dob;

    private ArrayList<Course> courseList;
    public Student(){}

    public Student(String name, int age, String email, LocalDate dob){
        this.name = name;
        this.age = age;
        this.email = email;
        this.dob = dob;
    }

    public Student(int id, String name, int age, String email, LocalDate dob) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.dob = dob;
    }

    public void addCourse(Course course){
        courseList.add(course);
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    @Override
    public String toString(){
        return "Student " +
                "{" +
                "id = " + id +
                "name = " + name +
                "age = " + age +
                "dob = " + dob +
                "email = " + email +
                "}";
    }
}
