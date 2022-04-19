package com.grademanager.demo.model;
import javax.persistence.*;
import javax.persistence.Id;

import lombok.Data;

import java.io.Serializable;
import java.util.Set;

@Data
@Entity
@Table(name="semesters")
public class Semester implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //Assuming ID is auto incremented by database
    @Column(name="semesterId")
    private Long id;
    @Column(name="number")
    private int number; // Semester 1
    @Column(name="name")
    private String name; // Fall 2022
    @ManyToOne
    private Student student;          //Cascade to propagate changes from any related antities to Semester, to automatically remove orphaned entities.
    @OneToMany(mappedBy="semester",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public Set<Course> courseList;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Student getStudent() {
        return student;
    }
    public void setStudent(Student student) {
        this.student = student;
    }

    
    private int semesterScore = 0;

    
    /** 
     * @param course
     */
    public void addCourse(Course course){
        courseList.add(course);
    }
    /**
     * calculates the grade for an entire semester based on the courses from the courseList
     * @return double - the weighted semester result for a student
     */
    public double calculateSemesterGrade(){
        for(int i = 0; i < courseList.size(); i++){
            semesterScore += courseList.get(i).getCourseGrade();
        }
        return semesterScore;
    }

    /**
     * calculates the LetterGrade based on the semesterScore
     * @param semesterScore - a double representing the SemesterScore
     * @return String - representing the Letter Grade of the student
     */
    public String calculateLetterGrade(double semesterScore){
        if (semesterScore >= 93.00){
            return "A";
        }
        else if(semesterScore >= 90.00 && semesterScore < 93.00){
            return "A-";
        }
        else if(semesterScore >= 87.00 && semesterScore < 90.00){
            return "B+";
        }
        else if(semesterScore >= 84.00 && semesterScore < 87.00){
            return "B";
        }
        else if (semesterScore >= 80.00 && semesterScore < 84.00){
            return "B-";
        }
        else if(semesterScore >= 77.00 && semesterScore < 80.00){
            return "C+";
        }
        else if(semesterScore >= 74.00 && semesterScore < 77.00){
            return "C";
        }
        else if (semesterScore >= 70.00 && semesterScore < 74.00){
            return "C-";
        }
        else if(semesterScore >= 67.00 && semesterScore < 70.00){
            return "D+";
        }
        else if(semesterScore >= 64.00 && semesterScore < 67.00){
            return "D";
        }
        else if (semesterScore >= 60.00 && semesterScore < 64.00){
            return "D-";
        }

        return "F";
    
    
}
}
