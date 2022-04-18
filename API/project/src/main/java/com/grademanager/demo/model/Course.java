package com.grademanager.demo.model;
import javax.persistence.Id;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //Assuming ID is auto incremented by database        
    private Long id;
    @Column(name="dept")
    private String dept;
    @Column(name="name")
    private String name;
    @Column(name="totalGrade")
    private Double totalGrade;

    @ManyToOne(cascade = CascadeType.ALL)
    private Semester semester;

    /*@OneToMany(mappedBy="courses", cascade = CascadeType.ALL, orphanRemoval = true, targetEntity = Quiz.class)
    private Set<Quiz> quizList;
    @OneToMany(targetEntity = Assignment.class)
    private Set<Assignment> assignmentList;
    @OneToMany(targetEntity = Exam.class)
    private Set<Exam> examList;*/


 
    public Course(){}
    
    public Course(String dept, String name){
        this.dept = dept;        
        this.name = name;
    }
        // public double calculateGrade(List<Quiz> quizList, List<Assignment> assignmentList, List<Exam> finalList){
        // double quizScore = 0;
        // double assignmentScore = 0;
        // double examScore = 0;


        // for(int i = 0; i < quizList.size(); i++){
        //     quizScore += quizList.get(i).getGrade();
        // }
        // for(int i = 0; i < assignmentList.size(); i++){
        //     assignmentScore += assignmentList.get(i).getGrade();
        // }
        // for(int i = 0; i < finalList.size(); i++){
        //     examScore += finalList.get(i).getGrade();
        // }
        // totalGrade = quizScore * quizList.get(0).getWeight()  + assignmentScore * assignmentList.get(0).getWeight() + examScore * finalList.get(0).getWeight();
        // return totalGrade;
    // }

    // public void addQuiz(Quiz quiz){
    //     quizList.add(quiz);
    // }
    // public void addAssignment(Assignment assignment){
    //     assignmentList.add(assignment);
    // }
    // public void addFinal(Exam finalExam){
    //     examList.add(finalExam);
    // }
    public String getDept() {
        return dept;
    }
    
    public void setDept(String dept) {
        this.dept = dept;
    }
    
    public Long getId() {
        return id;
    }
        
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public Double getCourseGrade() {
        return totalGrade;
    }
    
    public void setTotalGrade(Double totalGrade) {
        this.totalGrade = totalGrade;
    }
}


