package com.aryanp45.courseservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aryanp45.courseservice.model.Course;
import java.util.List;
import java.util.Optional;


@Repository
public interface CourseRepository extends JpaRepository<Course, Long>{
	Optional<Course> findByCourseCode(String courseCode);
	void deleteByCourseCode(String courseCode);
}
