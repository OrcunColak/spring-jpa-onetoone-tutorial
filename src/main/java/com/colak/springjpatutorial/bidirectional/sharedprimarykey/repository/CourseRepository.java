package com.colak.springjpatutorial.bidirectional.sharedprimarykey.repository;

import com.colak.springjpatutorial.bidirectional.sharedprimarykey.jpa.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
