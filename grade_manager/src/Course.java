public class Course {

    private String dept;
    private int id;
    private String name;
    private int courseGrade;
    
    public Quiz quiz;
    public Assignment assignment;
    public Final finalExam;
    
    public Course(){}
    
    public Course(String dept, int id, String name){
        this.dept = dept;
        this.id = id;
        this.name = name;
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
    
    public int getCourseGrade() {
        return courseGrade;
    }
    
    public void setCourseGrade(int courseGrade) {
        this.courseGrade = courseGrade;
    }
}

