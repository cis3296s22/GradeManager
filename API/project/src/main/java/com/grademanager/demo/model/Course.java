package com.grademanager.demo.model;
import java.util.ArrayList;
import javax.persistence.*;

@Entity
@Table(name="courses")
public class Course {

   // @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //Assuming ID is auto incremented by database
    private int id;
    @Column(name="dept")
    private String dept;
    @Column(name="name")
    private String name;
    @Column(name="totalGrade")
    private double totalGrade;

    @ManyToOne
    private Semester semester;

    @OneToMany(mappedBy="courses", cascade = CascadeType.ALL, orphanRemoval = true, targetEntity = Quiz.class)
    ArrayList<Quiz> quizList = new ArrayList<Quiz>();
    @OneToMany(targetEntity = Assignment.class)
    ArrayList<Assignment> assignmentList = new ArrayList<Assignment>();
    @OneToMany(targetEntity = Exam.class)
    ArrayList<Exam> examList = new ArrayList<Exam>();


 
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

