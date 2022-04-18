package com.grademanager.project;

import java.util.Optional;

// import com.grademanager.*;
import com.grademanager.demo.model.Course;
import com.grademanager.demo.repository.CourseRepository;
import com.grademanager.demo.service.CourseService;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class CourseServiceTest {

    @Mock
    private static CourseRepository courseRepository;

    @InjectMocks
    private static CourseService courseService = new CourseService();

    private static Course course;

    @Test
    public void getCourseByIdTest(){
        course = new Course();
        course.setId(Long.valueOf(1));
        course.setDept("CIS");
        course.setName("Data Structures");
        Optional<Course> course1 = Optional.of(course);
        
        // mocking when the course repository returns the optional course to the courseservice
        Mockito.when(courseRepository.findById(Long.valueOf(1))).thenReturn(course1);

        Course retrievedCourse = courseService.getCourse(Long.valueOf(1));
        Assert.assertEquals(course, retrievedCourse);

    }

    @Test
    public void createCourseTest(){
        course = new Course();
        course.setId(Long.valueOf(2));
        course.setDept("MATH");
        course.setName("Math Concepts I");
        
        // Optional<Course> course2 = Optional.of(course);

        Mockito.when(courseRepository.save(course)).thenReturn(course);
        
        Course retrievedCourse = courseService.createCourse(course);
        Assert.assertEquals(course, retrievedCourse);
        
    }

    // getAllCourses not implemented

//GOING TO FAIL
    @Test
    public void deleteCourseTest(){
       
        // NEITHER the repo nor the service retusn anything....
        Assert.assertEquals(true,false);        
    }


    // HAVE TO CHANGE HOW COURSE IS UPDATED (TO PUT)...
    @Test
    public void updateCourseTest(){
        // should return the updated course
        course = new Course();
        course.setId(Long.valueOf(892));
        course.setDept("ART");
        course.setName("Painting");

        // Mockito.when(courseRepository.
        
        // have the course update it and then they shouldn't be teh same anymore?



    }
    
    
}
