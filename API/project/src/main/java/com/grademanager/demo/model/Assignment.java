package com.grademanager.demo.model;
import javax.persistence.*;
import javax.persistence.Id;
import lombok.Data;

@Data
@Entity
@Table(name="assignments")
public class Assignment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //Assuming ID is auto incremented by database
    private Long id;
    @Column(name="grade")
    private Integer grade;
    @Column(name="name")
    private String name;
    @Column(name="weight")
    public Integer weight = 50;


    @ManyToOne
    private Course course;

    public Assignment(){}

    public Assignment(Integer grade, String name){
        this.grade = grade;
        this.name = name;        
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
     * @return String
     */
    public String getName(){
        return this.name;
    }
    
    /** 
     * @param name
     */
    public void setName(String name){
        this.name = name;
    }

    
    /** 
     * @param id
     */
    public void setId(Long id){
        this.id = id;
    }
    
    /** 
     * @return Long
     */
    public Long getId(){
        return this.id;
    }
    
    
    /** 
     * @return int
     */
    public int getWeight(){
        return this.weight;
    }
}
