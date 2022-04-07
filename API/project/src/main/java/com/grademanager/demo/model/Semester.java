package com.grademanager.demo.model;

import java.util.ArrayList;

@Entity
@Table(name="semesters")
public class Semester {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //Assuming ID is auto incremented by database
    @Column(name="semesterId")
    private int id;
    @Column(name="number")  //what is the difference between number and name?
    private int number; // Semester 1
    @Column(name="name")
    private String name; // Fall 2022
    @ManyToOne
    private Student student;
    @OneToMany(mappedBy="semesters", cascade = CascadeType.ALL, orphanRemoval = true, targetEntity = Semester.class)
    public ArrayList<Course> courseList = new ArrayList<Course>();


    private int semesterScore = 0;

    public void addCourse(Course course){
        courseList.add(course);
    }

    public double calculateSemesterGrade(){
        for(int i = 0; i < courseList.size(); i++){
            semesterScore += courseList.get(i).getCourseGrade();
        }
        return semesterScore;
    }

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
