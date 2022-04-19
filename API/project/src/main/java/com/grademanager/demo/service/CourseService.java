package com.grademanager.demo.service;

import java.util.Optional;
// import org.springframework.http.ResponseEntity;
import com.grademanager.demo.model.Course;
import com.grademanager.demo.repository.CourseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
//@Log4j2
public class CourseService {

    @Autowired
    CourseRepository courseRepository;

    /**
     * @param Course - an Course object that would is to be saved in the CourseRepository
     * @return Course - the Course object that is now saved in the CourseRepository
     */
    public Course createCourse(Course course){
        return courseRepository.save(course);
    }

    /**
     * @param id - the unique ID associated to the Course object
     * @return an optional Course object if found with the associated id
     */
    public Course getCourse(Long id){        
      Optional <Course> optionalCourse = courseRepository.findById(id);
        if(!optionalCourse.isPresent()){
            String err = String.format("The course having ID %s was not found", id);
            System.out.println(err);
            // doesn't handle not finding the course rn
        }
        return optionalCourse.get();
    }

    /**
     * @return list of Course associated to the user
     */
    public List<Course> getAllCourses(){
        List<Course> courses = new ArrayList<>();
        courseRepository.findAll().forEach(courses::add);
        return courses;
    }

    /**
     * @param id - the unique ID associated to the Course object
     */ 
    public void deleteCourse(Long id){
        courseRepository.deleteById(id);
    }

    /**
     * @param Course, id - the Course object, the unique ID associated to the Course object
     * @return the Course object that is now saved in the CourseRepository
     */
    public Course updateCourse(Course course, Long id){
        if(courseRepository.findById(id).isPresent()){
            Course oldCourse = courseRepository.findById(id).get();

            // String dept String name double totalGrade
            String dept = (course.getDept() != null) ? course.getDept() : oldCourse.getDept();
            oldCourse.setDept(dept); 

            String name = (course.getName() != null) ? course.getName() : oldCourse.getName();
            oldCourse.setName(name);

            Double totalGrade = (course.getCourseGrade() != null) ? course.getCourseGrade() : oldCourse.getCourseGrade();
            oldCourse.setTotalGrade(totalGrade);
            
            course.setId(id);
        }

        return courseRepository.save(course);
    }
}
