package com.grademanager.project;

import java.util.Optional;

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
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest(classes = CourseServiceTest.class)
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
    // @Test
    // public void deleteCourseTest(){
       
    //     // NEITHER the repo nor the service retusn anything....
    //     Assert.assertEquals(true,false);        
    // }


   
    // @Test
    // public void updateCourseTest(){
    //     // should return the updated course
    //     course = new Course();
    //     course.setId(Long.valueOf(892));
    //     course.setDept("ART");
    //     course.setName("Painting");
    //     Assert.assertEquals(true, false);


    //     // Mockito.when(courseRepository.
        
    //     // have the course update it and then they shouldn't be teh same anymore?

    // }

    @Test 
    public void getAllCoursesTest(){
        Course course1 = new Course();
        course1.setId(Long.valueOf(2));
        course1.setDept("MATH");
        course1.setName("Math Concepts I");

        Course course2 = new Course();
        course2.setId(Long.valueOf(1));
        course2.setDept("CIS");
        course2.setName("Data Structures");

        Course course3 = new Course();
        course3.setId(Long.valueOf(1));
        course3.setDept("CIS");
        course3.setName("Data Structures");

        List<Course> courses = new ArrayList<>(Arrays.asList(
            course1, course2, course3
        ));
        
        Mockito.when(courseRepository.findAll()).thenReturn(courses);
        
        List<Course> retrievedCourses = courseService.getAllCourses();
        Assert.assertEquals(courses, retrievedCourses);



    }
    
    
}
