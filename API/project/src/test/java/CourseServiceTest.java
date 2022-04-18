

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

        


        Mockito.when(courseRepository.findById(Long.valueOf(1))).thenReturn(course1);

        Course retrievedCourse = courseService.getCourse(Long.valueOf(1));
        Assert.assertEquals(course, retrievedCourse);


    }
    
}
