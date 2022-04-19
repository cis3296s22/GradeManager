package com.grademanager.demo.model;
import javax.persistence.*;
import lombok.Data;
import javax.persistence.Id;

@Data
@Entity
@Table(name="exams")
public class Exam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id;
    @Column(name="grade")
    private Integer grade;
    @Column(name="weight")
    public Integer weight = 30;
    @Column(name="name")
    private String name;

    @ManyToOne
    private Course course;

    public Exam(){}

    public Exam(String name, Integer grade){
        this.name = name;
        this.grade = grade;
    }

    
    /** 
     * @return Long
     */
    public Long getId(){
        return this.id;
    }
    
    /** 
     * @param id
     */
    public void setId(Long id){
        this.id = id;
    }

    
    /** 
     * @return Integer
     */
    public Integer getGrade() {
        return grade;
    }

    
    /** 
     * @param grade
     */
    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    
    /** 
     * @return Integer
     */
    public Integer getWeight(){
        return weight;
    }
    
    
    /** 
     * @return String
     */
    public String getName(){
        return name;
    }
    
    /** 
     * @param name
     */
    public void setName(String name){
        this.name = name;
    }
}
