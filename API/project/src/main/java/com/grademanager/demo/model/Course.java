package com.grademanager.demo.model;
import javax.persistence.Id;
import lombok.Data;
import java.util.List;
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

    @ManyToOne
    @JoinColumn(name = "semester_id")
    private Semester semester;

    @OneToMany(mappedBy = "course",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public List<Quiz> quizList;

    @OneToMany(mappedBy = "course",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public List<Assignment> assignmentList;

    @OneToMany(mappedBy = "course",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public List<Exam> examList;

 
    public Course(){}
    
    public Course(String dept, String name, Double totalGrade){
        this.dept = dept;        
        this.name = name;
    }
    /**
     *  calculates the grade for a course via the quizList, assignmentList and examList 
     * @param quizList - An array List consisting of Quiz Objects
     * @param assignmentList - An array List consisting of Assignment Objects
     * @param examList - An array List consisting of Exam Objects
     * @return double - a exam grade associated tos weights
     */
    public double calculateGrade(List<Quiz> quizList, List<Assignment> assignmentList, List<Exam> examList){
        double quizScore = 0;
        double assignmentScore = 0;
        double examScore = 0;

        for (int i = 0; i < quizList.size(); i++){
            quizScore += quizList.get(i).getGrade();
        }
        for(int i = 0; i < assignmentList.size(); i++){
            assignmentScore += assignmentList.get(i).getGrade();
        }
        for(int i = 0; i < examList.size(); i++){
            examScore += examList.get(i).getGrade();
        }
        totalGrade = quizScore * quizList.get(0).getWeight()  + assignmentScore * assignmentList.get(0).getWeight() + examScore * examList.get(0).getWeight();
        return totalGrade;
    }

    
    /** 
     * @return String
     */
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
    
    
    /** 
     * @param dept
     */
    public void setDept(String dept) {
        this.dept = dept;
    }
    
    
    /** 
     * @return Long
     */
    public Long getId() {
        return id;
    }
        
    
    /** 
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }
    
    
    /** 
     * @return String
     */
    public String getName() {
        return name;
    }
    
    
    /** 
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }
    

    public void setSemester(Semester semester) {
        this.semester = semester;
    }

    /** 
     * @return Double
     */
    public Double getCourseGrade() {
        return totalGrade;
    }
    
    
    /** 
     * @param totalGrade
     */
    public void setTotalGrade(Double totalGrade) {
        this.totalGrade = totalGrade;
    }    

    public void addQuiz(Quiz quiz){
        quizList.add(quiz);
    }

    public void addAssignment(Assignment assignment){
        assignmentList.add(assignment);
    }
    public void addExam(Exam exam){
        examList.add(exam);
    }
    
}


