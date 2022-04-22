package com.grademanager.demo.model;
import javax.persistence.Id;

import lombok.Data;
import javax.persistence.*;


@Data
@Entity //annotation specifies that this Java class is mapped to the database table.
@Table(name="quizzes")

public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id;
    @Column(name="grade")
    private Integer grade;
    @Column(name="name")
    private String name;
    @Column(name="weight")
    public Integer weight = 20;

    @ManyToOne
    private Course course;



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
    public String getName() {
        return name;
    }
    
    /** 
     * @param name
     */
    public void setName(String name) {
        this.name = name;
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
     * @return int
     */
    public int getWeight(){
        return weight;
    }
    




}

