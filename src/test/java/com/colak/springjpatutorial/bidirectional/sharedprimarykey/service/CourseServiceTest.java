package com.colak.springjpatutorial.bidirectional.sharedprimarykey.service;

import com.colak.springjpatutorial.bidirectional.sharedprimarykey.jpa.Course;
import com.colak.springjpatutorial.bidirectional.sharedprimarykey.jpa.CourseDetails;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@TestMethodOrder(value = MethodOrderer.OrderAnnotation.class)
class CourseServiceTest {

    @Autowired
    private CourseService courseService;

    @Test
    @Order(1)
    void save() {
        // Course is saved first, then CourseDetails
        Course course = new Course();
        course.setId(500L);
        course.setTitle("course1");

        CourseDetails courseDetails = new CourseDetails();
        courseDetails.setDescription("decription1");

        courseDetails.setCourse(course);
        course.setCourseDetails(courseDetails);

        Course result = courseService.save(course);
        assertNotNull(result);

        // Both Course and CourseDetails share the same primary key
        assertEquals(500L, result.getId());
        assertEquals(500L, result.getCourseDetails().getId());
    }
}