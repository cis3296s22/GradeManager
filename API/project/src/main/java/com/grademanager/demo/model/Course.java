package com.grademanager.demo.model;
import java.time.LocalDate;
import java.util.UUID;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import java.util.ArrayList;
import javax.persistence.*;

//@Entity
public class Course {

    private String dept;
    private int id;
    private String name;
    private double totalGrade;

    ArrayList<Quiz> quizList = new ArrayList<Quiz>();
    ArrayList<Assignment> assignmentList = new ArrayList<Assignment>();
    ArrayList<Exam> examList = new ArrayList<Exam>();

    // delete operation
    private int courseGrade;
 
    public Course(){}
    
    public Course(String dept, int id, String name){
        this.dept = dept;
        this.id = id;
        this.name = name;
    }
        public double calculateGrade(ArrayList<Quiz> quizList, ArrayList<Assignment> assignmentList, ArrayList<Exam> finalList){
        double quizScore = 0;
        double assignmentScore = 0;
        double examScore = 0;


        for(int i = 0; i < quizList.size(); i++){
            quizScore += quizList.get(i).getGrade();
        }
        for(int i = 0; i < assignmentList.size(); i++){
            assignmentScore += assignmentList.get(i).getGrade();
        }
        for(int i = 0; i < finalList.size(); i++){
            examScore += finalList.get(i).getGrade();
        }
        totalGrade = quizScore * quizList.get(0).getWeight()  + assignmentScore * assignmentList.get(0).getWeight() + examScore * finalList.get(0).getWeight();
        return totalGrade;
    }

    public void addQuiz(Quiz quiz){
        quizList.add(quiz);
    }
    public void addAssignment(Assignment assignment){
        assignmentList.add(assignment);
    }
    public void addFinal(Exam finalExam){
        examList.add(finalExam);
    }
    public String getDept() {
        return dept;
    }
    
    public void setDept(String dept) {
        this.dept = dept;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public double getCourseGrade() {
        return totalGrade;
    }
    
    public void setTotalGrade(double totalGrade) {
        this.totalGrade = totalGrade;
    }
}

