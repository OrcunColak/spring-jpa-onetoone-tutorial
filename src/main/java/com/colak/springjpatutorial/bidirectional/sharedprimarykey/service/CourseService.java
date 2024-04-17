package com.colak.springjpatutorial.bidirectional.sharedprimarykey.service;

import com.colak.springjpatutorial.bidirectional.sharedprimarykey.jpa.Course;
import com.colak.springjpatutorial.bidirectional.sharedprimarykey.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;

    @Transactional
    public Course save(Course course) {
        return courseRepository.save(course);
    }

}
