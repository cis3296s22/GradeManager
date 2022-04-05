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
import java.util.concurrent.TimeoutException;
// To Do: Add semster object
         // Secure password ?
        
@Entity

@Table(name="students")
//private ArrayList<Course> courseList;
public class Student {
    
    @Id
    private long studentId=UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
    @Column(name="firstName")
    private String firstName;
    @Column(name="lastName")
    private String lastName;
    @Column(name="email")
    private String email;
    @Column(name="password")
    private String password;
    @Column(name = "birthday")
    private LocalDate birthday;
    @Column (name = "age")
    private int age;

    
    public ArrayList<Semester> semesterList= new ArrayList<Semester>();

    public void addSemester(Semester semester){
        semesterList.add(semester);
    }

    public Student(){}
    
    public Student(String firstName, String lastName, int age, String email, LocalDate birthday){
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
        this.birthday = birthday;
    }

    public long getStudentId() {
        return this.studentId;
    }

    public String getName() {
        return this.firstName + this.lastName;
    }

    public int getAge() {
        return this.age;
    }

    public String getEmail() {
        return this.email;
    }

    public LocalDate getBirthday() {
        return this.birthday;
    }

    public void setStudentId() {
        //UUID uniqueKey = UUID.randomUUID();
        //this.studentId = uniqueKey.toString();
    }

    public void setFirstName(String name) {
        this.firstName = name;
    }
    public void setLastName(String name) {
        this.lastName = name;
    }


    public void setAge(int age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString(){
        return "Student " +
                "{" +
                "id = " + this.studentId +
                "name = " + this.firstName + this.lastName +
                "age = " + this.age +
                "dob = " + this.birthday +
                "email = " + this.email +
                "}";
        }
}
