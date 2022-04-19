package com.grademanager.demo.model;

import java.time.LocalDate;
import java.util.UUID;
import javax.persistence.*;
import javax.persistence.Id;
import java.util.List;
// To Do: Add semster object
         // Secure password ?
        
@Entity
@Table(name="students")

public class Student {
    @Id
    private Long studentId=UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
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
    private Integer age;

//instead of having a list with semester here, grab all the semesters using the student ID
//    separately
//    public ArrayList<Semester> semesterList= new ArrayList<Semester>();

//    public void addSemester(Semester semester){
//        semesterList.add(semester);
//    }

    //    Student => Semesters -> Courses -> Assignments, Quizzes, Exams
//    @OneToMany( targetEntity = Course.class)
    @OneToMany(mappedBy="student",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public List<Semester> semesterList;
//    private List<Course> courses = new ArrayList<Course>();
    


    public Student(){}
    
    public Student(String firstName, String lastName, int age, String email, LocalDate birthday){
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
        this.birthday = birthday;
        
    }

    
    /** 
     * @return long
     */
    public long getStudentId() {
        return this.studentId;
    }
    
    /** 
     * @return String
     */
    public String getFirstName(){
        return this.firstName;
    }
    
    /** 
     * @return String
     */
    public String getLastName(){
        return this.lastName;
    }

    
    /** 
     * @return String
     */
    public String getName() {
        return this.firstName + this.lastName;
    }

    
    /** 
     * @return Integer
     */
    public Integer getAge() {
        return this.age;
    }

    
    /** 
     * @return String
     */
    public String getEmail() {
        return this.email;
    }

    
    /** 
     * @return LocalDate
     */
    public LocalDate getBirthday() {
        return this.birthday;
    }

    
    /** 
     * @param id
     */
    public void setStudentId(Long id) {
        this.studentId = id;
        //UUID uniqueKey = UUID.randomUUID();
        //this.studentId = uniqueKey.toString();
    }

    
    /** 
     * @param name
     */
    public void setFirstName(String name) {
        this.firstName = name;
    }
    
    /** 
     * @param name
     */
    public void setLastName(String name) {
        this.lastName = name;
    }


    
    /** 
     * @param age
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    
    /** 
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    
    /** 
     * @param birthday
     */
    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    
    /** 
     * @return String
     */
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
  
    
    /** 
     * @param semester
     */
    //public ArrayList<Semester> semesterList= new ArrayList<Semester>();

    public void addSemester(Semester semester){
        semesterList.add(semester);
    }
}
