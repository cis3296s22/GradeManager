<<<<<<< Updated upstream
package com.grademanager.project;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.grademanager.demo.model.Student;
import com.grademanager.demo.service.StudentService;

//import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;
import org.springframework.http.ResponseEntity;



public class studentTest {
    Student student = new Student();
    StudentService studentService = new StudentService();
      student.setFirstName("Jack");
      student.setLastName("Lantern");
      student.setAge(17);
      student.setEmail("jack@gmail.com");
  @BeforeAll
  public static void init() {
      
  }

  @Test
  public void testStudentCreation() {
    ResponseEntity<Student> newStudent = studentService.createStudent(student);
    assertNotNull(newStudent.getBody().getStudentId());
    assertTrue(newStudent.getBody().getFirstName().equals(student.getFirstName()));
    assertTrue(newStudent.getBody().getLastName().equals(student.getLastName()));
    assertTrue(newStudent.getBody().getEmail().equals(student.getEmail()));
    assertEquals(newStudent.getBody().getAge(), student.getAge());


  }
  
    
}
=======
// package com.grademanager.project;

// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.junit.jupiter.api.Assertions.assertNotNull;
// import static org.junit.jupiter.api.Assertions.assertTrue;

// import com.grademanager.demo.model.Student;
// import com.grademanager.demo.service.StudentService;

// //import org.junit.jupiter.api.Test;
// import org.junit.jupiter.api.*;
// import org.springframework.http.ResponseEntity;



// public class studentTest {
//     Student student = new Student();
//     StudentService studentService = new StudentService();
//       student.setFirstName("Jack");
//       student.setLastName("Lantern");
//       student.setAge(17);
//       student.setEmail("jack@gmail.com");
//   @BeforeAll
//   public static void init() {
      
//   }

//   @Test
//   public void testStudentCreation() {
//     ResponseEntity<Student> newStudent = studentService.createStudent(student);
//     assertNotNull(newStudent.getBody().getStudentId());
//     assertTrue(newStudent.getBody().getFirstName().equals(student.getFirstName()));
//     assertTrue(newStudent.getBody().getLastName().equals(student.getLastName()));
//     assertTrue(newStudent.getBody().getEmail().equals(student.getEmail()));
//     assertEquals(newStudent.getBody().getAge(), student.getAge());


//   }
  
    
// }
>>>>>>> Stashed changes


