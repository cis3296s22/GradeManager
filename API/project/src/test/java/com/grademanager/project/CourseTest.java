package com.grademanager.project;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import java.util.Optional;
import com.grademanager.demo.controller.CourseController;
import com.grademanager.demo.model.Course;
import com.grademanager.demo.repository.CourseRepository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(MockitoJUnitRunner.class)
public class CourseTest{
    private MockMvc mockMvc;

   ObjectMapper objectMapper = new ObjectMapper();
   ObjectWriter objectWriter = objectMapper.writer();


//    should this by the service class instead?
   @Mock
   private CourseRepository courseRepository;

   @InjectMocks
   private CourseController courseController;


   Course course1 = new Course("CIS", "Data Structures", 25.0);
   Optional<Course> course1O = Optional.of(course1);
   Course course2 = new Course("CIS", "Math Concepts I", 75.0);
   Course course3 = new Course("MATH", "Calculus I", 95.0);

    // runs this method before every test
   @Before
   public void setUpMockito(){
       MockitoAnnotations.openMocks(this);
       this.mockMvc = MockMvcBuilders.standaloneSetup(courseController ).build();
    //    MockitoAnnotations.initMocks(this);
   }

   @Test
   public void getACourse() throws Exception{
    Long id = Long.valueOf(1);
    Mockito.when(courseRepository.findById(id)).thenReturn(course1O);

    MvcResult result = mockMvc.perform(MockMvcRequestBuilders
    .get("/api/v1/course/{id}", id)
    .contentType(MediaType.APPLICATION_JSON));
    // .andExpect(status().isOk())
    // .andExpect(jsonPath("$[0].dept").value("CIS")
    // );
    
    
    
   }



}